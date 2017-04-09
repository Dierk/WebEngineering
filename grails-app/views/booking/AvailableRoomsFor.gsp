<html>
<head>
  <meta name="layout" content="main">
  <title>Available Rooms For</title>
</head>
<body>

Available Rooms:
<ul>
<g:each var="room" in="${rooms}">
  <li>${room}</li>
</g:each>
</ul>

</body>
</html>