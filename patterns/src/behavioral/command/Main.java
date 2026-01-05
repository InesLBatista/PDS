package behavioral.command;

public class Main {
    public static void main(String[] args) {
        System.out.println("Padrão Command - Sistema de Automação Residencial\n");
        
        // 1. Criar dispositivos (receptores)
        Luz luzSala = new Luz("sala");
        Luz luzQuarto = new Luz("quarto");
        ArCondicionado arSala = new ArCondicionado("sala");
        Televisao tvSala = new Televisao("sala");
        
        System.out.println("Dispositivos criados:\n");
        System.out.println("- Luz sala: desligada");
        System.out.println("- Luz quarto: desligada");
        System.out.println("- Ar-condicionado sala: 24°C");
        System.out.println("- TV sala: desligada");
        System.out.println("\n========================================================\n");
        
        // 2. Criar comandos
        Comando ligarLuzSala = new LigarLuzComando(luzSala);
        Comando desligarLuzSala = new DesligarLuzComando(luzSala);
        Comando ligarLuzQuarto = new LigarLuzComando(luzQuarto);
        Comando desligarLuzQuarto = new DesligarLuzComando(luzQuarto);
        Comando aumentarTemperatura = new AumentarTemperaturaComando(arSala, 2);
        Comando diminuirTemperatura = new DiminuirTemperaturaComando(arSala, 2);
        Comando ligarTV = new LigarTVComando(tvSala, 7);
        Comando desligarTV = new DesligarTVComando(tvSala);
        
        System.out.println("Comandos criados para controlar dispositivos\n");
        System.out.println("========================================================\n");
        
        // 3. Criar controle remoto
        ControleRemoto controle = new ControleRemoto(8);
        
        // Configurar botões
        controle.setComando(0, ligarLuzSala);
        controle.setComando(1, desligarLuzSala);
        controle.setComando(2, ligarLuzQuarto);
        controle.setComando(3, desligarLuzQuarto);
        controle.setComando(4, aumentarTemperatura);
        controle.setComando(5, diminuirTemperatura);
        controle.setComando(6, ligarTV);
        controle.setComando(7, desligarTV);
        
        System.out.println("Controle remoto configurado com 8 botões\n");
        System.out.println("Botão 0: Ligar luz sala");
        System.out.println("Botão 1: Desligar luz sala");
        System.out.println("Botão 2: Ligar luz quarto");
        System.out.println("Botão 3: Desligar luz quarto");
        System.out.println("Botão 4: Aumentar temperatura (+2°C)");
        System.out.println("Botão 5: Diminuir temperatura (-2°C)");
        System.out.println("Botão 6: Ligar TV (canal 7)");
        System.out.println("Botão 7: Desligar TV");
        System.out.println("\n========================================================\n");
        
        // 4. Testar comandos básicos
        System.out.println("Testando comandos básicos:\n");
        
        System.out.println("1. Ligar luz da sala (botão 0):");
        controle.pressionarBotao(0);
        System.out.println();
        
        System.out.println("2. Ligar luz do quarto (botão 2):");
        controle.pressionarBotao(2);
        System.out.println();
        
        System.out.println("3. Aumentar temperatura (botão 4):");
        controle.pressionarBotao(4);
        System.out.println();
        
        System.out.println("4. Ligar TV (botão 6):");
        controle.pressionarBotao(6);
        System.out.println();
        
        System.out.println("Estado atual:");
        System.out.println("- Luz sala: " + (luzSala.isLigada() ? "ligada" : "desligada"));
        System.out.println("- Luz quarto: " + (luzQuarto.isLigada() ? "ligada" : "desligada"));
        System.out.println("- Ar-condicionado: " + arSala.getTemperatura() + "°C");
        System.out.println("- TV: " + (tvSala.isLigada() ? "ligada (canal " + tvSala.getCanal() + ")" : "desligada"));
        System.out.println("\n========================================================\n");
        
        // 5. Testar undo/redo
        System.out.println("Testando operações undo/redo:\n");
        
        System.out.println("Desfazendo última ação (undo):");
        controle.desfazer();
        System.out.println();
        
        System.out.println("Estado após undo:");
        System.out.println("- TV: " + (tvSala.isLigada() ? "ligada" : "desligada"));
        System.out.println();
        
        System.out.println("Refazendo ação (redo):");
        controle.refazer();
        System.out.println();
        
        System.out.println("Estado após redo:");
        System.out.println("- TV: " + (tvSala.isLigada() ? "ligada" : "desligada"));
        System.out.println();
        
        System.out.println("Desfazendo várias ações:");
        controle.desfazer(); // TV
        controle.desfazer(); // Temperatura
        controle.desfazer(); // Luz quarto
        System.out.println();
        
        System.out.println("Estado após múltiplos undos:");
        System.out.println("- Luz sala: " + (luzSala.isLigada() ? "ligada" : "desligada"));
        System.out.println("- Luz quarto: " + (luzQuarto.isLigada() ? "ligada" : "desligada"));
        System.out.println("- Ar-condicionado: " + arSala.getTemperatura() + "°C");
        System.out.println("- TV: " + (tvSala.isLigada() ? "ligada" : "desligada"));
        System.out.println("\n========================================================\n");
        
        // 6. Criar e testar macros
        System.out.println("Criando e testando macros:\n");
        
        // Macro: Modo cinema
        Comando[] comandosCinema = {
            new DesligarLuzComando(luzSala),
            new DesligarLuzComando(luzQuarto),
            new DiminuirTemperaturaComando(arSala, 3),
            new LigarTVComando(tvSala, 21) // Canal de filmes
        };
        
        Comando modoCinema = new MacroComando(comandosCinema);
        
        // Macro: Modo sair
        Comando[] comandosSair = {
            new DesligarLuzComando(luzSala),
            new DesligarLuzComando(luzQuarto),
            new DesligarTVComando(tvSala)
        };
        
        Comando modoSair = new MacroComando(comandosSair);
        
        // Configurar macros no controle
        ControleRemoto controleMacro = new ControleRemoto(2);
        controleMacro.setComando(0, modoCinema);
        controleMacro.setComando(1, modoSair);
        
        System.out.println("Preparando para modo cinema:");
        System.out.println("- Ligando luzes e TV...");
        ligarLuzSala.executar();
        ligarLuzQuarto.executar();
        aumentarTemperatura.executar();
        System.out.println();
        
        System.out.println("Ativando modo cinema (macro 0):");
        controleMacro.pressionarBotao(0);
        System.out.println();
        
        System.out.println("Estado após modo cinema:");
        System.out.println("- Luz sala: " + (luzSala.isLigada() ? "ligada" : "desligada"));
        System.out.println("- Luz quarto: " + (luzQuarto.isLigada() ? "ligada" : "desligada"));
        System.out.println("- Ar-condicionado: " + arSala.getTemperatura() + "°C");
        System.out.println("- TV: " + (tvSala.isLigada() ? "ligada (canal " + tvSala.getCanal() + ")" : "desligada"));
        System.out.println();
        
        System.out.println("Desfazendo modo cinema:");
        controleMacro.desfazer();
        System.out.println();
        
        System.out.println("Ativando modo sair (macro 1):");
        controleMacro.pressionarBotao(1);
        System.out.println();
        
        System.out.println("========================================================\n");
        
        // 7. Demonstração de flexibilidade
        System.out.println("Demonstração de flexibilidade:\n");
        
        // Criar novo dispositivo sem modificar controle remoto
        System.out.println("Adicionando novo dispositivo: cortina");
        
        // Simulando um novo dispositivo
        class Cortina {
            private String local;
            private boolean aberta;
            
            public Cortina(String local) {
                this.local = local;
                this.aberta = false;
            }
            
            public void abrir() {
                aberta = true;
                System.out.println("Cortina " + local + " aberta");
            }
            
            public void fechar() {
                aberta = false;
                System.out.println("Cortina " + local + " fechada");
            }
        }
        
        // Criar comandos para novo dispositivo
        Cortina cortinaSala = new Cortina("sala");
        
        class AbrirCortinaComando implements Comando {
            private Cortina cortina;
            
            public AbrirCortinaComando(Cortina cortina) {
                this.cortina = cortina;
            }
            
            @Override
            public void executar() {
                cortina.abrir();
            }
            
            @Override
            public void desfazer() {
                cortina.fechar();
            }
        }
        
        Comando abrirCortina = new AbrirCortinaComando(cortinaSala);
        
        // Usar com novo controle
        ControleRemoto controleNovo = new ControleRemoto(1);
        controleNovo.setComando(0, abrirCortina);
        
        System.out.println("Controlando novo dispositivo com mesmo controle:");
        controleNovo.pressionarBotao(0);
        System.out.println();
        
        System.out.println("Desfazendo ação na cortina:");
        controleNovo.desfazer();
        System.out.println();
        
        System.out.println("========================================================\n");
        
        // 8. Resumo dos benefícios
        System.out.println("Resumo dos benefícios do padrão Command:\n");
        
        System.out.println("- Encapsulamento: Ações são objetos que podem ser armazenados e passados");
        System.out.println("- Desacoplamento: Invocador não conhece receptores específicos");
        System.out.println("- Undo/Redo: Histórico de operações suportado naturalmente");
        System.out.println("- Macros: Comandos podem ser combinados em sequências");
        System.out.println("- Extensibilidade: Novos comandos podem ser adicionados sem modificar código existente");
        System.out.println("- Flexibilidade: Comandos podem ser agendados, enfileirados ou logados");
        
        System.out.println("\nPadrão Command implementado com sucesso");
    }
}