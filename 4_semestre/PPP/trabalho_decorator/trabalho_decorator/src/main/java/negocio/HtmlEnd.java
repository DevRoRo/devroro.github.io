package negocio;

public class HtmlEnd extends HtmlDecorator {

    public HtmlEnd (HtmlDocument htmlDocument) {
        super(htmlDocument);
        this.script = "</body>\n"+
        "</html>";
    }
}
