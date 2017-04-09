package mvc

class Room {
    String description
    int    capacity

    String toString() {
        return description + " (" + capacity + ")"
    }

    static constraints = {
    }
}
