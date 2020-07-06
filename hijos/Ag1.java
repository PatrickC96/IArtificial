package hijos;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag1 extends Agent {
    private String aidAgentPadre = "Ag2";

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
        super.setup();
    }

    @Override
    protected void takeDown() {
        System.out.println("Adios soy "+getName());
        super.takeDown();
    }

    //el comportamiento es Behaviour 
    //
    class Comportamiento extends SimpleBehaviour {
        private boolean bandera = false;

        public void actionnn() {
            System.out.println("yo soy el agente 1 !!!");
            //doWait(10000);
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag2", getAgent(), "contenido enviado",
                    "COD001");
            ACLMessage acl = blockingReceive();
            System.out.println("Hola, q gusto " + acl.getSender() + ", yo soy " + getAgent().getName());
            doDelete();
        }
        @Override
        public void action() {
            System.out.println(getName());

            //------------ENVIAR MENSAJES----------------------
            //INFORM PARA SOLO ENVIAR
            //REQUEST ESPERAR UN MENSAJE
            ACLMessage msj = new ACLMessage(ACLMessage.REQUEST);
            AID aid = new AID();
            //SE PONE EL NICKNAME
            aid.setLocalName(aidAgentPadre);
            msj.addReceiver(aid); // QUIEN RECIBE EL MENSAJE
            msj.setSender(getAID());
            msj.setContent("Hola Como estas soy el " + getName());
            msj.setConversationId("ag1 to ag2");
            msj.setLanguage("Spanish");
            doWait(1000);
            send(msj);
            //SI EL AGENTE NO RECIBE UN MENSAJE SE QUEDA BLOQUEADO

            ACLMessage msj2 = blockingReceive();
            System.out.println(msj2);
            String contenido = msj2.getContent();
            String [] content = contenido.split(" ");
            if(content[0].equalsIgnoreCase("mori")){
                aidAgentPadre = content[1];
            }

            //--------------------------------------------------

            //DO DELETE pausa los hilos uno a uno, libera los recursos

        }
        @Override
        public boolean done() {
            return bandera;
        }
    }
}
