package genetica1.agentesGenetica.genes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class pruebaFloat {
    public static void main(String[] args) {
//        System.out.println("hola mundo");
//        String valores ="1111100111";
//
//        int bits=Integer.parseInt(valores,2);
//        double flot = Float.parseFloat(bits/100+"");
//        BigDecimal value = new BigDecimal(bits);
//        String.format("%.2f", value);
//        System.out.println("el valor es: "+value.);

        // create 3 BigDecimal objects
        BigDecimal bg1, bg2, bg3;
        bg1 = new BigDecimal(999);
        bg2 = new BigDecimal(1000);

        bg3 = bg1.divide(bg2, 4, RoundingMode.CEILING);

        float fl = (float)999/1000000;

        String str = "Division result is " +fl;

        System.out.println( str );
    }
}
