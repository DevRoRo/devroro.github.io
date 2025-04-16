import produtos.*;
import promocoes.Liquidacao;
import promocoes.Regular;
import promocoes.SemPromo;

public class Main {
    
    public static void main (String args[]) {

        Produto brinquedo = new Brinquedo("Um boneco muito bom mesmo", 10.0);
        Produto dvd = new Dvd("Um filme muito bom mesmo", 10.0);
        Produto livro = new Livro("Um livro muito bom mesmo", 10.0);
        Produto outroBrinquedo = new Brinquedo("Um brinquedo realmente muito bom mesmo", 1000000.0);

        brinquedo.setP(new Liquidacao());
        dvd.setP(new Regular(5));
        livro.setP(new Regular(8));
        outroBrinquedo.setP(new SemPromo());

        System.out.println("=================== LOJA MUITO BOA MESMO ===================");
        System.out.println(brinquedo.toString()+dvd.toString()+livro.toString()+outroBrinquedo.toString());

    }
}
 /* O único requerimento do trabalho que ficou faltando foi implementar meses que não possuem descontoExtra */