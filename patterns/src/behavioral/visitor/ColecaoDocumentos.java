package behavioral.visitor;

// ColecaoDocumentos.java - Estrutura de objetos
import java.util.ArrayList;
import java.util.List;

public class ColecaoDocumentos {
    private List<Documento> documentos;
    
    public ColecaoDocumentos() {
        documentos = new ArrayList<>();
    }
    
    public void adicionarDocumento(Documento documento) {
        documentos.add(documento);
    }
    
    public void removerDocumento(Documento documento) {
        documentos.remove(documento);
    }
    
    public void aceitarVisitor(Visitor visitor) {
        for (Documento documento : documentos) {
            documento.aceitar(visitor);
        }
    }
    
    public int getNumeroDocumentos() {
        return documentos.size();
    }
    
    public List<Documento> getDocumentos() {
        return new ArrayList<>(documentos);
    }
}
