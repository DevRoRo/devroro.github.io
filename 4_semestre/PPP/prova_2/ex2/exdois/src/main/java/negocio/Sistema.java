package negocio;

public class Sistema {
    private String relatorioContabil = "Relatório contábil:\nNenhuma NF declarada nos últimos 4 meses";
    private String relatorioFinanceiro = "Relatório financeiro:\nAtual caixa: -R$ 1.000.000,00 ";
    private String relatorioProducao = "Relatório de produção: \nLinha de produção nº 10 produziu no mês 4: 0 unidades do produto X";

    public void getRelatorioContabil() {
        System.out.println(relatorioContabil);
    }
    public void getRelatorioFinanceiro() {
        System.out.println(relatorioFinanceiro);
    }
    public void getRelatorioProducao() {
        System.out.println(relatorioProducao);
    }
}