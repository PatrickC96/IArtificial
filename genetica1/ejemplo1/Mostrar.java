/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetica1.ejemplo1;

/**
 *
 * @author HENRY
 */
import org.jgap.IChromosome;

public class Mostrar {

    Integer c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12;

    public void mostrarIndividuo(IChromosome ind) {
        c1 = (Integer) ind.getGene(0).getAllele();
        c2 = (Integer) ind.getGene(1).getAllele();
        c3 = (Integer) ind.getGene(2).getAllele();
        c4 = (Integer) ind.getGene(3).getAllele();
        c5 = (Integer) ind.getGene(4).getAllele();
        c6 = (Integer) ind.getGene(5).getAllele();
        c7 = (Integer) ind.getGene(6).getAllele();
        c8 = (Integer) ind.getGene(7).getAllele();
        c9 = (Integer) ind.getGene(8).getAllele();
        c10 = (Integer) ind.getGene(9).getAllele();
        c11 = (Integer) ind.getGene(10).getAllele();
        c12 = (Integer) ind.getGene(11).getAllele();

        String valorX = c2.toString() + c3.toString() + c4.toString() ;
        String valorX1=  c5.toString() + c6.toString();
        String valorY = c8.toString() + c9.toString() + c10.toString() ;
        String valorY1= c11.toString() + c12.toString();
        int valorXint = (Integer.parseInt(valorX, 2));
        int valorXint1 = (Integer.parseInt(valorX1, 2));
        int valorYint = (Integer.parseInt(valorY, 2));
        int valorYint1 = (Integer.parseInt(valorY1, 2));
        float valX =Float.parseFloat(valorXint1+"."+valorXint);
        float valY =Float.parseFloat(valorYint1+"."+valorYint);
        if (c1 == 0) {
            valX = -valX;
        }
        if (c7 == 0) {
            valY = -valY;
        }
        System.out.println( valX + " ; "  + valY);
        System.out.println("");
    }

    public void mostrarTodosIndividuos(IChromosome[] ind) {

        for (IChromosome iChromosome : ind) {
            c1 = (Integer) iChromosome.getGene(0).getAllele();
            c2 = (Integer) iChromosome.getGene(1).getAllele();
            c3 = (Integer) iChromosome.getGene(2).getAllele();
            c4 = (Integer) iChromosome.getGene(3).getAllele();
            c5 = (Integer) iChromosome.getGene(4).getAllele();
            c6 = (Integer) iChromosome.getGene(5).getAllele();
            c7 = (Integer) iChromosome.getGene(6).getAllele();
            c8 = (Integer) iChromosome.getGene(7).getAllele();
            c9 = (Integer) iChromosome.getGene(8).getAllele();
            c10 = (Integer) iChromosome.getGene(9).getAllele();
            c11 = (Integer) iChromosome.getGene(10).getAllele();
            c12 = (Integer) iChromosome.getGene(11).getAllele();

            String valorX = c2.toString() + c3.toString() + c4.toString() ;
            String valorX1=  c5.toString() + c6.toString();
            String valorY = c8.toString() + c9.toString() + c10.toString() ;
            String valorY1= c11.toString() + c12.toString();
            int valorXint = (Integer.parseInt(valorX, 2));
            int valorXint1 = (Integer.parseInt(valorX1, 2));
            int valorYint = (Integer.parseInt(valorY, 2));
            int valorYint1 = (Integer.parseInt(valorY1, 2));
            float valX =Float.parseFloat(valorXint1+"."+valorXint);
            float valY =Float.parseFloat(valorYint1+"."+valorYint);
            if (c1 == 0) {
                valX = -valX;
            }
            if (c7 == 0) {
                valY = -valY;
            }
            System.out.println( valX + " ; "  + valY);
            System.out.println("");
        }
    }
}
