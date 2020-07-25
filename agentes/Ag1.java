package agentes;

import genes.funcion1.Prueba1;
import genes.funcion2.Prueba2;
import genes.funcion3.Prueba3;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag1 extends Agent {

    private Contenedor c;
    int hijo;
    private boolean estado = false;

    @Override
    protected void setup() {
        //permite agregar comportamiento
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        if (estado){
            System.out.println("Muero Agente 1 -"+(hijo-1)+" con: "+getAID().getLocalName()+" !!!!!!");
        }else{
            c.crearHijos("Ag1"+hijo, new Object[]{c,hijo});
            System.out.println("Muero Agente 1 -"+(hijo-1)+" con: "+getAID().getLocalName()+" !!!!!!");
        }

    }

    class Comportamiento extends SimpleBehaviour {
        private boolean bandera = false;
        @Override
        public void action() {
            double valorcontenido=0;
            c = (Contenedor)getArguments()[0];
            hijo = (int) getArguments()[1];
            switch (hijo){
                case 1:
                    System.out.println("caso 1");
                    double valor = new Prueba1().empezar();
                    System.out.println("###### El valor de 1: "+valor);
                    valorcontenido = valor;
                    break;
                case 2:
                    System.out.println("caso 2");
                    double valor2 = new Prueba2().empezar();
                    System.out.println("###### El valor de 2: "+valor2);
                    valorcontenido = valor2;
                    break;
                case 3:
                    System.out.println("caso 3");
                    double valor3 = new Prueba3().empezar();
                    System.out.println("###### El valor de 3: "+valor3);
                    valorcontenido = valor3;
                    break;
                default:
                    System.out.println("ningun caso");
            }
            Cliente cliente = new Cliente(valorcontenido);
            new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "Ag2", getAgent(),
                    cliente,"COD001");
            //doWait(1000);

            if(hijo>=3){
                estado = true;
            }
            hijo++;
            doDelete();
        }
        @Override
        public boolean done() {
            return bandera;
        }
    }

}
