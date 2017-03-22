package mvc

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CalculatorController)
class CalculatorControllerSpec extends Specification {

    CalculatorController calculatorController

    def setup() {
        calculatorController = new CalculatorController()
    }

    def cleanup() {
    }

    @Unroll
    void "average of #en and #exam should be #result"(en, exam, result) {
        when:
            calculatorController.calc(en, exam)
        then: "average calculation"
            model.result == result
        where:
            en  | exam | result
            0.0 | 0.0  | 0.0
            1.0 | 2.0  | 1.5
            2.0 | 1.0  | 1.5

    }
}
