package negocio;

public class HtmlLi extends HtmlDecorator {

    public HtmlLi(HtmlDocument htmlDocument) {
        super(htmlDocument);
        this.script = "<li>\n"+
        "</li>\n";
    }
    
}
