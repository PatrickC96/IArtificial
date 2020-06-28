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
public class Ag4 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            //System.out.println("yo soy el agente 4 !!!");
            try {
                ACLMessage acl = blockingReceive();
                Paciente paciente = (Paciente) acl.getContentObject();
                if (acl.getConversationId().equalsIgnoreCase("COD003")) {
                    System.out.println("El paciente: "+paciente.getNombre()+" tiene una temperatura: "+paciente.getTemperatura());
                    
                } else if (acl.getConversationId().equalsIgnoreCase("COD004")) {                    
                    System.out.println("El paciente: "+paciente.getNombre()+" tiene una ritmo cardiaco: "+paciente.getRitmoCardiaco());
                    new EnviarMensaje().enviarMensajeObject(ACLMessage.REQUEST, "Ag5", getAgent(), paciente, "COD005");
                } else if (acl.getConversationId().equalsIgnoreCase("COD005")) {                    
                    System.out.println("El paciente: "+paciente.getNombre()+" tiene una edad: "+paciente.getEdad());                    
                }                
            } catch (UnreadableException ex) {
                Logger.getLogger(Ag5.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
