package behavioral.command;

class ArCondicionado {
    private String local;
    private int temperatura;
    private int temperaturaAnterior;
    
    public ArCondicionado(String local) {
        this.local = local;
        this.temperatura = 24;
        this.temperaturaAnterior = 24;
    }
    
    public void setTemperatura(int temperatura) {
        temperaturaAnterior = this.temperatura;
        this.temperatura = temperatura;
        System.out.println("Ar-condicionado " + local + " ajustado para " + temperatura + "°C");
    }
    
    public void voltarTemperaturaAnterior() {
        int temp = this.temperatura;
        this.temperatura = temperaturaAnterior;
        temperaturaAnterior = temp;
        System.out.println("Ar-condicionado " + local + " voltou para " + this.temperatura + "°C");
    }
    
    public int getTemperatura() {
        return temperatura;
    }
    
    public String getLocal() {
        return local;
    }
}
