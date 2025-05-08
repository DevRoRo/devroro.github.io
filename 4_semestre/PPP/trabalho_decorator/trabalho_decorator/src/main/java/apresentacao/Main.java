package apresentacao;

import negocio.HtmlStart;
import negocio.HtmlA;
import negocio.HtmlBr;
import negocio.HtmlDiv;
import negocio.HtmlDocument;
import negocio.HtmlEnd;
import negocio.HtmlImg;
import negocio.HtmlLi;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        HtmlDocument document = new HtmlStart("teste");
        document = new HtmlDiv(document);
        document = new HtmlImg(document);
        document = new HtmlBr(document);
        document = new HtmlA(document);
        document = new HtmlLi(document);
        document = new HtmlEnd(document);

        System.out.println(document.build());
    }       
}