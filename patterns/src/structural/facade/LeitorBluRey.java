package structural.facade;

class LeitorBluRay {
    private boolean ligado = false;
    private String filmeActual = "";
    
    public void ligar() {
        ligado = true;
        System.out.println("Leitor de Blu-ray ligado");
    }
    
    public void desligar() {
        ligado = false;
        System.out.println("Leitor de Blu-ray desligado");
    }
    
    public void reproduzir(String filme) {
        if (!ligado) ligar();
        this.filmeActual = filme;
        System.out.println("A reproduzir filme: " + filme);
    }
    
    public void parar() {
        System.out.println("A parar reprodução do filme: " + filmeActual);
        filmeActual = "";
    }
    
    public void ejectar() {
        System.out.println("Disco ejectado do leitor de Blu-ray");
    }
    
    public boolean isLigado() {
        return ligado;
    }
}