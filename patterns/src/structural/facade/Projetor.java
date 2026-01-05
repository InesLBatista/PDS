package structural.facade;

class Projetor {
    private boolean ligado = false;
    private String modo = "Normal";
    
    public void ligar() {
        ligado = true;
        System.out.println("Projector ligado (Modo: " + modo + ")");
    }
    
    public void desligar() {
        ligado = false;
        System.out.println("Projector desligado");
    }
    
    public void setModoWideScreen() {
        modo = "WideScreen";
        System.out.println("Projector configurado para modo WideScreen (16:9)");
    }
    
    public void setModoNormal() {
        modo = "Normal";
        System.out.println("Projector configurado para modo Normal (4:3)");
    }
    
    public boolean isLigado() {
        return ligado;
    }
    
    public String getModo() {
        return modo;
    }
}
