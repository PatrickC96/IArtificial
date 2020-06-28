package trabajo5;

import trabajo4.*;
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
            //System.out.println("yo soy el agente 1 !!!");
            
            new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "Ag5", getAgent(),
                    new Paciente("Juan", "23", false),"COD001");  
            doWait(10000);
            //doDelete();
            
        }
    }
}
