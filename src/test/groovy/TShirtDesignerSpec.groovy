import geb.spock.GebReportingSpec
import groovy.json.JsonSlurper

class TShirtDesignerSpec extends GebReportingSpec {
    def "The products should be grouped by categories in product list api"(){
        given: "I connect to the root url"
        def root = new RestClientWrapper(browser.getBaseUrl())

        when: "i request the product url api"
        def resp = root.get("live_art_configs/products.json")

        then: "the  products are grouped by categories"
        assert resp['productCategoriesList'].size > 0
    }

    def "The should calculate the printing cost"(){
        given: "I connect to the root url"
        def root = new RestClientWrapper(browser.getBaseUrl())
        root.setHeaders('application/json')

        when: "i request the product url api"
        def jsonObj = new JsonSlurper().parseText('{"data":{"product":{"id":"n50p-na"},"locations":[{"name":"Front","colors":0,"isFullColor":false,"colorsNum":0,"colorsList":[],"objects":[{"type":"image","isUploaded":false,"id":"first-image-sam","colorsList":[],"colorsNum":0,"colors":0,"isFullColor":false}],"objectCount":1,"letterings":0,"images":1},{"name":"Back","colors":0,"isFullColor":false,"colorsNum":0,"colorsList":[],"objects":[],"objectCount":0,"letterings":0,"images":0}],"colorsList":[],"colors":0,"isFullColor":false,"colorsNum":0,"quantities":[{"size":"S","quantity":1}],"namesNumbers":[]}}')
        def resp = root.post("customizations/get_quote", jsonObj)

        then: "the  products are grouped by categories"
        assert resp['productCategoriesList'].size > 0
    }
}
