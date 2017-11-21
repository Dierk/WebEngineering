package mvc

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
