package trabajo4;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag3 extends Agent {

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("Soy el agente 3 y voy a morir");
    }

    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            System.out.println("yo soy el agente 3 !!!");           
            
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag4", getAgent(),
                    "Hola Agente, soy " + getAgent().getName(),"COD003");
            doWait(10000);
            //doDelete();
        }
    }
}
