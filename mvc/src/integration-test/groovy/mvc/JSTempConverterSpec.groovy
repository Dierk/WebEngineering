package mvc

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import org.openqa.selenium.Keys

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class JSTempConverterSpec extends GebSpec {

    void "From celsius to fahrenheit with JavaScript"() {
        when:
            browser.driver.javascriptEnabled = true
            go '/static/Temperatures.html'
        then:
        	title == "Temperature Converter with JavaScript"

        when: "set celsius without clicking"
            $("form").celsius = "42"

        then: "the other field is updated immediately"
            $("form").fahrenheit  == "32"
    }

    // TODO: make a new test method for fahrenheit to celsius conversion

}
