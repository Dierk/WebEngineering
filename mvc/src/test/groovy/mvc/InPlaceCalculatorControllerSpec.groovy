package mvc

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(InPlaceCalculatorController)
class InPlaceCalculatorControllerSpec extends Specification {

    InPlaceCalculatorController controller

    def setup() {
        controller = new InPlaceCalculatorController()
    }

    def cleanup() {
    }

    @Unroll
    void "valid average of #en and #exam should be #result"(en, exam, result) {
        given:
            def model = new CalculatorModel(en:en, exam:exam)
            model.validate() // Grails does that automatically
        when:
            controller.calc(model)
        then:
            model.result == result
        where:
            en  | exam | result
            1.0 | 2.0  | "2"
            2.0 | 1.0  | "2"
            1.0 | 1.9  | "1"
    }

    @Unroll
    void "invalid inputs (#errorCount): #failedProp wrong"(en, exam, errorCount, String failedProp) {
        given:
            def model = new CalculatorModel(en:en, exam:exam)
            model.validate() // Grails does that automatically
        when:
            controller.calc(model)
        then:
            model.result == "Cannot calculate. Input data was invalid."
            model.errors.fieldErrors.size() == errorCount
            FieldUtil.hasError(model, failedProp)
        where:
            en  | exam | errorCount | failedProp
            0.9 | 3.0  |          1 | "en"
            6.1 | 3.0  |          1 | "en"
            3.0 | 0.9  |          1 | "exam"
            3.0 | 6.1  |          1 | "exam"
            0.9 | 6.1  |          2 | "exam"
    }
}
