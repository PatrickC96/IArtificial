package trabajo2;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag3 extends Agent {

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
    }



    class Comportamiento extends CyclicBehaviour {
        @Override
        public void action() {
            System.out.println("yo soy el agente 3 !!!");
            doWait(1000);

        }
    }
}
