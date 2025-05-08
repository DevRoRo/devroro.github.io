package negocio;

public class HtmlA extends HtmlDecorator {

    public HtmlA(HtmlDocument htmlDocument) {
        super(htmlDocument);
        this.script = "<a>\n";
    }
    
}
