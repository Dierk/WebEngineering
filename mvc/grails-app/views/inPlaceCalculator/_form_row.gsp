<%--
 Emitting a single row of a form with label an input field.
 Params:
   name  : name to use for id, name, labelFor
   label : visible label
   calculatorInstance : the model
--%>

<div>
  <label for='${name}'>${label}</label>
  <input type="number decimal" name="${name}" value="${calculatorInstance.getProperty(name)}"
         required="true" min="1.0" max="6.0" id="${name}"
         class="${calculatorInstance.errors.fieldErrors.any {it.field == name} ? 'error' : ''}"
         title="${g.message(error: calculatorInstance.errors.fieldErrors.find {it.field == name} ?: '') }"/>
</div>
