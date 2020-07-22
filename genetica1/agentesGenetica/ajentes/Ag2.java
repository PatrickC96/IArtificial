package genetica1.agentesGenetica.ajentes;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag2 extends Agent {

    private Contenedor c;
    int hijo;
    String nombreAgenteHijo = "Ag2";
    boolean estado=false;

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        if(estado){
            System.out.println("Finalizo con exito agente hijos: "+getLocalName()+"!!!!!!!!!!");
        }else{
            c.crearHijos(nombreAgenteHijo, new Object[]{c,hijo});
        }
    }

    class Comportamiento extends SimpleBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {

            new EnviarMensaje().enviarMensajeString(ACLMessage.REQUEST, "Ag1", getAgent(),
                    "hola yo soy: "+getLocalName()+"!!!!!!","COD001");
            c = (Contenedor)getArguments()[0];
            try{
                hijo = (int) getArguments()[1];
            }catch (Exception e){
                System.out.println("error fatal!!!!!!!!!!!!!!!");
                System.out.println(getArguments());
                estado=false;
            }
            nombreAgenteHijo = "Agente-" + hijo;
            System.out.println("Soy: ("+nombreAgenteHijo+")");
            hijo++;
            bandera = true;
            ACLMessage acl = blockingReceive();
            try {
                Resultado resultado =  (Resultado) acl.getContentObject();
                System.out.println("Los resultados son X:"+resultado.getX()+", Y: "+resultado.getY());
            }catch (Exception e){
                System.out.println("Error en obtener el objeto");
                estado=true;
            }


            //estado=true;
            doWait(1000);
            doDelete();
        }
        @Override
        public boolean done() {
            return bandera;
        }
    }
}
