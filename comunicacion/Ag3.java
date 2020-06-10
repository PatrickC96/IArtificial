package comunicacion;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag3 extends Agent {

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Ag3.Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("Soy el agente 3 y voy a morir");
    }

    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            System.out.println("yo soy el agente 3 !!!");
            ACLMessage acl = blockingReceive();
            System.out.println("Hola, q gusto " + acl.getSender() + ", yo soy " + getAgent().getName());
            
            doWait(10000);
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag1", getAgent(), "Hola Agente, soy " + getAgent().getName(),
                    "COD003");
            //agente uno espera hasta que el otro le de la orden de continuar.
            //tambien se puede programar con tiempo
            //blockingReceive();
            //doWait(100); para detener la ejecucion. 
            //ACLMessage acl = blockingReceive();
            //System.out.println("Hola, q gusto " + acl.getSender() + ", yo soy " + getAgent().getName());
            doDelete();
        }
    }
}
