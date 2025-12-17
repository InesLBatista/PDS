package Praticas.lab07.ex3;

public class BasicPrinter {
    
    private int inkAmount; 
    private int paperAmount; 

    public BasicPrinter() {
        this.inkAmount = 10;  // Aumentado para permitir mais impressões
        this.paperAmount = 10;
    }

    public boolean print(String[] content) {
        if (this.hasInk() && this.hasPaper()) {
            try {
                Thread.sleep(800); // Tempo de impressão
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
            this.inkAmount--;
            this.paperAmount--;
            if (this.inkAmount == 0 || this.paperAmount == 0) {
                System.out.println("Please refill printer.");
            }
            return true;
        }
        return false;
    }

    public boolean hasInk() {
        return this.inkAmount > 0;
    } 

    public boolean hasPaper() {
        return this.paperAmount > 0;
    } 

    public void addInk() {
        this.inkAmount += 10;
    } 

    public void addPaper() {
        this.paperAmount += 10;
    } 

    public void refill() {
        this.addInk();
        this.addPaper();
        System.out.println("Printer refilled.");
    }
}