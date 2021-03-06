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

import org.jgap.*;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

public class Prueba3 {

    public double empezar() {
        Genotype population=null;
        try {
            //Configuramos JGAP
            Configuration.reset();
            Configuration configuracion = new DefaultConfiguration();
            FitnessFunction myFunc = new funcionAptitud3();
            configuracion.setFitnessFunction(myFunc); //Le indicamos a JGAP cual sera nuestra funcion de aptitud
            Gene[] genEjemplo = new Gene[7];

            //Creamos una codificacion de 8 genes que nos servira para nuestros individuos (fenotipo)
            //Los genes seran valores entre 0 y 1  ejem 01001110 individuo ejemplo
            for(int i = 0 ;i < genEjemplo.length;i++){
                genEjemplo[i] = new IntegerGene(configuracion, 0, 1);
            }

            //Recordemos que los cromosomas son el correspondiente a los individuos
            //Creamos un individuo a partir de la configuracion de los genes anterior
            Chromosome cromosomaNumero = new Chromosome(configuracion, genEjemplo);
            //Le indicamos a JGAP un ejemplo de como seran los individuos, a partir del individuo de ejemplo que creamos
            configuracion.setSampleChromosome(cromosomaNumero);
            configuracion.setPopulationSize(10); //Creamos nuestra poblacion inicial
            //Creamos el genotipo de la poblacion
            //Recordemos que el genotipo se determina del fenotipo = la configuracion de los genes para un cromosoma particular
            population = Genotype.randomInitialGenotype(configuracion);
            //Comienza a iterar el algoritmo
//            System.out.println("Poblacion inicial");
            for (int m = 0; m < 10; m++) { //50 iteraciones, cada iteracion sera una generacion
//                System.out.println("-------------------Inicio generacion-------------------");
//                System.out.println("Iteracion #" + m);
                //mostrarTodosIndividuos(population.getChromosomes());
                population.evolve(10);
                //show.mostrarTodosIndividuos(population.getChromosomes());
                IChromosome mejor_individuo = population.getFittestChromosome(); //Obtenemos el mejor individuo para esta generacion
                //System.out.println("Mejor Individuo de la generacion " + m + " :");
                //mostrarIndividuo(mejor_individuo);
//                System.out.println("Valor de aptitud obtenido:" + mejor_individuo.getFitnessValue());
//                System.out.println("-------------------Fin generacion-------------------");
            }
            /*Al final de las iteraciones, obtenemos el mejor individuo,
             * para nuestro ejemplo, es el cuadrado que no repite valores
             * en sus casillas, y cuya suma de lineas verticales, horizontales y
             * diagonales es 15
             */
//            System.out.println("Mejor individuo: ");
            //mostrarIndividuo(population.getFittestChromosome()); //mejor individuo obtenido

        } catch (InvalidConfigurationException ex) {
            System.out.println("No se pudo ejecutar el AG");
        }
        double valX = mostrarIndividuo(population.getFittestChromosome());
        System.out.println(calularProgrecion(valX));
        return calularProgrecion(valX);
    }

    private double calularProgrecion(double valX){
        double x1 = valX-10;
        double x2 = valX;
        double y2 = (27156 * Math.log(valX)-188752);
        valX = valX - 13;
        double y1 = (27156 * Math.log(valX)-188752);
        double x=x2+30;
        return (double)y1+((y2-y1)/(x2-x1))*(x-x1);
    }
    public void mostrarTodosIndividuos(IChromosome[] ind) {
        for (IChromosome iChromosome : ind) {
            mostrarIndividuo(iChromosome);
        }
    }
    public double mostrarIndividuo(IChromosome cromosoma) {
        double valX = new funcionAptitud3().Evaluar(cromosoma);
        System.out.println(valX + " ; resultado: " +(27156 * Math.log(valX)-188752));
        return valX;
    }
}
