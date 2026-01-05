package behavioral.memento;

class EditorTexto {
    private String texto;
    private int posicaoCursor;
    private FormatoTexto formatoAtual;
    
    public EditorTexto() {
        this.texto = "";
        this.posicaoCursor = 0;
        this.formatoAtual = new FormatoTexto();
    }
    
    // Métodos para modificar o estado
    public void inserirTexto(String textoParaInserir) {
        if (posicaoCursor >= 0 && posicaoCursor <= texto.length()) {
            String parte1 = texto.substring(0, posicaoCursor);
            String parte2 = texto.substring(posicaoCursor);
            texto = parte1 + textoParaInserir + parte2;
            posicaoCursor += textoParaInserir.length();
        }
    }
    
    public void apcarTexto(int quantidade) {
        if (quantidade > 0 && posicaoCursor >= quantidade) {
            String parte1 = texto.substring(0, posicaoCursor - quantidade);
            String parte2 = texto.substring(posicaoCursor);
            texto = parte1 + parte2;
            posicaoCursor -= quantidade;
        }
    }
    
    public void moverCursor(int deslocamento) {
        int novaPosicao = posicaoCursor + deslocamento;
        if (novaPosicao >= 0 && novaPosicao <= texto.length()) {
            posicaoCursor = novaPosicao;
        }
    }
    
    public void setPosicaoCursor(int posicao) {
        if (posicao >= 0 && posicao <= texto.length()) {
            posicaoCursor = posicao;
        }
    }
    
    // Métodos de formatação
    public void alternarNegrito() {
        formatoAtual.alternarNegrito();
    }
    
    public void alternarItalico() {
        formatoAtual.alternarItalico();
    }
    
    public void alternarSublinhado() {
        formatoAtual.alternarSublinhado();
    }
    
    public void setTamanhoFonte(int tamanho) {
        formatoAtual.setTamanhoFonte(tamanho);
    }
    
    // Métodos Memento: criar e restaurar snapshots
    public MementoEditor criarMemento() {
        return new MementoEditor(texto, posicaoCursor, formatoAtual);
    }
    
    public void restaurarMemento(MementoEditor memento) {
        this.texto = memento.getTexto();
        this.posicaoCursor = memento.getPosicaoCursor();
        this.formatoAtual = memento.getFormato();
    }
    
    // Métodos para visualização (não modificam estado)
    public String getTexto() {
        return texto;
    }
    
    public int getPosicaoCursor() {
        return posicaoCursor;
    }
    
    public FormatoTexto getFormatoAtual() {
        return new FormatoTexto(formatoAtual); // Cópia defensiva
    }
    
    public int getTamanhoTexto() {
        return texto.length();
    }
    
    public void exibirEstado() {
        String cursorMarker = " ".repeat(Math.max(0, posicaoCursor)) + "|";
        String preview = texto.replace("\n", "\\n");
        if (preview.length() > 50) {
            preview = preview.substring(0, 47) + "...";
        }
        
        System.out.println("Texto: \"" + preview + "\"");
        System.out.println("Cursor: " + cursorMarker);
        System.out.println("Posição cursor: " + posicaoCursor + "/" + texto.length());
        System.out.println("Formato: " + formatoAtual);
        System.out.println("Tamanho: " + texto.length() + " caracteres");
    }
}

