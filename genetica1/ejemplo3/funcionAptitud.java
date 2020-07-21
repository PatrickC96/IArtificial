/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetica1.ejemplo3;

/**
 *
 * @author HENRY
 */
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class funcionAptitud extends FitnessFunction {

    private double fitness; //La variable que llevará el valor de aptitud

    public funcionAptitud() {
        fitness = 0;
    }

    @Override
    protected double evaluate(IChromosome cromosoma) {
        Evaluar(cromosoma);
        return fitness;//agregar comprobacion de si es 50
    }

    private void Evaluar(IChromosome cromosoma) {
        Integer c1 = (Integer) cromosoma.getGene(0).getAllele();//signo X
        Integer c2 = (Integer) cromosoma.getGene(1).getAllele();
        Integer c3 = (Integer) cromosoma.getGene(2).getAllele();
        Integer c4 = (Integer) cromosoma.getGene(3).getAllele();
        Integer c5 = (Integer) cromosoma.getGene(4).getAllele();
        Integer c6 = (Integer) cromosoma.getGene(5).getAllele();
        Integer c7 = (Integer) cromosoma.getGene(6).getAllele();//signo Y
        Integer c8 = (Integer) cromosoma.getGene(7).getAllele();
        Integer c9 = (Integer) cromosoma.getGene(8).getAllele();
        Integer c10 = (Integer) cromosoma.getGene(9).getAllele();
        Integer c11 = (Integer) cromosoma.getGene(10).getAllele();
        Integer c12 = (Integer) cromosoma.getGene(11).getAllele();

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
        System.out.println(valorXint + " ; " + valorYint);
        //fitness = 256 - Math.abs(valor - 50); Math.log(x)
        //System.out.println(Math.sqrt(Math.pow(valorXint,2)+valorYint * valorYint));
        fitness = 2048 - Math.sqrt(Math.pow(valorXint,2)+valorYint * valorYint);
    }
}
