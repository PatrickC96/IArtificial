/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo4;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author david
 */
public class Ag4 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            System.out.println("yo soy el agente 4 !!!");
            ACLMessage acl = blockingReceive();
            ACLMessage acl2 = blockingReceive();
            if(acl.getConversationId().equalsIgnoreCase("COD003") && acl2.getConversationId().equalsIgnoreCase("COD003")){
                System.out.println("Hola, q gusto " + acl.getSender() + ", yo soy " + getAgent().getName());
                System.out.println("Hola, q gusto " + acl2.getSender() + ", yo soy " + getAgent().getName());
                new EnviarMensaje().enviarMensajeString(ACLMessage.REQUEST, "Ag5", getAgent(),
                        "Hola Agente, soy " + getAgent().getName(),"COD005");                
                ACLMessage acl3 = blockingReceive();
                if(acl3.getConversationId().equalsIgnoreCase("COD004")){
                    System.out.println("Hola, q gusto " + acl3.getSender() + ", yo soy " + getAgent().getName()); 
                    System.out.println("Ready el agente 4");
                }else{
                    System.out.println("Error en el agente 4");
                }

            }else{
                System.out.println("No puede continuar 4");
            }
        }
    }
}
