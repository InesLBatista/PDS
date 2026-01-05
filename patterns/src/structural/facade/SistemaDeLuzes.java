package structural.facade;

class SistemaDeLuzes {
    private boolean ligadas = false;
    private int intensidade = 100;
    
    public void ligar() {
        ligadas = true;
        System.out.println("Luzes ligadas (Intensidade: " + intensidade + "%)");
    }
    
    public void desligar() {
        ligadas = false;
        System.out.println("Luzes desligadas");
    }
    
    public void atenuar(int nivel) {
        intensidade = nivel;
        System.out.println("Luzes atenuadas para " + intensidade + "%");
    }
    
    public boolean isLigadas() {
        return ligadas;
    }
    
    public int getIntensidade() {
        return intensidade;
    }
}
