package negocio;

import java.util.ArrayList;
import java.util.List;

public class listaMonstros {
    private static List<MonstroPrototype> prototipos = new ArrayList<>();

    static {
        prototipos.add(new Orc("Goblin", 80, 15, "espada curta"));
        prototipos.add(new Orc("Orc Guerreiro", 120, 25, "machado"));
        prototipos.add(new Orc("Orc Xama", 90, 10, "cajado"));
    }

    public static MonstroPrototype obterModelo(String tipo) {
        for (MonstroPrototype prototipo : prototipos) {
            if (prototipo.getEspecie().equals(tipo)) {
                return prototipo.clonar();
            }
        }
        return null;
    }

    public static void adicionarNaListaDeMonstros(MonstroPrototype monstro) {
        prototipos.add(monstro);
    }
}