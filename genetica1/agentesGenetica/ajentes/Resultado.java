package genetica1.agentesGenetica.ajentes;

import java.io.Serializable;

public class Resultado implements Serializable {
    private Float x;
    private Float y;

    public Resultado(Float x, Float y) {
        this.x = x;
        this.y = y;
    }
    public Float getX() {
        return x;
    }

    public Float getY() {
        return y;
    }
}
