package negocio;

public class CarroProxy implements Manobra {
    private Carro carro;

    public CarroProxy(Carro carro) {
        this.carro = carro;
    }

    @Override
    public void manobrar(Empregado empregado) {
        int idade = Data.getIntervaloAnos(empregado.getDataNascimento(), Data.diaHoje());

        if(idade >= 18) {
            if (empregado.temCnh()) {
                carro.manobrar(empregado);
            } else {
                System.out.println("Empregado não tem CNH, não pode manobrar.");
            }
        } else {
            System.out.println("Empregado é menor de idade, não pode manobrar.");
        }
    }
    
}
