import groovyx.net.http.HTTPBuilder

class RestClientWrapper {
    def httpBuilder

    RestClientWrapper(url){
        httpBuilder = new HTTPBuilder(url)
    }

    def get(path, contentType){
        def resp = httpBuilder.get(path: path, contentType)
        resp
    }

    def post(path, body, requestContentType){
        def resp = httpBuilder.post(
                //[ status: msg, source: 'httpbuilder' ]
                path: path,
                body: body,
                requestContentType: requestContentType )
        resp
    }

}