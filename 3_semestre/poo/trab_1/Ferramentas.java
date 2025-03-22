public class Ferramentas {

    // recebe uma String data no formato (dd/mm/yyyy) e converte para um int[] de indice 3 para servir de parâmetro pro LocalDate Object
    public static int[] dataStringparaInt (String data) throws NumberFormatException {

        int dia;
        int mes;
        int ano;
    
        int[] arrayDiaMesAno = new int[3];

        String [] dataString = data.split("/");

        dia=Integer.valueOf(dataString[0]);
        mes=Integer.valueOf(dataString[1]);
        ano=Integer.valueOf(dataString[2]);

        arrayDiaMesAno[2] = dia;
        arrayDiaMesAno[1] = mes;
        arrayDiaMesAno[0] = ano;

        return arrayDiaMesAno;
    }
}