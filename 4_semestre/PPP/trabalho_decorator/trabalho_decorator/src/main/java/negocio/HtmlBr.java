package negocio;

public class HtmlBr extends HtmlDecorator {
    
    public HtmlBr (HtmlDocument htmlDocument) {
        super(htmlDocument);
        this.script = "<br>\n";
    }

}
