package mvc

import grails.rest.Resource

@Resource
class Room {

    String name
    int    max

    String toString() {
        "$name ($max)"   // Groovy :-)
    }

    static constraints = {
        name(blank: false)
        max(min: 1)
    }
}
