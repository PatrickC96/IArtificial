package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class Ag2 extends Agent {

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("Soy el agente 2 y voy a morir  :'V ");
    }

    class Comportamiento extends CyclicBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {
            ACLMessage acl = blockingReceive();
            if(acl.getConversationId().equals("COD001")){
                Cliente contenido = null;
                try {
                    contenido = (Cliente)acl.getContentObject();
                } catch (UnreadableException e) {
                    e.printStackTrace();
                    System.out.println("Error al encontrar el objeto");
                }
                if ((contenido.getValor()>-20000)){
                    contenido.setApto(true);
                    new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "Ag3", getAgent(),
                            contenido,"COD002");
                }else{
                    //enivar a 4
                    new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "Ag4", getAgent(),
                            contenido,"COD003");
                }
            }
            //doDelete();
        }
    }
}
