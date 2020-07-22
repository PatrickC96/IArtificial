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
        Integer [] c = new Integer[cromosoma.getGenes().length];
        for(int i =0;i < cromosoma.getGenes().length;i++){
            c[i]=(Integer) cromosoma.getGene(i).getAllele();
        }
        String valorX = "";
        String valorY = "";
        for(int i = 2;i<cromosoma.getGenes().length;i++){
            if (i%2==0){
                valorX += c[i].toString();
            }else{
                valorY += c[i].toString();
            }
        }

        int valorXint = (Integer.parseInt(valorX, 2));
        int valorYint = (Integer.parseInt(valorY, 2));
        double valX = (double)valorXint/10;
        double valY = (double)valorYint/10;
        if (c[0] == 0) {
            valX = -valX;
        }
        if (c[1] == 0) {
            valY = -valY;
        }
        fitness = 20 - Math.sqrt(Math.pow(valX,2)+valY * valY);
    }
}
