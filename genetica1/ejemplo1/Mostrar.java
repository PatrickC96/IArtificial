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


    public void mostrarIndividuo(IChromosome cromosoma) {
        Integer [] c=new Integer[cromosoma.getGenes().length];
        for(int i =0;i<cromosoma.getGenes().length;i++){
            c[i] = (Integer) cromosoma.getGene(i).getAllele();
        }
        String valorX = "";
        String valorY = "";
        for(int i = 2;i<cromosoma.getGenes().length;i++){
            if(i%2==0){
                valorX += c[i].toString();
            }else{
                valorY += c[i].toString();
            }
        }
        int valorXint = (Integer.parseInt(valorX, 2));
        int valorYint = (Integer.parseInt(valorY, 2));
        double valX = (double)valorXint/100;
        double valY = (double)valorYint/100;
        if (c[0] == 0) {
            valX = -valX;
        }
        if (c[1] == 0) {
            valY = -valY;
        }
        System.out.println( valX + " ; "  + valY);
    }

    public void mostrarTodosIndividuos(IChromosome[] ind) {

        for (IChromosome iChromosome : ind) {
            mostrarIndividuo(iChromosome);
        }
    }
}
