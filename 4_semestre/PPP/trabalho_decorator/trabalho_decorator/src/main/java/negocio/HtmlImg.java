package negocio;

public class HtmlImg extends HtmlDecorator {

    public HtmlImg (HtmlDocument htmlDocument) {
        super(htmlDocument);
        this.script = "<img>\n"+
        "</img>\n";
        System.out.println("teste htmlimg");
    }
    
}
