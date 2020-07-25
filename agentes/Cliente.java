package agentes;

import java.io.Serializable;

public class Cliente implements Serializable {

    private double valor;
    private boolean apto;
    private double cupo;

    public Cliente(double valor) {
        this.valor = valor;
        this.apto = false;
        this.cupo =30000;
    }

    public double getValor() {
        return valor;
    }

    public boolean isApto() {
        return apto;
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }

    public double getCupo() {
        return cupo;
    }

    public void setCupo(double cupo) {
        this.cupo = cupo;
    }
}
