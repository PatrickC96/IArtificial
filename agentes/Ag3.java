package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class Ag3 extends Agent {

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("Soy el agente 3 y voy a morir  :'V ");
    }

    class Comportamiento extends CyclicBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {
            ACLMessage acl = blockingReceive();
            try {
                Cliente cliente = (Cliente) acl.getContentObject();
                if(acl.getConversationId().equals("COD002")){
                    System.out.println("Se puede vender sin problema: "+cliente.getValor());
                }else if(acl.getConversationId().equals("COD004")){
                    System.out.println("Se puede vender sin problema: "+cliente.getValor());
                }else {
                    System.out.println("no se pudo encontrar Ag3");
                }
            } catch (UnreadableException e) {
                e.printStackTrace();
                System.out.println("Error al obtener el contenido: Ag3");
            }
            //doDelete();
        }
    }
}
