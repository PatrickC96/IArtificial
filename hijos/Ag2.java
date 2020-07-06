/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hijos;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author david
 */
public class Ag2 extends Agent {

    private contenedor.Contenedor c;

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
        super.setup();
    }

    @Override
    protected void takeDown() {
        c.crearHijos("Ag3", new Object[]{c,1});
        System.out.println("Adios soy "+getName());
        super.takeDown();
    }

    class Comportamiento extends SimpleBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {
            System.out.println(getName());
            //------------RECIBIR MENSAJES----------------------
            // ACLMessage msj =  blockingReceive();
            // System.out.println("ESTO ES EL MENSAJE "+ msj);
            //---------------------------------------------------

            //------------RECIBIR Y ENVIAR MENSAJES----------------------
            ACLMessage msj =  blockingReceive();
            System.out.println("ESTO ES EL MENSAJE: "+ msj);

            c = (contenedor.Contenedor)getArguments()[0];


            ACLMessage msj2 = new ACLMessage(ACLMessage.INFORM);
            msj2.addReceiver(msj.getSender()); // QUIEN RECIBE EL MENSAJE
            msj2.setSender(getAID());
            msj2.setContent("mori Ag3");
            msj2.setConversationId("ag2 to ag1");
            msj2.setLanguage("Spanish");
            doWait(1000);
            send(msj2);
            //---------------------------------------------------
            bandera = true;
            //DO DELETE pausa los hilos uno a uno, libera los recursos
            doDelete();
        }
        @Override
        public boolean done() {
            return bandera;
        }
    }

}
