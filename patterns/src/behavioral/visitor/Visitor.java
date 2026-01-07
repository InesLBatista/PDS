package behavioral.visitor;

// Visitor.java - Interface visitor
public interface Visitor {
    void visitar(DocumentoTexto documento);
    void visitar(DocumentoPDF documento);
    void visitar(DocumentoImagem documento);
    void visitar(DocumentoPlanilha documento);
    void visitar(DocumentoApresentacao documento);
}
