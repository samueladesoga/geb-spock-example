import geb.Module

class DesignModule extends Module {
    static base = {$(".design-showcase")}
    static content = {
        linkFor { graphicName -> $('li', text: contains(graphicName))}
    }
}
