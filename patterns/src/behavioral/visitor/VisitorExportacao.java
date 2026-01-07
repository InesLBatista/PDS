package behavioral.visitor;

// VisitorExportacao.java - Visitor concreto
public class VisitorExportacao implements Visitor {
    
    @Override
    public void visitar(DocumentoTexto documento) {
        System.out.println("Exportando documento de texto: " + documento.getNome());
        System.out.println("  Formato: " + documento.getFormato());
        System.out.println("  Tamanho: " + documento.getTamanho() + " bytes");
        System.out.println("  Exportando para formato TXT...");
    }
    
    @Override
    public void visitar(DocumentoPDF documento) {
        System.out.println("Exportando documento PDF: " + documento.getNome());
        System.out.println("  Numero de paginas: " + documento.getNumeroPaginas());
        System.out.println("  Tamanho: " + documento.getTamanho() + " bytes");
        System.out.println("  Exportando para formato PDF/A...");
    }
    
    @Override
    public void visitar(DocumentoImagem documento) {
        System.out.println("Exportando documento de imagem: " + documento.getNome());
        System.out.println("  Resolucao: " + documento.getResolucao());
        System.out.println("  Tamanho: " + documento.getTamanho() + " bytes");
        System.out.println("  Exportando para formato PNG...");
    }
    
    @Override
    public void visitar(DocumentoPlanilha documento) {
        System.out.println("Exportando documento de planilha: " + documento.getNome());
        System.out.println("  Dimensoes: " + documento.getNumeroLinhas() + "x" + documento.getNumeroColunas());
        System.out.println("  Tamanho: " + documento.getTamanho() + " bytes");
        System.out.println("  Exportando para formato CSV...");
    }
    
    @Override
    public void visitar(DocumentoApresentacao documento) {
        System.out.println("Exportando documento de apresentacao: " + documento.getNome());
        System.out.println("  Numero de slides: " + documento.getNumeroSlides());
        System.out.println("  Tamanho: " + documento.getTamanho() + " bytes");
        System.out.println("  Exportando para formato PDF...");
    }
}