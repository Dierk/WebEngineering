package mvc

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RoomController {

    static scaffold = Room

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def listOfRooms = Room.list(params)
        for(Room room : listOfRooms) {
            room.message = message(code: "beispiel")
        }
        respond listOfRooms, model:[roomCount: Room.count()]
    }
}
