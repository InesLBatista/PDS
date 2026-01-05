package behavioral.memento;

class FormatoTexto {
    private boolean negrito;
    private boolean italico;
    private boolean sublinhado;
    private int tamanhoFonte;
    
    public FormatoTexto() {
        this.negrito = false;
        this.italico = false;
        this.sublinhado = false;
        this.tamanhoFonte = 12;
    }
    
    // Construtor de cópia
    public FormatoTexto(FormatoTexto outro) {
        this.negrito = outro.negrito;
        this.italico = outro.italico;
        this.sublinhado = outro.sublinhado;
        this.tamanhoFonte = outro.tamanhoFonte;
    }
    
    public boolean isNegrito() { return negrito; }
    public boolean isItalico() { return italico; }
    public boolean isSublinhado() { return sublinhado; }
    public int getTamanhoFonte() { return tamanhoFonte; }
    
    public void setNegrito(boolean negrito) { this.negrito = negrito; }
    public void setItalico(boolean italico) { this.italico = italico; }
    public void setSublinhado(boolean sublinhado) { this.sublinhado = sublinhado; }
    public void setTamanhoFonte(int tamanhoFonte) { 
        this.tamanhoFonte = Math.max(8, Math.min(72, tamanhoFonte)); 
    }
    
    public void alternarNegrito() { this.negrito = !this.negrito; }
    public void alternarItalico() { this.italico = !this.italico; }
    public void alternarSublinhado() { this.sublinhado = !this.sublinhado; }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (negrito) sb.append("N");
        if (italico) sb.append("I");
        if (sublinhado) sb.append("S");
        if (sb.length() == 0) sb.append("-");
        sb.append(" T").append(tamanhoFonte);
        return sb.toString();
    }
}
