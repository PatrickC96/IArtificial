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
public class Ag4 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {

        System.out.println("Soy el agente 4 y voy a morir");
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            System.out.println("yo soy el agente 4 !!!");
            ACLMessage acl = blockingReceive();
            ACLMessage acl2 = blockingReceive();
            System.out.println("Hola, q gusto " + acl.getSender() + ", yo soy " + getAgent().getName());
            System.out.println("Hola, q gusto " + acl2.getSender() + ", yo soy " + getAgent().getName());
            doDelete();
        }

    }

}
