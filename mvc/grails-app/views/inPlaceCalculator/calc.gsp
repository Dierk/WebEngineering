<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <title>
    In-Place Calculator
  </title>
  <style>
    label {  /* labels should go left of the input fields with fixed width such that the inputs align vertically */
      display: block;
      float: left;
      clear: left;
      width: 7em;
    }
    input {
      display: block;
      float: left;
      clear: right;
    }
    .error { /* only change properties that do not change position or size. Keep the UI stable. */
      border-color: red;
    }
    .padded { /* for vertical alignment of fieldset and result */
      padding: 1em;
      margin: 0px;
    }
  </style>
</head>

<body>

<h1>In-Place Calculator</h1>

<form action="/inPlaceCalculator/calc" method="get">
  <fieldset class="form padded">

    <tmpl:form_row name="en"   label="En"   calculatorInstance="${calculatorInstance}" />

    <tmpl:form_row name="exam" label="Exam" calculatorInstance="${calculatorInstance}" />

    <div>
      <label>&nbsp;</label>
      <input type="submit" value="Calculate"/>
    </div>
  </fieldset>
</form>


<div class="padded">
  <label>Result</label>
  <mvc:decorate grade="${calculatorInstance.result}">
    <output>${calculatorInstance.result}</output>
  </mvc:decorate>
</div>


</body>
</html>

