package behavioral.memento;

class MementoEditor {
    private final String texto;
    private final int posicaoCursor;
    private final FormatoTexto formato;
    private final long timestamp;
    
    // Construtor package-private (apenas classes do mesmo pacote podem criar)
    MementoEditor(String texto, int posicaoCursor, FormatoTexto formato) {
        this.texto = texto;
        this.posicaoCursor = posicaoCursor;
        this.formato = new FormatoTexto(formato); // Cópia defensiva
        this.timestamp = System.currentTimeMillis();
    }
    
    // Métodos package-private para acesso apenas pelo EditorTexto
    String getTexto() {
        return texto;
    }
    
    int getPosicaoCursor() {
        return posicaoCursor;
    }
    
    FormatoTexto getFormato() {
        return new FormatoTexto(formato); // Cópia defensiva
    }
    
    long getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String toString() {
        return String.format("Memento [%tT]: %d chars, cursor: %d", 
                           timestamp, texto.length(), posicaoCursor);
    }
}
