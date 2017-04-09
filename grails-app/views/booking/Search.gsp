<html>
<head>
  <meta name="layout" content="main">
  <title>Search Bookings</title>
</head>

<body>
<div>
  Open bookings for
  <g:each var="person" in="${people}">
    <a href="openBookingsFor?id=${person.id}">${person.name}</a>
  </g:each>
  .
</div>

<div>
  Available rooms for today at time slot
  <g:each var="slot" in="${[mvc.Booking.AM, mvc.Booking.PM1, mvc.Booking.PM2]}" >
    <a href="availableRoomsFor?day=${new Date().format('yyyy-MM-dd')}&timeSlot=${slot}">${slot}</a>
  </g:each>
  .
</div>


</body>
</html>