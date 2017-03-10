package mvc

import grails.validation.Validateable

class InPlaceCalculatorController {

    def calc(CalculatorModel calcModel) {
        calcModel.en     = Math.round(calcModel.en   * 10) / 10
        calcModel.exam   = Math.round(calcModel.exam * 10) / 10
        calcModel.result = Math.round((calcModel.en + calcModel.exam) / 2)
        if (calcModel.errors.fieldErrors.any {it.field == "en"}) {
            calcModel.result = "Cannot calculate. En value was invalid."
            calcModel.en_error = "error"
            calcModel.en_error_message = "value '$calcModel.en' is not valid, must be between 1.0 and 6.0."
        }
        if (0.0 == calcModel.exam) {
            calcModel.result = "Cannot calculate. Exam value was invalid."
        }
        render view:'calc', model: [calculatorInstance: calcModel]
    }


}

class CalculatorModel implements Validateable {
    double en     = 0.0
    double exam   = 0.0
    String result = ""

    String en_error = ""
    String en_error_message = ""

    static constraints = {
        en   min:1d, max:6d, scale:1
        exam min:1d, max:6d, scale:1
        result nullable:true
    }
}
