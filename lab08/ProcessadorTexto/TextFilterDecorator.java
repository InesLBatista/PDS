package lab08.src;

public abstract class TextFilterDecorator implements TextStream {
    protected TextStream wrappee;

    public TextFilterDecorator(TextStream wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public boolean hasNext() {
        return wrappee.hasNext();
    }

    // O método next() será implementado em cada filtro para aplicar a transformação
    // e chamar wrappee.next() para obter o texto base.
    @Override
    public abstract String next();
}