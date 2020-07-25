/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genes.funcion1;

/**
 *
 * @author HENRY
 */
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class funcionAptitud1 extends FitnessFunction {

    private double fitness;

    public funcionAptitud1() {
        fitness = 0;
    }

    @Override
    protected double evaluate(IChromosome cromosoma) {
        Evaluar(cromosoma);
        return fitness;
    }

    public double Evaluar(IChromosome cromosoma) {
        Integer [] c = new Integer[cromosoma.getGenes().length];
        for(int i =0;i < cromosoma.getGenes().length;i++){
            c[i]=(Integer) cromosoma.getGene(i).getAllele();
        }
        String valorX = "";
        for(int i = 1;i<cromosoma.getGenes().length;i++){
                valorX += c[i].toString();
        }
        int valX = (Integer.parseInt(valorX, 2));
        if (c[0] == 0) {
            valX = -valX;
        }
        //fitness = 50 - Math.pow(valX-3,2);
        //-(0.2585 x^6 + x^5 (-19.338) + 562.55 x^4 + x^3 (-7979.2) + 56266 x^2 -171797 x -8038.4)^-1+100
        if(valX<=16||valX>21){
            fitness = 0;
        }else{
            fitness = 100 - Math.pow((0.2585 *Math.pow(valX,6) +
                    Math.pow(valX,5)*(-19.338) + 562.55 *Math.pow(valX,4)
                    + Math.pow(valX,3)*(-7979.2) + 56266 *Math.pow(valX,2) -171797 * valX -8038.4),-1);
        }

        return valX;
    }
}
