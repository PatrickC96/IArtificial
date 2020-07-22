package genetica1.agentesGenetica.ajentes;

import genetica1.agentesGenetica.genes.Mostrar;
import genetica1.agentesGenetica.genes.Prueba;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import org.jgap.IChromosome;

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
            Resultado resultado=null;

            ACLMessage acl = blockingReceive();
            AID nombre = acl.getSender();
            System.out.println(acl.getContent());
//            try{
                Object [] obj = new Prueba().empezar();
                resultado = new Resultado(Float.parseFloat(obj[0].toString()),Float.parseFloat(obj[1].toString()));

//            }catch (Exception e){
//                System.out.println("Error en la genetica");
//                doDelete();
//
//            }

            new EnviarMensaje().enviarMensajeObject(ACLMessage.REQUEST, nombre.getLocalName(), getAgent(),
                    resultado,"COD002");

            //doDelete();
        }
        @Override
        public boolean done() {
            return bandera;
        }
    }
}
