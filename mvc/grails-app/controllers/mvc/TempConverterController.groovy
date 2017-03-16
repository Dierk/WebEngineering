package mvc

import grails.validation.Validateable

class TempConverterController {

    def convert(TempConverterModel tempModel) {
        // do the conversion
        tempModel.converted_celsius    = tempModel.celsius * 1.8d + 32
        tempModel.converted_fahrenheit = (tempModel.fahrenheit - 32) / 1.8d
        // round to one decimal place
        tempModel.converted_celsius    =  Math.round(tempModel.converted_celsius    * 10) / 10
        tempModel.converted_fahrenheit =  Math.round(tempModel.converted_fahrenheit * 10) / 10

        render view:'calc', model: [temperatures: tempModel]
    }

}

class TempConverterModel implements Validateable {
    double celsius              = 0.0
    double fahrenheit           = 0.0
    double converted_celsius    = 0.0
    double converted_fahrenheit = 0.0

    static constraints = {
        celsius                 nullable: false
        fahrenheit              nullable: false
        converted_celsius       nullable: true
        converted_fahrenheit    nullable: true
    }
}
