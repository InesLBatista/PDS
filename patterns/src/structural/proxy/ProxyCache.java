package structural.proxy;

class ProxyCache implements Documento {
    private Documento documento;
    private String conteudoCache = null;
    private boolean cacheValido = false;
    
    public ProxyCache(Documento documento) {
        this.documento = documento;
    }
    
    @Override
    public void mostrar() {
        if (!cacheValido) {
            System.out.println("Cache miss - carregando do documento real...");
            conteudoCache = documento.getConteudo();
            cacheValido = true;
        } else {
            System.out.println("Cache hit - usando conteúdo em cache...");
        }
        
        System.out.println("\n--- Documento (cache): " + getTitulo() + " ---");
        System.out.println(conteudoCache);
        System.out.println("---------------------------------------------\n");
    }
    
    @Override
    public String getTitulo() {
        return documento.getTitulo();
    }
    
    @Override
    public String getConteudo() {
        if (!cacheValido) {
            conteudoCache = documento.getConteudo();
            cacheValido = true;
        }
        return conteudoCache;
    }
    
    public void invalidarCache() {
        cacheValido = false;
        conteudoCache = null;
        System.out.println("Cache invalidado para: " + getTitulo());
    }
}