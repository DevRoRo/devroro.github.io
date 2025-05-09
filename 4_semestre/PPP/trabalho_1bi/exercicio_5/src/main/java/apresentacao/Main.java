package apresentacao;

import java.util.Scanner;

import negocio.Frete;
import negocio.FreteConvencional;
import negocio.FreteSedex;
import negocio.FreteTransportadora;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        float distancia;
        float peso;
        boolean temCupom;
        Frete frete;

        System.out.println("==========Sistema de cálculo de fretes==========");

        System.out.println("Informe a distância: ");
        distancia = in.nextFloat();
        System.out.println("Informe o peso: ");
        peso = in.nextFloat();
        System.out.println("Possui cupom de desconto: 1 - Sim 2 - Não");
        int contador = in.nextInt();
        if (contador == 1) {
            temCupom = true;
        } else {
            temCupom = false;
        }

        System.out.println("Selecione a modalidade de frete:\n"+
        "1 - Convencional\n"+
        "2 - Sedex\n"+
        "3 - Transportadora privada\n");

        switch (in.nextInt()) {

            case 1:
                frete = new FreteConvencional();
                frete.mostrarFrete(distancia, peso, temCupom);
                break;

            case 2:
                frete = new FreteSedex();
                frete.mostrarFrete(distancia, peso, temCupom);
                break;
            
            case 3:
                frete = new FreteTransportadora();
                frete.mostrarFrete(distancia, peso, temCupom);
                break;
        
            default:
                break;
        }

        in.close();
    }
}