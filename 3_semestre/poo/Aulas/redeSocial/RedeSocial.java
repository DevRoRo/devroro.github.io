package redeSocial;
import java.util.ArrayList;
import java.util.List;

public class RedeSocial {

    private List<Usuario> usuarios;

    RedeSocial() {
        usuarios = new ArrayList<Usuario>();
    }


    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario adicionarUsuario(String nome) {
        Usuario u = new Usuario(nome);
        usuarios.add(u);

        return u;
    }

    public void conectarUsuarios(Usuario usuario1, Usuario usuario2) {
        usuario1.addAmigo(usuario2);
    }

    public void listarAmigos(Usuario user) {
        System.out.println("Amigos do "+user.getNome());
        for (int i = 0; i < array.length; i++) {
            
        }
    }

}