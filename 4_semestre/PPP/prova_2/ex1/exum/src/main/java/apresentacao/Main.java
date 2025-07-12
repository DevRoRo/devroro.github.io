package apresentacao;

import negocio.Banana;
import negocio.Chocolate;
import negocio.CoberturaMorango;
import negocio.Sorvete;
import negocio.SorveteBaunilha;

//Utilizado padrão decorator no exercício 1

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Sorvete sorvete;
        sorvete = new SorveteBaunilha();
        sorvete = new CoberturaMorango(sorvete);
        sorvete = new Banana(sorvete);
        sorvete = new Chocolate(sorvete);

        System.out.println(sorvete.build());
    }       
}