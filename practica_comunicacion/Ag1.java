package practica_comunicacion;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag1 extends Agent {

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("Soy el agente 1 y voy a morir");
    }

    //el comportamiento es Behaviour 
    //
    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            System.out.println("yo soy el agente 1 !!!");
            //doWait(10000);
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag2", getAgent(), "contenido enviado",
                    "COD001");
            ACLMessage acl = blockingReceive();
            System.out.println("Hola, q gusto " + acl.getSender() + ", yo soy " + getAgent().getName());
            doDelete();
        }
    }
}
