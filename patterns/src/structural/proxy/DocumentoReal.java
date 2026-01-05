package structural.proxy;

class DocumentoReal implements Documento {
    private String titulo;
    private String conteudo;
    private boolean carregado = false;
    
    public DocumentoReal(String titulo) {
        this.titulo = titulo;
        System.out.println("DocumentoReal criado para: " + titulo);
        // Nota: Ainda não carregou o conteúdo (lazy loading no proxy)
    }
    
    private void carregarConteudo() {
        if (!carregado) {
            System.out.println("Carregando conteúdo do disco/database para: " + titulo);
            // Simula carregamento lento
            try {
                Thread.sleep(2000); // 2 segundos de carregamento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // Simula conteúdo real
            this.conteudo = "Conteúdo confidencial de " + titulo + 
                           "\nData: " + java.time.LocalDate.now() +
                           "\nEste é o conteúdo sensível do documento que requer carregamento pesado.";
            carregado = true;
            System.out.println("Conteúdo carregado para: " + titulo);
        }
    }
    
    @Override
    public void mostrar() {
        carregarConteudo();
        System.out.println("\n--- Documento: " + titulo + " ---");
        System.out.println(conteudo);
        System.out.println("-----------------------------------\n");
    }
    
    @Override
    public String getTitulo() {
        return titulo;
    }
    
    @Override
    public String getConteudo() {
        carregarConteudo();
        return conteudo;
    }
}