package SistemaLuta;

import Personagens.Personagem;

public class Luta {
    private static int contador;
    
        public static void lutaPorTurno (Personagem lutador1, Personagem lutador2) {
        Personagem lutadorAtacante;
        Personagem lutadorDefensor;

        if (contador % 2 == 0) {
            lutadorAtacante = lutador1;
            lutadorDefensor = lutador2;
        } else {
            lutadorAtacante = lutador2;
            lutadorDefensor = lutador1;
        }
        
        System.out.println(lutadorAtacante.getNome()+" ataca "+lutadorDefensor.getNome()+" com "+lutadorAtacante.getArmaEquipada().toString());
        lutadorAtacante.atacar(lutadorDefensor);

        contador++;
    }

    public static boolean encerraLuta (Personagem lutador1, Personagem lutador2) {
        if (lutador1.getVida() <= 0) {
            System.out.println(lutador1.getNome()+" Foi derrotado.");
            contador = 0;
            return true;
        } else if (lutador2.getVida() <= 0){
            System.out.println(lutador2.getNome()+" Foi derrotado.");
            contador = 0;
            return true;
        } else {
            return false;
        }
    }
}
