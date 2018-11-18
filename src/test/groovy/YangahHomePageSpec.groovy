import PageObjects.ProductIndexPage
import PageObjects.GraphicIndexPage
import PageObjects.TShirtDesignerPage
import PageObjects.YangahHomePage
import geb.spock.GebReportingSpec

class YangahHomePageSpec extends GebReportingSpec {

    def "A user should be able to design their TShirt by clicking on a Product Image"(){
        given: "A user is on the yangah home page"
        to YangahHomePage

        when: "user navigates to the Product Index Page"
        at YangahHomePage
        navigationModule.linkFor('PRODUCTS').click()

        and: "the user clicks on the first Product Image"
        at ProductIndexPage
        def toBeClicked = products.first()
        def img = toBeClicked.parent().parent().parent().parent().find('img')
        def match = (img.@src =~ /https:\/\/\w+.cloudfront.net\/product\/(\d+)\/front_image\/.+/)
        match.find()
        def productId = match.group(1)
        toBeClicked.click()

        then: "the product should be displayed in the TShirt Designer Page"
        at TShirtDesignerPage
        //productDesignMatcher = /https:\/\/\w+.cloudfront.net\/product\/${productId}\/front_image\/medium.+/
        assert productWithId(31).isPresent


    }

    def "A user should be able to design their TShirt by click on a Graphic Image"(){
        given: "A user is on the yangah home page"
        to YangahHomePage

        when: "the user navigates on the Graphic Index Page"
        at YangahHomePage
        navigationModule.linkFor('GRAPHICS').click()

        and: "the user clicks on the first Graphic"
        at GraphicIndexPage
        graphics.first().click()

        then: "the image should be loaded in the TShirt Designer"
        at TShirtDesignerPage
        waitFor(10) {graphicWithUrl('follow_me_laugh').present}
    }

    def "A register should be able to register successfully providing the necessary parameters"(){
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
