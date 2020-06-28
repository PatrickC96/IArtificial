/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo5;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Ag5 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            //System.out.println("yo soy el agente 5 !!!");
            try {
                ACLMessage acl = blockingReceive();
                Paciente paciente = (Paciente) acl.getContentObject();

                if (acl.getConversationId().equalsIgnoreCase("COD001")) {
                    System.out.println("El paciente: "+paciente.getNombre()+" tiene una precion: "+paciente.getPresion());

                } else if (acl.getConversationId().equalsIgnoreCase("COD002")) {
                    System.out.println("El paciente: "+paciente.getNombre()+" tiene una temperatura: "+paciente.getTemperatura());

                } else if (acl.getConversationId().equalsIgnoreCase("COD005")) {
                    System.out.println("El paciente: "+paciente.getNombre()+" tiene riesgo: "+paciente.isReisgo());
                    new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "Ag4", getAgent(), paciente, "COD006");
                }
            } catch (UnreadableException ex) {
                Logger.getLogger(Ag5.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
