package behavioral.command;

class Televisao {
    private String local;
    private boolean ligada;
    private int canal;
    private int canalAnterior;
    
    public Televisao(String local) {
        this.local = local;
        this.ligada = false;
        this.canal = 1;
        this.canalAnterior = 1;
    }
    
    public void ligar() {
        ligada = true;
        System.out.println("TV " + local + " ligada no canal " + canal);
    }
    
    public void desligar() {
        ligada = false;
        System.out.println("TV " + local + " desligada");
    }
    
    public void setCanal(int canal) {
        if (ligada) {
            canalAnterior = this.canal;
            this.canal = canal;
            System.out.println("TV " + local + " mudou para canal " + canal);
        } else {
            System.out.println("TV " + local + " está desligada");
        }
    }

    public void voltarCanalAnterior() {
        int temp = this.canal;
        this.canal = canalAnterior;
        canalAnterior = temp;
        System.out.println("TV " + local + " voltou para canal " + this.canal);
    }
    
    public boolean isLigada() {
        return ligada;
    }
    
    public int getCanal() {
        return canal;
    }
    
    public String getLocal() {
        return local;
    }
}
