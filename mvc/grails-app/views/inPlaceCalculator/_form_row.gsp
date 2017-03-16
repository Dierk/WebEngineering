<%--
 Emitting a single row of a form with label an input field.
 Params:
   name  : name to use for id, name, labelFor
   label : visible label
   calculatorInstance : the model
 Depends on the "validate" function from outside.
--%>

<div>
  <label for='${name}'>${label}</label>
  <input type="number decimal" name="${name}" value="${calculatorInstance.getProperty(name)}"
         required="true" min="1.0" max="6.0" id="${name}"
         class="${mvc.FieldUtil.hasError(calculatorInstance, name) ? 'error' : ''}"
         title="${g.message(error: mvc.FieldUtil.findError(calculatorInstance, name) ?: '') }"
         %{--onchange="validate(this);"--}%
  />
</div>
