package Negocio;

import java.util.ArrayList;
import java.util.List;

public class Leiloeiro implements Subject {
    private String nome;
    private String itemLeiloado;
    private List<Observer> participantes;

    public Leiloeiro(String nome, String itemLeiloado) {
        this.nome = nome;
        this.itemLeiloado = itemLeiloado;
        participantes = new ArrayList<Observer>();
    }

    public boolean lanceValido (float lance) {
        for (int i = 0; i < this.participantes.size(); i++) {
            if(participantes.get(i).getLance() >= lance) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    public Observer participanteMaiorlance(List<Observer> participantes) {
        Observer concorrente = null;

        for (int i = 0; i < participantes.size(); i++) {
            concorrente = participantes.get(i);
            for (int j = 0; j < participantes.size(); j++) {
                if(concorrente.getLance() < participantes.get(j).getLance()) {
                    concorrente = participantes.get(j);
                }
            }
        }


        return concorrente;
    }

    public void encerrarLeilao() {
        Observer vencedor = participanteMaiorlance(this.participantes);

        System.out.println("LEILÃO ENCERRADO.\n"+
        "Parabéns "+vencedor.getNome()+" por adquirir "+itemLeiloado+"\n"+
        "============================\n");
    }

    @Override
    public void addObserver(Observer observer) {
        participantes.add(observer);
    }

    @Override
    public void removeObserver(int indice) {
        participantes.remove(indice);
    }

    @Override
    public void notifyObservers(float lance) {
        for (int i = 0; i < participantes.size(); i++) {
            this.participantes.get(i).update(lance);
        }
    }

    @Override
    public String toString() {
        String string = "============================\n"+
        "Leiloeiro "+this.nome+"\n"+
        "============================\n"+
        "Participantes do leilão:\n";
        for (int i = 0; i < this.participantes.size(); i++) {
            string += participantes.get(i).getNome()+"\n";   
        }
        string += "============================\n"
        +"Item em display: "+this.itemLeiloado+"\n"+
        "============================";
        return string;
    }
}
