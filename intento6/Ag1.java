package intento6;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag1 extends Agent {
    private Contenedor c;
    boolean estado= false;

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
        c = (Contenedor)getArguments()[0];
        c.crearHijos("Ag2", new Object[]{c,1});
        c.crearHijosB("Ag3", new Object[]{c,1});
    }

    @Override
    protected void takeDown() {
        System.out.println("Soy el agente 1 y voy a morir  :'V ");
    }

    class Comportamiento extends SimpleBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {

            ACLMessage acl = blockingReceive();
            ACLMessage acl2 = blockingReceive();
            doWait(10);
            int contenido1 = 0;
            int contenido2 = 0;
            try{
                contenido1 = Integer.parseInt( acl.getContent());
                contenido2 = Integer.parseInt( acl2.getContent());
            }catch (Exception e){
                System.out.println("Error de lectura");
                System.out.println("Porque uno es:  !!!!!!!!!!! "+acl.getSender().getLocalName());
                System.out.println("Porque dos es:  !!!!!!!!!!! "+acl2.getSender().getLocalName());
            }
            if(acl.getConversationId().equals("COD001")&&acl2.getConversationId().equals("COD001")
            ||acl.getConversationId().equals("COD001")&&acl2.getConversationId().equals("COD001")
            ){
                if(contenido1==10){
                    System.out.println("Gana el agente: "+acl.getSender().getLocalName());
                    System.out.println("Pierde el agente: "+acl2.getSender().getLocalName());
                    estado = true;
                }else if(contenido2==10){
                    System.out.println("Gana el agente: "+acl2.getSender().getLocalName());
                    System.out.println("Pierde el agente: "+acl.getSender().getLocalName());
                    estado = true;
                }else {
                    estado=false;
                }

            }else{
                System.out.println("error en algun lado agente 1 !!!!!!!!!!!!!!!!!!!!!!!!11");
            }
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, acl.getSender().getLocalName(), getAgent(),
                    estado+"","COD002");
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, acl2.getSender().getLocalName(), getAgent(),
                    estado+"","COD002");

            if(estado){
                doDelete();
            }
        }
        @Override
        public boolean done() {
            return bandera;
        }
    }
}
