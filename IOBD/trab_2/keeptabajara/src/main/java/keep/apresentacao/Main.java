package keep.apresentacao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import keep.negocio.Anotacao;

import keep.persistencia.AnotacaoDAO;

public class Main {
    public static void main(String[] args) {

        AnotacaoDAO dao = new AnotacaoDAO();

        Scanner in = new Scanner(System.in);

        System.out.println("========KEEP=======\n"+
        "1 - listar todas as anotações disponíveis\n"+
        "2 - Buscar anotações por nome\n"+
        "3 -  Criar uma nova anotação\n"+
        "4 - Excluir anotação\n"+
        "5 - Alterar conteúdo de anotação\n"+
        "0 - Sair");

        while (true){
            boolean fechar = false;
            System.out.println("Digite a próxima opção desejada:");
            int menu = in.nextInt();

            switch (menu) {
                case 1:
                try {
                    System.out.println("======Suas Anotações=======\nid - título");
                   dao.listarAnotacoes(); 
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                    break;

                case 2:
                try {
                    System.out.println("Insira o id que deseja procurar: ");
                    Anotacao anotacao = dao.obterAnotacao(in.nextInt());
                    System.out.println(anotacao);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                    break;
                
                case 3:
                try {
                    System.out.println("Dê um título para a anotação: ");
                    String titulo = in.next();
                    in.nextLine();
                    System.out.println("Anote a seguir: ");
                    String  descricao =  in.nextLine();
                    LocalDateTime dataHora = LocalDateTime.now();
                    DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String dataHoraFormatada = dataHora.format(formater);
                    Anotacao anotacao = new Anotacao(titulo, descricao, dataHoraFormatada);
                    dao.registrarAnotacao(anotacao);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                    break;

                case 4:
                try {
                    System.out.println("Insira o título da anotação que deseja excluir: ");
                    dao.deletarAnotacao(in.nextInt());
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                    break;
                
                case 5:
                System.out.println("Informe o id da anotação que deseja editar");
                int id = in.nextInt();
                System.out.println("Informe o que deseja editar: \n cor\ndescricao\ntitulo\nfoto");
                String coluna = in.next();
                in.nextLine();
                System.out.println("Informe o que deve será escrito:");
                String troca = in.nextLine(); 
                try {
                    dao.atualizarAnotacao(id, coluna, troca);
                    System.out.println("Anotação  atualizada");
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("Não foi possível atualizar a anotação, tente novamente.");
                }
                    break;
                
                default:
                    fechar = true;
                    break;
            }

            if (fechar) {
                break;
            }
        }

        in.close();
    }
}