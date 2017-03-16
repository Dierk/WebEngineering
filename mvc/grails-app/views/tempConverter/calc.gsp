<html>
<head>
  <meta name="layout" content="form"/>
  <title>
    Temperature Converter
  </title>
  <style>
    output { margin-left: 2em;}
  </style>
</head>

<body>

<form action="/tempConverter/convert" method="get">
  <fieldset class="form padded">

    <tmpl:form_row name="celsius"    label="Celsius"    conversion="converted_celsius"    model="${temperatures}" />

    <tmpl:form_row name="fahrenheit" label="Fahrenheit" conversion="converted_fahrenheit" model="${temperatures}" />

    <div>
      <label>&nbsp;</label>
      <input type="submit" value="Convert"/>
    </div>
  </fieldset>
</form>


</body>
</html>

