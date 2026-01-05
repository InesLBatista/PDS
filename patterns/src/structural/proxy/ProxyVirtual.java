package structural.proxy;

class ProxyVirtual implements Documento {
    private String titulo;
    private DocumentoReal documentoReal = null;
    
    public ProxyVirtual(String titulo) {
        this.titulo = titulo;
        System.out.println("ProxyVirtual criado para: " + titulo);
        // Objecto real ainda não foi criado!
    }
    
    private synchronized void inicializarDocumentoReal() {
        if (documentoReal == null) {
            System.out.println("Inicializando DocumentoReal (lazy loading)...");
            documentoReal = new DocumentoReal(titulo);
        }
    }
    
    @Override
    public void mostrar() {
        inicializarDocumentoReal();
        documentoReal.mostrar();
    }
    
    @Override
    public String getTitulo() {
        return titulo;
    }
    
    @Override
    public String getConteudo() {
        inicializarDocumentoReal();
        return documentoReal.getConteudo();
    }
}
