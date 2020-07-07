/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hijosPrueba;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente1 extends Agent {

    private String aidAgentPadre = "Agente2";

    @Override
    protected void setup() {
        addBehaviour(new ComportamientoAgente1Dos());
    }

    @Override
    protected void takeDown() {
        System.out.println("ME MORI SOY EL 1 :'v ");
    }

    class ComportamientoAgente1Dos extends SimpleBehaviour{
       private boolean bandera = false;
        @Override
        public void action() {
              System.out.println(getName());
              new EnviarMensaje().enviarMensajeString(ACLMessage.REQUEST, aidAgentPadre, getAgent(),
                      "Hola Como estas soy el " + getName() ,"ag1 to ag2");

              ACLMessage msj2 = blockingReceive();
              System.out.println(msj2);

              String contenido = msj2.getContent();
              String [] content = contenido.split(" ");
              if(content[0].equalsIgnoreCase("mori")){
                aidAgentPadre = content[1];
              }
              doWait(1000);
        }

        @Override
        public boolean done() {
            return bandera;
        }
    }
}

