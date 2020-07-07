package hijo;

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
            System.out.println("!!!!!!!!!!!!!!! Ganaste la Partida !!!!!!!!!!!!!");
        }else{
            System.out.println("Sigue participando");
            c.crearHijos(nombreAgenteHijo, new Object[]{c,hijo});
        }
    }

    class Comportamiento extends SimpleBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {

            new EnviarMensaje().enviarMensajeString(ACLMessage.REQUEST, "Ag1", getAgent(),
                    generarAleatorioRango(1,20)+"","COD001");
            c = (Contenedor)getArguments()[0];
            try{
                if (((int) getArguments()[1])>0) {
                    hijo = (int) getArguments()[1];
                }
            }catch (Exception e){
                System.out.println("error faltal!!!!!!!!!!!!!!!");
                System.out.println(getArguments());
                hijo=1;
            }
            nombreAgenteHijo = "Ag2 - " + hijo;
            System.out.println("Soy el agente ("+nombreAgenteHijo+")");
            hijo++;
            bandera = true;
            ACLMessage acl = blockingReceive();
            try{
                estado = Boolean.parseBoolean( acl.getContent());
            }catch (Exception e){
                System.out.println("Error al trasfomar a bool !!!!!!!!!!!!!!");
            }
            //doWait(1000);
            doDelete();
        }
        @Override
        public boolean done() {
            return bandera;
        }
    }

    public static int generarAleatorioRango(int inicio, int fin) {
        //Desde inicio hasta fin, ambos incluidos
        return (int) (Math.random() * ((fin + 1) - inicio)) + inicio;
    }
}
