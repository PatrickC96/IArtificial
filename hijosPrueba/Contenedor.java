/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hijosPrueba;

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
    AgentController agentController;
    AgentContainer mainContainer;

    public void contenedor() {
        jade.core.Runtime runtime = jade.core.Runtime.instance();

        runtime.setCloseVM(true);
        //System.out.println("Runtime ha sido creado\n");

        Profile profile = new ProfileImpl(null, 1098, null);
        //System.out.println("Perfil por defecto creado");

        mainContainer = runtime.createMainContainer(profile);
        //System.out.println("Contenedor creado" + profile.toString());
        iniciarAgentes();
    }

    private void iniciarAgentes() {

        try {
            agentController = mainContainer.createNewAgent("Agente1", Agente1.class.getName(), null);
            agentController.start();
            //OTRA FORMA DE INICIALIZARLO
            mainContainer.createNewAgent("Agente2", Agente2.class.getName(), new Object[]{this}).start();
        } catch (StaleProxyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void crearHijos(String nickname,Object[] conocimiento){
        try {
            mainContainer.createNewAgent(nickname, AgenteH.class.getName(), conocimiento).start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(contenedor.Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        new Contenedor().contenedor();
    }    
}
