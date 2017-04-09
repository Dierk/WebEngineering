package mvc

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import spock.lang.Unroll

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class BookingSpec extends GebSpec {


    void "See open bookings"() {
        when:
            go '/booking/search.html'
        then:
        	title == "Search Bookings"

        when: "click on booking search for person Dierk"
            $("a", text:"Dierk").click()

        then: "two bookings are displayed"
            title == "Open Bookings For"
            $("li").size() == 2
    }

    @Unroll
    void "There are #count available rooms for time slot #slot"(slot, count) {
        when:
            go '/booking/search.html'
        then:
        	title == "Search Bookings"

        when: "set valid input"
            $("a", text:slot).click()

        then:
            title == "Available Rooms For"
            $("li").size() == count

        where:
            slot          | count
            '08:15-12:00' | 0
            '12:15-15:00' | 1
            '15:15-18:00' | 2
    }
}
