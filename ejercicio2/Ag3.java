package ejercicio2;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag3 extends Agent {

    private Contenedor c;
    int hijo;

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("Muero Agente 3 -"+hijo);
        c.crearHijos3("Ag3"+hijo, new Object[]{c,hijo});
    }

    class Comportamiento extends SimpleBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {

            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag4", getAgent(),
                    generarAleatorioRango(1,30)+"","COD004");
            doWait(1000);

            c = (Contenedor)getArguments()[0];
            hijo = (int) getArguments()[1];
            hijo++;
            doDelete();
        }
        @Override
        public boolean done() {
            return bandera;
        }
    }
    public static int generarAleatorioRango(int inicio, int fin) {
        //Desde inicio hasta fin, ambos incluidos
        return (int) (Math.random() * ((fin + 1) - inicio)) + inicio;
    }
}
