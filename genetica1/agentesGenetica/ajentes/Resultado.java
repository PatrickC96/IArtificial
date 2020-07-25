package genetica1.agentesGenetica.ajentes;

import java.io.Serializable;

public class Resultado implements Serializable {
    private double x;
    private double y;

    public Resultado(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
