package structural.bridge;

public abstract class Relatorio {
    protected Formato formato;

    public Relatorio(Formato formato) {
        this.formato = formato;
    }

    public abstract void gerar();
}
