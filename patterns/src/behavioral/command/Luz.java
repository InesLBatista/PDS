package behavioral.command;

class Luz {
    private String local;
    private boolean ligada;
    
    public Luz(String local) {
        this.local = local;
        this.ligada = false;
    }
    
    public void ligar() {
        ligada = true;
        System.out.println("Luz " + local + " ligada");
    }
    
    public void desligar() {
        ligada = false;
        System.out.println("Luz " + local + " desligada");
    }
    
    public boolean isLigada() {
        return ligada;
    }
    
    public String getLocal() {
        return local;
    }
}