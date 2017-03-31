package mvc

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(MultiplicationCircleController)
class MultiplicationCircleControllerSpec extends Specification {

    MultiplicationCircleController controller

    def setup() {
        controller = new MultiplicationCircleController()
    }

    @Unroll
    void "asking for #segments segments should provide #segments lines"(segments) {
        given:
            def model = new MultiplicationCircleModel(segmentCount: segments, tableBase: 2)
        when:
            controller.index(model)
        then:
            model.lines.size() == segments
        where:
            segments << [0, 1, 10, 100]
    }


}
