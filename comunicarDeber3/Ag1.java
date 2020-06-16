package comunicarDeber3;

import comunicacion.*;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
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
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag5", getAgent(), 
                    "Hola Agente, soy " + getAgent().getName(),"COD001");
            doWait(1000);
            //doDelete();
            
        }
    }
}
