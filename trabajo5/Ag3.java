package trabajo5;

import trabajo4.*;
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
            
            new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "Ag4", getAgent(),
                    new Paciente("Pablo", "45", true),"COD004");
            doWait(1000);
            //doDelete();
        }
    }
}
