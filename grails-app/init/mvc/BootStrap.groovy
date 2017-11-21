package mvc

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        if (Environment.current == Environment.PRODUCTION) {
            return
        }

        Room windowRoom = new Room(name: "1.333", max: 32).save(failOnError: true)
        Room cornerRoom = new Room(name: "1.331", max: 42).save(failOnError: true)

        Person dierk = new Person(firstName: "Dierk", lastName: "König", email:"dierk.koenig@fhnw.ch").save(failOnError:true)

        Date today = new Date().clearTime();
        new Booking(booker: dierk, room: windowRoom, date: today - 1, slot: "08:00 - 11:00").save(failOnError: true)
        new Booking(booker: dierk, room: windowRoom, date: today, slot: "08:00 - 11:00").save(failOnError: true)
        new Booking(booker: dierk, room: windowRoom, date: today + 1, slot: "08:00 - 11:00").save(failOnError: true)
        new Booking(booker: dierk, room: cornerRoom, date: today , slot: "12:00 - 15:00").save(failOnError: true)

    }

    def destroy = {
    }
}
