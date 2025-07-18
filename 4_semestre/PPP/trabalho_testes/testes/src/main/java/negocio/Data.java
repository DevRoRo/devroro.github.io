package negocio;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Objects;

public class Data {
    private final int dia;
    private final int mes;
    private final int ano;
    private static final int CONST_ANO = 365;
    private static final int CONST_MES = 30;
    private static final int MIN_YEAR = 1900;

    // Empty constructor with default date (01/01/1900)
    public Data() {
        this(1, 1, MIN_YEAR);
    }

    // Main constructor with validation
    public Data(int dia, int mes, int ano) {
        if (ano < MIN_YEAR) {
            throw new IllegalArgumentException("Year must be >= " + MIN_YEAR);
        }
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        if (dia < 1 || dia > daysInMonth(mes, ano)) {
            throw new IllegalArgumentException("Invalid day for the given month and year");
        }

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    // Helper method to get days in month
    private static int daysInMonth(int mes, int ano) {
        if (mes == 2) {
            return isLeapYear(ano) ? 29 : 28;
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        }
        return 31;
    }

    // Helper method to check leap year
    private static boolean isLeapYear(int ano) {
        if (ano % 4 != 0) {
            return false;
        } else if (ano % 100 != 0) {
            return true;
        } else {
            return ano % 400 == 0;
        }
    }

    // Getters
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    // Date operations
    public Data tomorrow() {
        return plusDays(1);
    }

    public Data yesterday() {
        return minusDays(1);
    }

    public Data plusDays(int days) {
        LocalDate date = LocalDate.of(ano, mes, dia).plusDays(days);
        return new Data(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
    }

    public Data minusDays(int days) {
        LocalDate date = LocalDate.of(ano, mes, dia).minusDays(days);
        return new Data(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
    }

    // Comparison methods
    public boolean after(Data other) {
        if (ano > other.ano) return true;
        if (ano < other.ano) return false;
        if (mes > other.mes) return true;
        if (mes < other.mes) return false;
        return dia > other.dia;
    }

    public boolean before(Data other) {
        if (ano < other.ano) return true;
        if (ano > other.ano) return false;
        if (mes < other.mes) return true;
        if (mes > other.mes) return false;
        return dia < other.dia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return dia == data.dia && mes == data.mes && ano == data.ano;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, mes, ano);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    // Existing methods from original implementation
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

        return new Data(dia, mes, ano);
    }
}