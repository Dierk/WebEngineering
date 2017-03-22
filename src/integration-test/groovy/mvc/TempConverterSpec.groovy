package mvc

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class TempConverterSpec extends GebSpec {

    void "Convert temperatures in place with a self-refreshing view"() {
        when:
            go '/TempConverter.html'
        then:
        	title == "Temperature Converter"

        when: "set valid input"
            $("form").celsius    = 42
            $("form").fahrenheit = 0
            $("input", type: "submit").click()

        then: "Result is displayed with proper rounding"
            $("output", 0).text() == "107.6"
            $("output", 1).text() == "-17.8"
    }

}
