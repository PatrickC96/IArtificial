package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class Ag4 extends Agent {

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("Soy el agente 4 y voy a morir  :'V ");
    }

    class Comportamiento extends CyclicBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {
            ACLMessage acl = blockingReceive();
            Cliente contenido = null;
            try {
                contenido = (Cliente)acl.getContentObject();
            } catch (UnreadableException e) {
                e.printStackTrace();
                System.out.println("Error al encontrar el objeto Ag4");
            }
            if (acl.getConversationId().equals("COD003")){
                if(contenido.getValor()+30000>0){
                    new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "Ag3", getAgent(),
                            contenido,"COD004");
                }else {
                    System.out.println("No se venda ya que existirá mucha deuda en los próximos meses, deuda: "+contenido.getValor());
                }
            }
            //doDelete();
        }
    }
}
