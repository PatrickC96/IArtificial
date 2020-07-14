package ejercicio1;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag1 extends Agent {
    private Contenedor c;

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
        c = (Contenedor)getArguments()[0];
        c.crearHijos("Ag2", new Object[]{c,1});
        c.crearHijos2("Ag3", new Object[]{c,1});
    }

    @Override
    protected void takeDown() {
        System.out.println("Soy el agente 1 y voy a morir  :'V ");
    }

    class Comportamiento extends SimpleBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {

            doWait(100);
            new trabajo4.EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag2", getAgent(),
                    "Hola Agente, soy " + getAgent().getName(),"COD001");
            new trabajo4.EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag3", getAgent(),
                    "Hola Agente, soy " + getAgent().getName(),"COD002");

            doDelete();

        }
        @Override
        public boolean done() {
            return bandera;
        }
    }
}
