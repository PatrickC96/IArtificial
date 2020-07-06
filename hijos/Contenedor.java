/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hijos;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Contenedor {
    AgentController agenteController;
    AgentContainer mainContainer;
    Object[] contenedor = new Object[1];

    public void contenedor() {
        jade.core.Runtime runtime = jade.core.Runtime.instance();

        runtime.setCloseVM(true);
        System.out.println("Runtime ha sido creado\n");

        Profile profile = new ProfileImpl(null, 1099, null);
        System.out.println("Perfil por defecto creado");

        mainContainer = runtime.createMainContainer(profile);
        System.out.println("Contenedor creado" + profile.toString());
        contenedor[0] = this;
        iniciarAgentes();
    }

    private void iniciarAgentes() {

        try {
            //el ultimo elementeo es el conocimito.
            //no se debe ejecutar el ejente desde sin 
            mainContainer.createNewAgent("Ag1", Ag1.class.getName(), null).start();
            mainContainer.createNewAgent("Ag2", Ag2.class.getName(), new Object[]{this}).start();
            //mainContainer.createNewAgent("Ag3", Ag3.class.getName(), null).start();
//
        } catch (StaleProxyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void crearHijos(String nickname,Object[] conocimiento){
        try {
            mainContainer.createNewAgent(nickname, agente.AgenteH.class.getName(), conocimiento).start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(contenedor.Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        new Contenedor().contenedor();
    }    
}
