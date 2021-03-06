package Examen.agentes;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag1 extends Agent {

    private Contenedor c;
    int hijo;

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        c.crearHijos1("Ag1"+hijo, new Object[]{c,hijo});
        System.out.println("Muero Agente 1 -"+hijo);
    }

    class Comportamiento extends SimpleBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {

            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag5", getAgent(),
                    generarAleatorioRango(1,30)+"","COD001");
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
