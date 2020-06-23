package trabajo1;

import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;

public class Contenedor {
    Object[] contenedor = new Object[1];

    public void contenedor() {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        runtime.setCloseVM(true);
        System.out.println("la rutina ha iniciado");
        ProfileImpl profile = new ProfileImpl(null, 1099, null);
        System.out.println("perfil creado con exito");
        AgentContainer mainContainer = runtime.createMainContainer(profile);
        System.out.println("contenedor creado" + profile.toString());
        System.out.println("contenedro: " + mainContainer.toString());
        contenedor[0] = this;
    }

    public static void main(String[] args) {

        new Contenedor().contenedor();
    }
}
