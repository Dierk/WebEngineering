package mvc

import grails.rest.Resource

@Resource
class Person {

    String firstName
    String lastName
    String email

    String toString() {
        return firstName + " " + lastName
    }

    static constraints = {
    }
}
