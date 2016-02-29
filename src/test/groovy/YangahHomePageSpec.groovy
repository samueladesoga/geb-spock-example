import geb.spock.GebReportingSpec

class YangahHomePageSpec extends GebReportingSpec {

    def "An image should be added to the TShirt Designer when it is clicked from the home page"(){
        given: "A user is on the yangah home page"
        to YangahHomePage

        when: "the user clicks any image displayed"
        at YangahHomePage
        designModule.linkFor('Follow Me Laugh').click()

        then: "the image should be loaded in the TShirt Designer"
        at TShirtDesignerPage
        waitFor(10) {graphicWithUrl('follow_me_laugh').present}
    }

    def "An image should be added to the TShirt Designer when it is clicked from the home page - failing test"(){
        given: "A user is on the yangah home page"
        to YangahHomePage

        when: "the user clicks any image displayed"
        at YangahHomePage
        designModule.linkFor('Follow Me Laugh').click()

        then: "the image should be loaded in the TShirt Designer"
        at TShirtDesignerPage
        waitFor(10) { graphicWithUrl('follow_me_laugh_failed').present}
    }
}
