package Examen.agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

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
            ACLMessage acl2 = blockingReceive();

            if(acl.getConversationId().equals("COD003")&&acl2.getConversationId().equals("COD004")){
                System.out.println("bien ");
//                System.out.println("Primero llego el agente2 : "+acl.getSender().getLocalName()+
//                        " con el nombre:"+acl.getSender().getName());
//                System.out.println("Luego llego el agente3 : "+acl2.getSender().getLocalName()+
//                        " con el nombre:"+acl2.getSender().hashCode());
            }else if(acl.getConversationId().equals("COD004")&&acl2.getConversationId().equals("COD003")){
                System.out.println("bien");
//                System.out.println("Primero llego el agente3 : "+acl.getSender().getLocalName()+
//                        " con el nombre:"+acl.getSender().getName()
//                );
//                System.out.println("Luego llego el agente2 : "+acl2.getSender().getLocalName()+
//                        " con el nombre:"+acl2.getSender().hashCode());
            }else if(acl.getConversationId().equals("COD004")&&acl2.getConversationId().equals("COD004")){
                System.out.println("solo 3 !!!!!!!!!!!");
//                System.out.println("Primero llego el agente3 : "+acl.getSender().getLocalName()+
//                        " con el nombre:"+acl.getSender().getName()
//                );
//                System.out.println("Luego llego el agente2 : "+acl2.getSender().getLocalName()+
//                        " con el nombre:"+acl2.getSender().hashCode());
            }else if(acl.getConversationId().equals("COD003")&&acl2.getConversationId().equals("COD003")){
                System.out.println("solo 2 !!!!!!!!!!!");
//                System.out.println("Primero llego el agente3 : "+acl.getSender().getLocalName()+
//                        " con el nombre:"+acl.getSender().getName()
//                );
//                System.out.println("Luego llego el agente2 : "+acl2.getSender().getLocalName()+
//                        " con el nombre:"+acl2.getSender().hashCode());
            }else{
                System.out.println("no se encontro los elementos");
            }
        }
    }
}
