package mvc

import grails.validation.Validateable

class InPlaceCalculatorController {

    def calc(CalculatorModel model) {
        model.en     = Math.round(model.en   * 10) / 10
        model.exam   = Math.round(model.exam * 10) / 10
        model.result = Math.round((model.en + model.exam) / 2).toString()
        if (0.0 == model.en) {
            model.result = "Cannot calculate. En value was invalid."
        }
        if (0.0 == model.exam) {
            model.result = "Cannot calculate. Exam value was invalid."
        }
        render view:'calc', model: [model:model]
    }


}

class CalculatorModel implements Validateable {
    double en     = 0.0
    double exam   = 0.0
    String result = ""

    static constraints = {
        en   min:1d, max:6d, matches: /\d\.\d/
        exam min:1d, max:6d, matches: /\d\.\d/
        result nullable:true
    }
}
