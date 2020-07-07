package intento6;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag3 extends Agent {

    private Contenedor c;
    int hijo;
    String nombreAgenteHijo = "Ag3";
    boolean estado=false;
    Agent nombre;

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        if(estado){
            System.out.println("Muere el agente 3 :v ");
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Ag2", nombre,
                    "muere","COD004");
        }else{
            System.out.println("Sigue participando");
            c.crearHijosB(nombreAgenteHijo, new Object[]{c,hijo});
        }
    }

    class Comportamiento extends SimpleBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {
nombre=getAgent();
            new EnviarMensaje().enviarMensajeString(ACLMessage.REQUEST, "Ag1", getAgent(),
                    generarAleatorioRango(1,100)+"","COD001");
            c = (Contenedor)getArguments()[0];
            if(!getArguments()[1].equals("muere")){
                try{
                    hijo = (int) getArguments()[1];
                }catch (Exception e){
                    System.out.println("error fatal!!!!!!!!!!!!!!!");
                    System.out.println(getArguments());
                }
                nombreAgenteHijo = "AgenteB-" + hijo;
                System.out.println("Soy: ("+nombreAgenteHijo+")");
                hijo++;
                bandera = true;
                ACLMessage acl = blockingReceive();
                try{
                    estado = Boolean.parseBoolean( acl.getContent());
                }catch (Exception e){
                    System.out.println("Error al transformar a bool !!!!!!!!!!!!!!");
                }
            }else {
                estado=true;
            }
            bandera = true;
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
