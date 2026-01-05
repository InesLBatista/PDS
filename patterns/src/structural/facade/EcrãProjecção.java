package structural.facade;

class EcrãProjecção {
    private boolean abaixado = false;
    
    public void descer() {
        abaixado = true;
        System.out.println("Ecrã de projecção abaixado");
    }
    
    public void subir() {
        abaixado = false;
        System.out.println("Ecrã de projecção recolhido");
    }
    
    public boolean isAbaixado() {
        return abaixado;
    }
}