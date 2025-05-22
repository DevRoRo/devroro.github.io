package negocio;

import java.time.LocalDateTime;

public class Data {
    private int dia, mes, ano;
    private static final int CONST_ANO = 365;
    private static final int CONST_MES = 30;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    private static int[] calcularIntervalo(Data data1, Data data2) {
        Data[] datas = {data1, data2};
        int[] intervalos = new int[2];
        int resultado, resultadoAno, resultadoMes, resultadoDia;

        for (int i = 0; i < intervalos.length; i++) {
            intervalos[i]= datas[i].dia+(datas[i].mes*CONST_MES)+(datas[i].ano*CONST_ANO);
        }

        resultado = intervalos[1]- intervalos[0];
        resultadoAno = resultado/CONST_ANO;
        resultadoMes = (resultado%CONST_ANO)/CONST_MES;
        resultadoDia = (resultado%CONST_ANO)%CONST_MES;

        int[] resultadoArray = {resultadoAno, resultadoMes, resultadoDia};

        return resultadoArray;
    }

    public static void mostrarIntervalo(Data data1, Data data2){
        int[] intervalo = calcularIntervalo(data1, data2);

        System.out.println(intervalo[2]+" dias, "+intervalo[1]+" meses e "+intervalo[0]+" anos");
    }

    public static int getIntervaloAnos(Data data1, Data data2) {
        int[] intervalo = calcularIntervalo(data1, data2);
        
        return intervalo[0];
    }

    public static int getIntervaloMeses(Data data1, Data data2) {
        int[] intervalo = calcularIntervalo(data1, data2);
        
        return intervalo[1];
    }

    public static int getIntervaloDias(Data data1, Data data2) {
        int[] intervalo = calcularIntervalo(data1, data2);
        
        return intervalo[2];
    }

    public static Data diaHoje() {
        String s = LocalDateTime.now().toString();
        s = s.substring(0, 10);
        s = s.replace("-", "");
        int ano = Integer.parseInt(s.substring(0, 4));
        int mes = Integer.parseInt(s.substring(4, 6));
        int dia = Integer.parseInt(s.substring(6, 8));

        /* Queria usar um método que puxasse da BIOS ou que não
         * precisasse acessar uma biblioteca externa mas não tive tempo hábil
         * pra pensar
         */

        return new Data(dia, mes, ano);
    }

    @Override
    public String toString() {
        return this.dia+"/"+this.mes+"/"+this.ano;
    }
}
