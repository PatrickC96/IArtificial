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
import org.jgap.IChromosome;

public class Mostrar {


    public void mostrarIndividuo(IChromosome cromosoma) {

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

        System.out.println("Resultado: "+valfloat+"    con:  "+ Math.log(valfloat+3));
        //System.out.println("");
    }

    public void mostrarTodosIndividuos(IChromosome[] ind) {

        for (IChromosome cromosoma : ind) {
            mostrarIndividuo(cromosoma);
        }
    }
}
