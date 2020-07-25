/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_comunicacion;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author david
 */
public class Ag2 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {

        System.out.println("Soy el agente 2 y voy a morir");
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            System.out.println("yo soy el agente 2 !!!");
            ACLMessage acl = blockingReceive();
            String conten=acl.getConversationId();
            
                System.out.println(acl.getContent().equalsIgnoreCase("contenido enviado"));
            
            System.out.println("Hola, q gusto " + acl.getSender() + ", yo soy " + getAgent().getName());
            //doWait(10000);
            //System.out.println("enviando mensaje");
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag3", getAgent(), "Hola Agente, soy " + getAgent().getName(),
                    "COD002");
            doDelete();
        }

    }

}
