package upo20052528.trials.Model;

public enum Parametro {
    TEMPERATURA("NUMERIC"),
    PRESSIONE("SCALAR"),
    CAPACITA_POLMONARE("SCALAR"),
    PESO("NUMERIC");

    private final String type;
    Parametro(String type) {this.type=type;}

    public String getType() {
        return type;
    }

    public enum LivelliP {
        BASSO,
        MEDIO,
        ALTO;
    }

    public enum Genere{
        UOMO,
        DONNA
    }
}