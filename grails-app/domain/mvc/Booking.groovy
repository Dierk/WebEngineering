package mvc

import grails.rest.Resource

@Resource(uri="/booking")
class Booking {
    Room   room
    Person booker
    Date   day
    String timeSlot

    final static AM  = "08:15-12:00"
    final static PM1 = "12:15-15:00"
    final static PM2 = "15:15-18:00"

    String toString() {
        return booker.toString() + " booked room " + room.toString() + " at " + day + "/" + timeSlot
    }

    static constraints = {
        timeSlot inList: [AM, PM1, PM2]
    }
}
