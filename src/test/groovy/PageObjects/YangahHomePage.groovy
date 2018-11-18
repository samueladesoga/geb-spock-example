package PageObjects

import geb.Page

class YangahHomePage extends Page {

    static at = {title == "Yangah | Nigeria's 1st Custom Designed TShirts"}
    static url = '/'

    static content = {
        navigationModule { module NavigationModule}
        designModule { module DesignModule }
    }
}
