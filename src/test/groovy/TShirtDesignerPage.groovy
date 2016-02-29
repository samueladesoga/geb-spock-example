import geb.Page

class TShirtDesignerPage extends Page{
    static at = {title == 'Yangah.com | TShirt Designer Tool'}

    static content = {
        graphicWithUrl {partialUrl -> $('image', href: contains(partialUrl))}
        linkFor(wait: true) { graphicName -> $('li', text: contains(graphicName))}
    }
}
