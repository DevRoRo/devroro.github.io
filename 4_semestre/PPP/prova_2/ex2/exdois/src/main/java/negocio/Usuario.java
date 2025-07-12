package negocio;

public class Usuario {
    private Sistema sistema;

    public Usuario(Sistema sistema) {
        this.sistema = sistema;
    }

    public void acessarRelatorioContabil() {
        sistema.getRelatorioContabil();
    }

    public void acessarRelatorioFinanceiro() {
        sistema.getRelatorioFinanceiro();
    }

    public void acessarRelatorioProducao() {
        sistema.getRelatorioProducao();
    }
}
