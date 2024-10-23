public class Ferramentas {

    public static int[] dataStringparaInt (String data) {

        int dia;
        int mes;
        int ano;
    
        int[] arrayDiaMesAno = new int[3];

        String [] data1 = data.split("/");

        dia=Integer.valueOf(data1[0]);
        mes=Integer.valueOf(data1[1]);
        ano=Integer.valueOf(data1[2]);

        arrayDiaMesAno[0] = dia;
        arrayDiaMesAno[1] = mes;
        arrayDiaMesAno[2] = ano;

        return arrayDiaMesAno;
    }
    
}
