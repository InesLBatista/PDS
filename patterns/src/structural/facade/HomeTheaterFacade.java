package structural.facade;

class HomeTheaterFacade {
    private Amplificador amplificador;
    private LeitorBluRay leitorBluRay;
    private Projetor projetor;
    private SistemaDeLuzes luzes;
    private EcrãProjecção ecrã;
    private MáquinaDePipocas máquinaPipocas;
    
    public HomeTheaterFacade(Amplificador amplificador, 
                            LeitorBluRay leitorBluRay,
                            Projetor projetor,
                            SistemaDeLuzes luzes,
                            EcrãProjecção ecrã,
                            MáquinaDePipocas máquinaPipocas) {
        this.amplificador = amplificador;
        this.leitorBluRay = leitorBluRay;
        this.projetor = projetor;
        this.luzes = luzes;
        this.ecrã = ecrã;
        this.máquinaPipocas = máquinaPipocas;
    }
    
    // Método de alto nível: Ver um filme
    public void verFilme(String filme) {
        System.out.println("\n🎬 A PREPARAR PARA VER FILME: " + filme);
        System.out.println("=" .repeat(50));
        
        máquinaPipocas.fazerPipocas();
        luzes.atenuar(10);
        ecrã.descer();
        projetor.ligar();
        projetor.setModoWideScreen();
        amplificador.ligar();
        amplificador.setEntrada("Blu-ray");
        amplificador.setVolume(70);
        leitorBluRay.ligar();
        leitorBluRay.reproduzir(filme);
        
        System.out.println("=" .repeat(50));
        System.out.println("✅ Sistema preparado! Aproveite o filme!\n");
    }
    
    // Método de alto nível: Finalizar o filme
    public void fimDoFilme() {
        System.out.println("\n⏹️ A FINALIZAR SESSÃO DE CINEMA");
        System.out.println("-" .repeat(50));
        
        leitorBluRay.parar();
        leitorBluRay.ejectar();
        leitorBluRay.desligar();
        amplificador.desligar();
        projetor.desligar();
        ecrã.subir();
        máquinaPipocas.desligar();
        luzes.ligar();
        luzes.atenuar(100);
        
        System.out.println("-" .repeat(50));
        System.out.println("✅ Sessão finalizada! Sistema desligado.\n");
    }
    
    // Método de alto nível: Ouvir música
    public void ouvirMusica(String musica) {
        System.out.println("\n🎵 A PREPARAR PARA OUVIR MÚSICA: " + musica);
        System.out.println("-" .repeat(50));
        
        luzes.atenuar(30);
        amplificador.ligar();
        amplificador.setEntrada("Streaming");
        amplificador.setVolume(60);
        leitorBluRay.ligar();
        System.out.println("A reproduzir música: " + musica);
        
        System.out.println("-" .repeat(50));
        System.out.println("✅ Sistema preparado! Aproveite a música!\n");
    }
    
    // Método de alto nível: Finalizar música
    public void fimDaMusica() {
        System.out.println("\n⏹️ A FINALIZAR REPRODUÇÃO DE MÚSICA");
        System.out.println("-" .repeat(50));
        
        leitorBluRay.desligar();
        amplificador.desligar();
        luzes.atenuar(100);
        
        System.out.println("-" .repeat(50));
        System.out.println("✅ Reprodução finalizada!\n");
    }
    
    // Método adicional: Configuração personalizada
    public void configurarModoJogo() {
        System.out.println("\n🎮 A CONFIGURAR MODO JOGO");
        System.out.println("-" .repeat(50));
        
        luzes.atenuar(70);
        amplificador.ligar();
        amplificador.setVolume(80);
        amplificador.setEntrada("Console");
        System.out.println("Sistema configurado para modo jogo");
        
        System.out.println("-" .repeat(50));
        System.out.println("✅ Modo jogo activado! Divirta-se!\n");
    }
}
