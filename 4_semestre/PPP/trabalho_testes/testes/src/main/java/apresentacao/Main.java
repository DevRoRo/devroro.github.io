package apresentacao;

import negocio.Data;

public class Main {
    public static void main(String[] args) {
        // Test empty constructor and default date
        Data d = new Data();
        System.out.println(d.getDia() == 1);
        System.out.println(d.getMes() == 1);
        System.out.println(d.getAno() == 1900);

        // Test constructor with parameters
        d = new Data(25, 12, 2000);
        System.out.println(d.getDia() == 25);
        System.out.println(d.getMes() == 12);
        System.out.println(d.getAno() == 2000);

        // Test constructor with different parameter order
        d = new Data(13, 7, 2016);
        System.out.println(d.getDia() == 13);
        System.out.println(d.getMes() == 7);
        System.out.println(d.getAno() == 2016);

        // Test toString
        Data d8 = new Data(5, 5, 2005);
        System.out.println(d8.toString().equals("05/05/2005"));
        d8 = new Data(1, 10, 2001);
        System.out.println(d8.toString().equals("01/10/2001"));

        // Test comparisons
        Data d5 = new Data(1, 7, 2014);
        Data d6 = new Data(1, 7, 2014);
        System.out.println(d5.equals(d6) == true);
        System.out.println(d5.equals(new Data()) == false);

        Data d7 = new Data(23, 4, 2016);
        System.out.println(d5.after(d7) == false);
        System.out.println(d7.after(d5) == true);
        System.out.println(d5.before(d7) == true);
        System.out.println(d7.before(d5) == false);
        System.out.println(d7.before(d7) == false);
        System.out.println(d7.after(d7) == false);

        // Test date operations
        d = new Data(22, 4, 2016);
        Data d2 = d.yesterday();
        System.out.println(d2.getDia() == 21);
        System.out.println(d2.getMes() == 4);
        System.out.println(d2.getAno() == 2016);

        // Check immutability
        System.out.println(d.getDia() == 22);
        System.out.println(d.getMes() == 4);
        System.out.println(d.getAno() == 2016);

        d2 = d.tomorrow();
        System.out.println(d2.getDia() == 23);
        System.out.println(d2.getMes() == 4);
        System.out.println(d2.getAno() == 2016);

        Data d3 = d2.plusDays(10);
        System.out.println(d3.getDia() == 3);
        System.out.println(d3.getMes() == 5);
        System.out.println(d3.getAno() == 2016);

        Data d4 = d3.minusDays(10);
        System.out.println(d4.getDia() == 23);
        System.out.println(d4.getMes() == 4);
        System.out.println(d4.getAno() == 2016);

        // Complex scenarios
        Data q = new Data(20, 2, 2016);
        q = q.plusDays(9);
        System.out.println(q.toString().equals("29/02/2016"));
        for (int i = 0; i < 400; i++) q = q.tomorrow();
        System.out.println(q.toString().equals("04/04/2017"));
        q = q.plusDays(365);
        System.out.println(q.toString().equals("04/04/2018"));

        // Uncomment to test invalid dates (they should throw IllegalArgumentException)
        /*
        d = new Data(1900, 7, 2016); // ambiguous
        d = new Data(16, 7, 1899); // year below minimum
        d = new Data(1899, 7, 16); // year below minimum
        d = new Data(2016, 13, 16); // invalid month
        d = new Data(2016, 12, 32); // invalid day
        d = new Data(2016, 12, -1); // invalid day
        d = new Data(2016, -1, 16); // invalid month
        d = new Data(2016, 2, 30); // invalid day for February
        */
    }
}