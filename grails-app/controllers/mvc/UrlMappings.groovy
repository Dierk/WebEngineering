package mvc

class UrlMappings {

    static mappings = {

        "/rooms"(resources: "room")
        "/people"(resources: "person")
        "/bookings"(resources: "booking")

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
