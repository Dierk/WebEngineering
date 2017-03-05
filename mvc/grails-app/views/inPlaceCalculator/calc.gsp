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
      width: 7em;
    }
  </style>
</head>

<body>

<h1>In-Place Calculator</h1>


<form action="/inPlaceCalculator/calc" method="get">
  <fieldset class="form">
    <div>
      <label for='en'>En</label>
      <input type="number decimal" name="en" value="${model.en}"
             required="true" min="1.0" max="6.0" id="en"/>
    </div>

    <div>
      <label for='exam'>Exam</label>
      <input type="number decimal" name="exam" value="${model.exam}"
             required="true" min="1.0" max="6.0" id="exam"/>
    </div>

    <div>
      <input type="submit" value="Calculate"/>
    </div>
  </fieldset>
</form>


<div>
  <label>Result</label>
  <output>${model.result}</output>
</div>


</body>
</html>

