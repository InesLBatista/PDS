package structural.facade;

class MáquinaDePipocas {
    private boolean ligada = false;
    
    public void ligar() {
        ligada = true;
        System.out.println("Máquina de pipocas ligada");
    }
    
    public void desligar() {
        ligada = false;
        System.out.println("Máquina de pipocas desligada");
    }
    
    public void fazerPipocas() {
        if (!ligada) ligar();
        System.out.println("A preparar pipocas... Pipocas prontas!");
    }
    
    public boolean isLigada() {
        return ligada;
    }
}