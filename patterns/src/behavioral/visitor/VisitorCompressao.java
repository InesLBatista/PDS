package behavioral.visitor;

// VisitorCompressao.java - Visitor concreto
public class VisitorCompressao implements Visitor {
    
    @Override
    public void visitar(DocumentoTexto documento) {
        System.out.println("Comprimindo documento de texto: " + documento.getNome());
        long tamanhoOriginal = documento.getTamanho();
        long tamanhoComprimido = tamanhoOriginal / 3;
        System.out.println("  Tamanho original: " + tamanhoOriginal + " bytes");
        System.out.println("  Tamanho apos compressao: " + tamanhoComprimido + " bytes");
        System.out.println("  Taxa de compressao: 66%");
    }
    
    @Override
    public void visitar(DocumentoPDF documento) {
        System.out.println("Comprimindo documento PDF: " + documento.getNome());
        long tamanhoOriginal = documento.getTamanho();
        long tamanhoComprimido = tamanhoOriginal * 9 / 10;
        System.out.println("  Tamanho original: " + tamanhoOriginal + " bytes");
        System.out.println("  Tamanho apos compressao: " + tamanhoComprimido + " bytes");
        System.out.println("  Taxa de compressao: 10% (PDF ja e comprimido)");
    }
    
    @Override
    public void visitar(DocumentoImagem documento) {
        System.out.println("Comprimindo documento de imagem: " + documento.getNome());
        long tamanhoOriginal = documento.getTamanho();
        long tamanhoComprimido = tamanhoOriginal / 2;
        System.out.println("  Tamanho original: " + tamanhoOriginal + " bytes");
        System.out.println("  Tamanho apos compressao: " + tamanhoComprimido + " bytes");
        System.out.println("  Taxa de compressao: 50%");
    }
    
    @Override
    public void visitar(DocumentoPlanilha documento) {
        System.out.println("Comprimindo documento de planilha: " + documento.getNome());
        long tamanhoOriginal = documento.getTamanho();
        long tamanhoComprimido = tamanhoOriginal / 4;
        System.out.println("  Tamanho original: " + tamanhoOriginal + " bytes");
        System.out.println("  Tamanho apos compressao: " + tamanhoComprimido + " bytes");
        System.out.println("  Taxa de compressao: 75%");
    }
    
    @Override
    public void visitar(DocumentoApresentacao documento) {
        System.out.println("Comprimindo documento de apresentacao: " + documento.getNome());
        long tamanhoOriginal = documento.getTamanho();
        long tamanhoComprimido = tamanhoOriginal * 8 / 10;
        System.out.println("  Tamanho original: " + tamanhoOriginal + " bytes");
        System.out.println("  Tamanho apos compressao: " + tamanhoComprimido + " bytes");
        System.out.println("  Taxa de compressao: 20%");
    }
}
