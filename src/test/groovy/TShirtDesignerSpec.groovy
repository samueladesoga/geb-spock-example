import geb.spock.GebReportingSpec

class TShirtDesignerSpec extends GebReportingSpec {
    def "The products should be grouped by categories in product list api"(){
        given: "I make a call to the product url"
        to YangahHomePage

        then: "the products should be grouped by categories"
        at TShirtDesignerPage
        waitFor(10) {graphicWithUrl('follow_me_laugh').present}
    }
}
