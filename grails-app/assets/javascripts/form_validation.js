// Validating an input field that accepts numerical values between 1.0 and 6.0

function validate(inputField) {
  if (handledError(inputField.value < 1.0, inputField, ' value needs to be at least 1.0'))
      return;
  if (handledError(inputField.value > 6.0, inputField, ' value needs to be at most 6.0'))
      return;
  inputField.setAttribute('class','');
}

function handledError(check, inputField, msg) {
  if (check) {
      inputField.setAttribute('class','error');
      alert(inputField.name + msg);
      inputField.focus();
  }
  return check;
}
