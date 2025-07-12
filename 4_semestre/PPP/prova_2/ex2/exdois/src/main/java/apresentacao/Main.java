package apresentacao;

import negocio.Sistema;
import negocio.Usuario;
import negocio.UsuarioProxy;

//Utilizado padrão Proxy pra resolução do exercício 2

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        //Por padrão, usuario tem acesso a todos os relatórios
        Usuario usuario = new Usuario(sistema);
        usuario.acessarRelatorioContabil();
        usuario.acessarRelatorioFinanceiro();
        usuario.acessarRelatorioProducao();
        System.out.println("\n\n");

        //Utilizando usuarioProxy, é necessário informar qual o departamento correto
        String[] departamentos = {"Produção", "Contábil", "Financeiro"};
        UsuarioProxy usuario2  = new UsuarioProxy(sistema, departamentos[0]);
        usuario2.acessarRelatorioContabil();
        usuario2.acessarRelatorioFinanceiro();
        usuario2.acessarRelatorioProducao();

    }
}