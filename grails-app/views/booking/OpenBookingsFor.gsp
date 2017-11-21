<html>
<head>
  <meta name="layout" content="main">
  <title>Open Bookings For</title>
</head>
<body>

Open Bookings:
<ul>
<g:each var="booking" in="${bookings}">
  <li>${booking}</li>
</g:each>
</ul>

</body>
</html>