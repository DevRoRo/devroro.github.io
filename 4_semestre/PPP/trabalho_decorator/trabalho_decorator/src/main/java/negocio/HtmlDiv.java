package negocio;

public class HtmlDiv extends HtmlDecorator{

    public HtmlDiv (HtmlDocument htmlDocument) {
        super(htmlDocument);
        this.script = "<div>\n"
        +"</div>\n";
    }
}

