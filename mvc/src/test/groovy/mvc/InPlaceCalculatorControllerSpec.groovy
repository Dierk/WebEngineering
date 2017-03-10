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
        when:
            def model = new CalculatorModel(en:en, exam:exam)
            model.validate() // Grails does that automatically
            controller.calc(model)
        then: "average calculation"
            model.result == result
            model.en_error == ""
            model.en_error_message == ""
            model.exam_error == ""
            model.exam_error_message == ""
        where:
            en  | exam | result
            1.0 | 2.0  | "2"
            2.0 | 1.0  | "2"
            1.0 | 1.9  | "1"
    }

    void "validation errors lead to error class and error message"() {
        when:
            def model = new CalculatorModel(en: 0d, exam: 7d)
            model.validate() // Grails does that automatically
            controller.calc(model)
        then: "average calculation"
            model.result == "Cannot calculate. Input data was invalid."
            model.en_error == "error"
            model.en_error_message.size() > 0
            model.exam_error == "error"
            model.exam_error_message.size() > 0
    }
}
