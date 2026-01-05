package behavioral.command;

class MacroComando implements Comando {
    private Comando[] comandos;
    
    public MacroComando(Comando[] comandos) {
        this.comandos = comandos;
    }
    
    @Override
    public void executar() {
        System.out.println("Executando macro com " + comandos.length + " comandos:");
        for (int i = 0; i < comandos.length; i++) {
            comandos[i].executar();
        }
    }
    
    @Override
    public void desfazer() {
        System.out.println("Desfazendo macro com " + comandos.length + " comandos:");
        for (int i = comandos.length - 1; i >= 0; i--) {
            comandos[i].desfazer();
        }
    }
}

