package mvc

class SpoofController {

    def index() {
        def result = request.getHeader("USER-AGENT")
        def myLayout = "main"
        println result
        if (result.contains("Safari"))  {
            myLayout = "safari"
        }
        render view: "index", model:[layout: myLayout]
    }
}
