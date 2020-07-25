/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genes.funcion3;

/**
 *
 * @author HENRY
 */
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class funcionAptitud3 extends FitnessFunction {

    private double fitness;

    public funcionAptitud3() {
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

        if(valX<16||valX>20){
            fitness = 0;
        }else{
            fitness = -Math.pow((27156 * Math.log(valX)-188752),-1);
        }

        return valX;
    }
}
