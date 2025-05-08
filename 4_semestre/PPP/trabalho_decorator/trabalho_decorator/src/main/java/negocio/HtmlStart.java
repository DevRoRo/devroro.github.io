package negocio;

public class HtmlStart extends HtmlDocument {
  
  public HtmlStart(String titulo){
    this.script = "<html>\n"+
    "<title>\n"+ titulo + "\n</title>\n"+
    "<body>\n";
  }
}
