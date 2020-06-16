/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicarDeber3;

import comunicacion.*;
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
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag5", getAgent(), 
                    "Hola Agente, soy " + getAgent().getName(),"COD001");
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag4", getAgent(), 
                    "Hola Agente, soy " + getAgent().getName(),"COD003");
            doWait(1000);
            //doDelete();
        }

    }

}
