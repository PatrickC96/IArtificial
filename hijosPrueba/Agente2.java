/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hijosPrueba;

/**
 *
 * @author Juan Diego
 */
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente2 extends Agent {
    private Contenedor c;

    @Override
    protected void setup() {
        addBehaviour(new ComportamientoAgente2Dos());
    }

    @Override
    protected void takeDown() {
        c.crearHijos("AgenteH", new Object[]{c,1});
        System.out.println("Soy el Agente 2 y eh muerto(");
    }

    class ComportamientoAgente2Dos extends SimpleBehaviour{
       private boolean bandera = false;
        //ACCION
        @Override
        public void action() {
            System.out.println(getName());
            ACLMessage msj =  blockingReceive();
            System.out.println("ESTO ES EL MENSAJE: "+ msj);
                  
            c = (Contenedor)getArguments()[0];

            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Agente1", getAgent(),
                    "mori AgenteH" ,"ag2 to ag1");
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