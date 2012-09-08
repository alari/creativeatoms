class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/rest/creativeAtom/$id"(resource: "restCreativeAtom")
        "/rest/creativeAtom"(controller: "restCreativeAtom", parseRequest: true) {
            action = [POST: "create"]
        }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
