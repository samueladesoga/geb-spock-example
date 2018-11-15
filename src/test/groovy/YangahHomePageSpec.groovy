import geb.Browser
import geb.spock.GebReportingSpec

class YangahHomePageSpec extends GebReportingSpec {

    def "A user should be able to send a message to Yangah Admin for interest as a designer"(){
        given: "A user is on the yangah home page"
        to YangahHomePage

        when: "the user clicks any image displayed"
        at YangahHomePage
        navigationModule.linkFor('SUBMIT YOUR DESIGNS').click()

        then: "the user should be on the submit your graphics page"
        Browser.drive {
            //assert title == "Geb - Very Groovy Browser Automation"
            //$("#sidebar .sidemenu a", text: "jQuery-like API").click()
            assert $("h2").first().text() == "SUBMIT YOUR GRAPHIC DESIGNS - NEXT STEPS .."
            //assert $("#sidebar .sidemenu a", text: "jQuery-like API").parent().hasClass("selected")
        }
    }

    def "An image should be added to the TShirt Designer when it is clicked from the home page"(){
        given: "A user is on the yangah home page"
        to YangahHomePage

        when: "the user clicks any image displayed"
        at YangahHomePage
        designModule.linkFor('King').click()

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
