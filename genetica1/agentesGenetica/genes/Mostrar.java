/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetica1.agentesGenetica.genes;

/**
 *
 * @author HENRY
 */
import org.jgap.IChromosome;

public class Mostrar {

    Integer c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12;
    Integer [] c = new Integer[12];

    public void mostrarIndividuo(IChromosome ind) {
        for(int i = 0;i<ind.getGenes().length;i++){
            c[i]=(Integer) ind.getGene(i).getAllele();
        }
        String signoX;
        if (c[0] == 0) {
            signoX = "-";
        } else {
            signoX = "";
        }
        String signoY;
        if (c[7] == 0) {
            signoY = "-";
        } else {
            signoY = "";
        }
        String valorX = c[2].toString() + c[3].toString() + c[4].toString() + c[5].toString() + c[6].toString();
        String valorY = c[8].toString() + c[9].toString() + c[10].toString() + c[11].toString() + c[1].toString();
        int valorXint = (Integer.parseInt(valorX, 2));
        int valorYint = (Integer.parseInt(valorY, 2));
        System.out.println(signoX + valorXint + " ; " + signoY + valorYint);
        System.out.println("");
    }
    public Object[] getIndividuo(IChromosome ind) {
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
        String valorX = c2.toString() + c3.toString() + c4.toString() + c5.toString() + c6.toString();
        String valorY = c8.toString() + c9.toString() + c10.toString() + c11.toString() + c12.toString();
        int valorXint = (Integer.parseInt(valorX, 2));
        int valorYint = (Integer.parseInt(valorY, 2));
        if (c1 == 0) {
            valorXint = -valorXint;
        }
        if (c7 == 0) {
            valorYint = -valorYint;
        }
//        System.out.println( valorXint + " ; " + + valorYint);
        //System.out.println("");
        Object [] valores = {valorXint,valorYint};
        return valores;
    }

    public void mostrarTodosIndividuos(IChromosome[] ind) {

        for (IChromosome iChromosome : ind) {
            for(int i =0 ; i<iChromosome.getGenes().length;i++){
                c[i]=(Integer) iChromosome.getGene(i).getAllele();
            }
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


            String signoX;
            if (c1 == 0) {
                signoX = "-";
            } else {
                signoX = "";
            }
            String signoY;
            if (c7 == 0) {
                signoY = "-";
            } else {
                signoY = "";
            }
            String valorX = c2.toString() + c3.toString() + c4.toString() + c5.toString() + c6.toString();
            String valorY = c8.toString() + c9.toString() + c10.toString() + c11.toString() + c12.toString();
            int valorXint = (Integer.parseInt(valorX, 2));
            int valorYint = (Integer.parseInt(valorY, 2));
            System.out.println(signoX + valorXint + " ; " + signoY + valorYint);

        }
    }
}
