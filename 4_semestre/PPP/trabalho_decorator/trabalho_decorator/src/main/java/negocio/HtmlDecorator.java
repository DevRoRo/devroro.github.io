package negocio;

public abstract class HtmlDecorator extends HtmlDocument {
    protected HtmlDocument htmlDocument;

    public HtmlDecorator(HtmlDocument htmlDocument) {
        this.htmlDocument = htmlDocument;
    }

    public String build () {
        return this.htmlDocument.build() + this.script;
    }
}
