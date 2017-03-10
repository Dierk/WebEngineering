<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <title>
    In-Place Calculator
  </title>
  <style>
    label {
      display: block;
      float:left;
      clear:left;
      width: 7em;
    }
    input {
      display:block;
      float:left;
      clear:right;
    }
    .error {
      border-color: red;
    }
    .padded {
      padding: 1em;
      margin: 0px;
    }
  </style>
</head>

<body>

<h1>In-Place Calculator</h1>


<form action="/inPlaceCalculator/calc" method="get">
  <fieldset class="form padded">
    <div>
      <label for='en'>En</label>
      <input type="number decimal" name="en" value="${calculatorInstance.en}"
             required="true" min="1.0" max="6.0" id="en"
             class="${calculatorInstance.en_error}"
             title="${calculatorInstance.en_error_message}"
      />
    </div>

    <div>
      <label for='exam'>Exam</label>
      <input type="number decimal" name="exam" value="${calculatorInstance.exam}"
             required="true" min="1.0" max="6.0" id="exam"/>
    </div>

    <div>
      <label>&nbsp;</label>
      <input type="submit" value="Calculate"/>
    </div>
  </fieldset>
</form>


<div class="padded">
  <label>Result</label>
  <output>${calculatorInstance.result}</output>
</div>


</body>
</html>

