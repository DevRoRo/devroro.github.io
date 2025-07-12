package negocio;

public class UsuarioProxy extends Usuario {
    private String departamento;

    public UsuarioProxy(Sistema sistema, String departamento) {
        super(sistema);
        this.departamento = departamento;
    }

    @Override
    public void acessarRelatorioContabil(){
        if (departamento != "Contábil") {
            System.out.println("Usuário não é do departamento contábil, não pode acessar o relatório");
        } else {
            super.acessarRelatorioContabil();
        }
    }

    @Override
    public void acessarRelatorioFinanceiro(){
        if (departamento != "Contábil") {
            System.out.println("Usuário não é do departamento financeiro, não pode acessar o relatório");
        } else {
            super.acessarRelatorioFinanceiro();
        }
    }

    @Override
    public void acessarRelatorioProducao(){
        if (departamento != "Produção") {
            System.out.println("Usuário não é do departamento de produção, não pode acessar o relatório");
        } else {
            super.acessarRelatorioProducao();
        }
    }
}
