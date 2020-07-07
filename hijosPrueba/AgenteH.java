/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hijosPrueba;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class AgenteH extends Agent {
    private Contenedor c;
    int hijo=0;
    String nombreAgenteHijo = "Ag1";

    @Override
    protected void setup() {
        addBehaviour(new ComportamientoAgenteH());
    }

    @Override
    protected void takeDown() {
        c.crearHijos(nombreAgenteHijo, new Object[]{c,hijo});
        System.out.println("Adios soy "+getName()+" no muero jajaja !!!!!!!!!!!!!!!!!!!!!!!!");
    }

    class ComportamientoAgenteH extends SimpleBehaviour{
       private boolean bandera = false;
        @Override
        public void action() {
            System.out.println(getName());
            ACLMessage msj = blockingReceive();
            c = (Contenedor)getArguments()[0];

            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Agente1", getAgent(),
                    "mori AgenteH"+getArguments()[1].toString() ,"agH to ag1");

            hijo = (int) getArguments()[1];
            nombreAgenteHijo = "AgenteH"+hijo;
            hijo++;
            bandera = true;
            doDelete();
        }
        @Override
        public boolean done() {
           return bandera;
        }
    //------------------------------------------------------------------------- 
    
    }
}
