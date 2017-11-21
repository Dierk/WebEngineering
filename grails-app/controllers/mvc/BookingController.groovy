package mvc

class BookingController {

    static scaffold = Booking

    def forDierk() {
	    Person dierk = Person.findByEmail("dierk.koenig@fhnw.ch")
	    List<Booking> result = Booking.findAllByBooker(dierk);
	    render text: result.toString()
    }

	def all() {
		respond Booking.list()
	}

    def freeTodayMorning() {
	
		// allRooms = find all rooms	
		List<Room> allRooms = Room.findAll()
		
		// allBookings for this morning
		Date today = new Date().clearTime()
		String morning = Booking.AM
		List<Booking> allBookingsThisMorning = Booking.findAllByDateAndSlot(today, morning);
		
		// allRoomsBookedThisMorning
		List<Room> allRoomsBookedThisMorning = allBookingsThisMorning*.room
		
		List<Room> result = allRooms - allRoomsBookedThisMorning
	
	    respond result
    }

}
