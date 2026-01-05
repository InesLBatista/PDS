package structural.proxy;

class ProxySegurança implements Documento {
    private DocumentoReal documentoReal;
    private String utilizador;
    private String papel;
    
    public ProxySegurança(DocumentoReal documentoReal, String utilizador, String papel) {
        this.documentoReal = documentoReal;
        this.utilizador = utilizador;
        this.papel = papel;
    }
    
    private boolean verificarPermissao() {
        if (documentoReal.getTitulo().contains("confidencial")) {
            return "admin".equals(papel);
        } else if (documentoReal.getTitulo().contains("restrito")) {
            return "admin".equals(papel) || "gerente".equals(papel);
        }
        return true; // Documentos públicos
    }
    
    @Override
    public void mostrar() {
        if (verificarPermissao()) {
            System.out.println("Acesso permitido para " + utilizador + " (" + papel + ")");
            documentoReal.mostrar();
        } else {
            System.out.println("Acesso negado! " + utilizador + " não tem permissão para ver: " + 
                             documentoReal.getTitulo());
        }
    }
    
    @Override
    public String getTitulo() {
        return documentoReal.getTitulo();
    }
    
    @Override
    public String getConteudo() {
        if (verificarPermissao()) {
            return documentoReal.getConteudo();
        } else {
            return "Acesso negado: Não tem permissão para ver este conteúdo";
        }
    }
}

