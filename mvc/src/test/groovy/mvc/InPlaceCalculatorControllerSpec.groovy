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
    void "invalid input: #failureCase"(en, exam, String failureCase) {
        given:
            def model = new CalculatorModel(en:en, exam:exam)
            model.validate() // Grails does that automatically
        when:
            controller.calc(model)
        then:
            model.result == "Cannot calculate. Input data was invalid."
        where:
            en  | exam | failureCase
            0.9 | 3.0  | "en too small"
            6.1 | 3.0  | "en too big"
            3.0 | 0.9  | "exam too small"
            3.0 | 6.1  | "exam too big"
            0.9 | 6.1  | "combination: both wrong"
    }
}
