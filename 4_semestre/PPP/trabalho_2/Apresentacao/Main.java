package Apresentacao;

import Negocio.Leiloeiro;
import Negocio.Participante;

public class Main {
    public static void main(String[] args) {
        Leiloeiro leiloeiro = new Leiloeiro("Igor", "Prótese p/ cirurgia de joelho");
        String[] listaNomeParticipantes = {"Ronaldo", "Fulano", "Ciclano", "Beltrano", "Tetraclano"};
        Participante[] listaParticipantes = new Participante[listaNomeParticipantes.length];

        for (int i = 0; i < listaParticipantes.length; i++) {
            listaParticipantes[i] = new Participante(listaNomeParticipantes[i]);    
        }

        for (int i = 0; i < listaParticipantes.length; i++) {
            leiloeiro.addObserver(listaParticipantes[i]);
        }

        System.out.println(leiloeiro.toString());

        listaParticipantes[2].realizarLance(leiloeiro, 100);
        listaParticipantes[0].realizarLance(leiloeiro, 150);
        listaParticipantes[4].realizarLance(leiloeiro, 150);
        listaParticipantes[0].realizarLance(leiloeiro, 200);

        leiloeiro.encerrarLeilao();
    }
}
