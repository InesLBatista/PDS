package structural.facade;

class Amplificador {
    private boolean ligado = false;
    private int volume = 50;
    private String entrada = "";
    
    public void ligar() {
        ligado = true;
        System.out.println("Amplificador ligado");
    }
    
    public void desligar() {
        ligado = false;
        System.out.println("Amplificador desligado");
    }
    
    public void setVolume(int nivel) {
        this.volume = nivel;
        System.out.println("Volume ajustado para " + volume);
    }
    
    public void setEntrada(String entrada) {
        this.entrada = entrada;
        System.out.println("Entrada do amplificador configurada para " + this.entrada);
    }
    
    public boolean isLigado() {
        return ligado;
    }
    
    public int getVolume() {
        return volume;
    }
    
    public String getEntrada() {
        return entrada;
    }
}