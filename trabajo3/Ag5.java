/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo3;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author david
 */
public class Ag5 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("Soy el agente 5 y voy a morir");
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {            
            System.out.println("yo soy el agente 5 !!!");
            ACLMessage acl = blockingReceive();
            ACLMessage acl2 = blockingReceive();
            if(acl.getConversationId().equalsIgnoreCase("COD001") && acl2.getConversationId().equalsIgnoreCase("COD001")){
                System.out.println("Hola, q gusto " + acl.getSender() + ", yo soy " + getAgent().getName());
                System.out.println("Hola, q gusto " + acl2.getSender() + ", yo soy " + getAgent().getName());
                System.out.println("Ready el agente 5");
            }else{
                System.out.println("No puede continuar 5");
            }            
        }
    }
}
