package mvc

class Room {
    String description
    int    capacity
    String message

//    static transients = ['message']

    String toString() {


        return description + " (" + capacity + ")" + message
    }

    static constraints = {
        message nullable: true
    }
}
