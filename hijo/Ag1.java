package hijo;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag1 extends Agent {
    private Contenedor c;

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
        c = (Contenedor)getArguments()[0];
        c.crearHijos("Ag2", new Object[]{c,1});
    }

    @Override
    protected void takeDown() {
        System.out.println("Soy el agente 1 y voy a morir  :'V ");
    }

    class Comportamiento extends SimpleBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {

            int contenido=0;
            ACLMessage acl = blockingReceive();
            AID nombre = acl.getSender();

            try {
                contenido = Integer.parseInt( acl.getContent());
            }catch (Exception e){
                System.out.println("Error al transformar"+acl.getContent()+"!!!!!!!!!");
            }

            if(contenido==10){
                new EnviarMensaje().enviarMensajeString(ACLMessage.REQUEST, nombre.getLocalName(), getAgent(),
                        true+"","COD002");
                System.out.println("Es el: "+contenido+" Felicitaciones");
                doDelete();
            } else {
               new EnviarMensaje().enviarMensajeString(ACLMessage.REQUEST, nombre.getLocalName(), getAgent(),
                        false+"","COD003");
                System.out.println("No es el: "+contenido);
            }
        }
        @Override
        public boolean done() {
            return bandera;
        }
    }
}
