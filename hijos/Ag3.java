package hijos;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag3 extends Agent {
    private contenedor.Contenedor c;
    int hijo=0;
    String nombreAgenteHijo = "";

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
        super.setup();
    }

    @Override
    protected void takeDown() {
        System.out.println("Adios soy "+getName());
        c.crearHijos(nombreAgenteHijo, new Object[]{c,hijo});
        super.takeDown();
    }

    class Comportamiento extends SimpleBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {
            System.out.println(getName());
            ACLMessage msj =  blockingReceive();

            c = (contenedor.Contenedor)getArguments()[0];

            ACLMessage msj2 = new ACLMessage(ACLMessage.INFORM);
            msj2.addReceiver(msj.getSender()); // QUIEN RECIBE EL MENSAJE
            msj2.setSender(getAID());
            msj2.setContent("mori Ag3"+getArguments()[1].toString());
            msj2.setConversationId("agH to ag1");
            msj2.setLanguage("Spanish");
            doWait(1000);
            send(msj2);

            hijo = (int) getArguments()[1];
            nombreAgenteHijo = "Ag3"+hijo;
            hijo++;
            //---------------------------------------------------
            bandera = true;
            doDelete();
            //DO DELETE pausa los hilos uno a uno, libera los recursos

        }
        @Override
        public boolean done() {
            return bandera;
        }
    }
}
