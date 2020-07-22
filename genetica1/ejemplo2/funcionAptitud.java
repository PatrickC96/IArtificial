/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetica1.ejemplo2;

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
        Integer [] c =new Integer[cromosoma.getGenes().length];
        for(int i = 0 ;i<cromosoma.getGenes().length;i++){
            c[i]=(Integer) cromosoma.getGene(i).getAllele();
        }
        String numero = "";
        for(int i = 1 ;i<cromosoma.getGenes().length;i++){
            numero += c[i].toString();
        }
        int entero = Integer.parseInt(numero,2);

        double valfloat = (double) entero/10000;

        if (c[0] == 0) {
            valfloat = -valfloat;
        }

        //System.out.println("valor: "+valfloat);

        if(valfloat<-3 ){
            fitness = 0;
        }else{
            //fitness = 4 - Math.abs(Math.log(valfloat+3));
            fitness = 10 - Math.log(valfloat+3);
        }
    }
}
