package mvc

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TempConverterController)
class TempConverterControllerSpec extends Specification {

    TempConverterController controller

    def setup() {
        controller = new TempConverterController()
    }

    @Unroll
    void "celsius conversion of #input should give #result"(input, result) {
        given:
            def model = new TempConverterModel(celsius: input)
        when:
            controller.convert(model)
        then:
            model.converted_celsius == result
        where:
            input | result
              0.0 |   32.0
            -32.0 |  -25.6
             42.0 |  107.6
            -17.8 |    0.0
    }

    @Unroll
    void "fahrenheit conversion of #input should give #result"(input, result) {
        given:
            def model = new TempConverterModel(fahrenheit: input)
        when:
            controller.convert(model)
        then:
            model.converted_fahrenheit == result
        where:
            input | result
              0.0 |  -17.8
            -25.6 |  -32.0
             32.0 |    0.0
    }


}
