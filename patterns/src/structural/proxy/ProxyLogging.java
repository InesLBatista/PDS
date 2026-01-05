package structural.proxy;

class ProxyLogging implements Documento {
    private Documento documento;
    
    public ProxyLogging(Documento documento) {
        this.documento = documento;
    }
    
    private void log(String operacao) {
        System.out.println("Log: " + operacao + " - " + documento.getTitulo() + 
                         " - " + java.time.LocalDateTime.now());
    }
    
    @Override
    public void mostrar() {
        log("Tentativa de visualização");
        documento.mostrar();
        log("Visualização concluída");
    }
    
    @Override
    public String getTitulo() {
        log("Consulta de título");
        return documento.getTitulo();
    }
    
    @Override
    public String getConteudo() {
        log("Consulta de conteúdo");
        return documento.getConteudo();
    }
}