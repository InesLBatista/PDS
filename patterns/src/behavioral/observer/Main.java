package behavioral.observer;

public class Main {
    public static void main(String[] args) {
        System.out.println("padrão observer - sistema meteorológico\n");
        
        // 1. criar estação meteorológica (sujeito)
        EstacaoMeteorologica estacao = new EstacaoMeteorologica();
        
        // 2. criar observadores (displays e alertas)
        DisplayCondicoesAtuais displayPrincipal = new DisplayCondicoesAtuais("display principal");
        DisplayEstatisticas displayEstatisticas = new DisplayEstatisticas("estatísticas");
        DisplayPrevisao displayPrevisao = new DisplayPrevisao("previsão do tempo");
        AlertaTemperatura alertaCalor = new AlertaTemperatura("alerta calor", 15, 30);
        AlertaTemperatura alertaFrio = new AlertaTemperatura("alerta frio", -5, 10);
        
        System.out.println("\n--- configuração inicial ---");
        System.out.println("estação meteorológica criada");
        System.out.println("dispositivos criados: 5");
        System.out.println("observadores registados: " + estacao.getNumeroObservadores());
        System.out.println("-----------------------------\n");
        
        // 3. registar observadores na estação
        System.out.println("a registar observadores na estação...\n");
        estacao.registarObservador(displayPrincipal);
        estacao.registarObservador(displayEstatisticas);
        estacao.registarObservador(displayPrevisao);
        estacao.registarObservador(alertaCalor);
        
        System.out.println("\nobservadores registados: " + estacao.getNumeroObservadores());
        System.out.println("\n==========================================\n");
        
        // 4. simular mudanças nas condições meteorológicas
        System.out.println("simulação 1: condições normais de primavera");
        System.out.println("--------------------------------------------");
        estacao.definirMedidas(22.5f, 65.0f, 1015.0f);
        
        System.out.println("simulação 2: pequena variação");
        System.out.println("-----------------------------");
        estacao.definirMedidas(23.0f, 63.0f, 1016.5f);
        
        System.out.println("simulação 3: frente fria a chegar");
        System.out.println("----------------------------------");
        estacao.definirMedidas(18.0f, 85.0f, 1005.0f);
        
        System.out.println("simulação 4: onda de calor");
        System.out.println("---------------------------");
        
        // adicionar novo observador dinamicamente
        System.out.println("a adicionar novo alerta durante a simulação...");
        estacao.registarObservador(alertaFrio);
        
        estacao.definirMedidas(35.0f, 40.0f, 1010.0f);
        
        System.out.println("simulação 5: frio intenso");
        System.out.println("--------------------------");
        
        // remover um observador
        System.out.println("a remover display de estatísticas...");
        estacao.removerObservador(displayEstatisticas);
        
        estacao.definirMedidas(2.0f, 90.0f, 1020.0f);
        
        System.out.println("simulação 6: volta ao normal");
        System.out.println("----------------------------");
        estacao.definirMedidas(20.0f, 70.0f, 1013.0f);
        
        System.out.println("\n==========================================\n");
        
        // 5. demonstrar registo dinâmico
        System.out.println("demonstração: registo dinâmico de observadores");
        System.out.println("-----------------------------------------------\n");
        
        System.out.println("a criar novo display especializado...");
        DisplayCondicoesAtuais displayJardim = new DisplayCondicoesAtuais("display jardim");
        
        System.out.println("\na registar novo display...");
        estacao.registarObservador(displayJardim);
        
        System.out.println("\na actualizar medidas para novo display...");
        estacao.definirMedidas(25.0f, 60.0f, 1012.0f);
        
        System.out.println("\na remover display do jardim...");
        estacao.removerObservador(displayJardim);
        
        System.out.println("\na actualizar medidas (display do jardim não deve receber)...");
        estacao.definirMedidas(26.0f, 58.0f, 1011.0f);
        
        System.out.println("\n==========================================\n");
        
        // 6. testar com mesmo dado (não deve notificar)
        System.out.println("teste: actualização com mesmo dado");
        System.out.println("-----------------------------------\n");
        System.out.println("a enviar dados idênticos aos actuais...");
        estacao.definirMedidas(26.0f, 58.0f, 1011.0f);
        System.out.println("nenhuma notificação deve aparecer acima (otimização)");
        
        System.out.println("\n==========================================\n");
        
        // 7. estado final do sistema
        System.out.println("estado final do sistema:");
        System.out.println("-----------------------");
        System.out.println("observadores activos: " + estacao.getNumeroObservadores());
        System.out.println("última temperatura: " + estacao.getTemperatura() + "°c");
        System.out.println("última humidade: " + estacao.getHumidade() + "%");
        System.out.println("última pressão: " + estacao.getPressao() + " hpa");
        
        System.out.println("\n==========================================\n");
        
        // 8. resumo dos benefícios
        System.out.println("resumo dos benefícios do padrão observer:\n");
        
        System.out.println("- baixo acoplamento:");
        System.out.println("  - sujeito conhece apenas a interface observador");
        System.out.println("  - observadores não conhecem outros observadores");
        System.out.println("  - mudanças num observador não afetam outros");
        
        System.out.println("\n- comunicação automática:");
        System.out.println("  - notificações automáticas quando estado muda");
        System.out.println("  - observadores recebem dados actualizados");
        System.out.println("  - sem necessidade de polling constante");
        
        System.out.println("\n- flexibilidade dinâmica:");
        System.out.println("  - observadores podem ser adicionados/removidos em tempo real");
        System.out.println("  - diferentes tipos de observadores podem coexistir");
        System.out.println("  - sistema pode crescer sem modificar sujeito");
        
        System.out.println("\n- princípio aberto/fechado:");
        System.out.println("  - pode adicionar novos observadores sem modificar sujeito");
        System.out.println("  - sujeito está fechado para modificação, aberto para extensão");
        System.out.println("  - código mais fácil de manter e estender");
        
        System.out.println("\n- eficiência:");
        System.out.println("  - notificações só quando dados mudam");
        System.out.println("  - observadores só recebem dados quando necessário");
        System.out.println("  - otimização automática");
        
        System.out.println("\n- reutilização:");
        System.out.println("  - observadores podem ser reutilizados em diferentes sujeitos");
        System.out.println("  - sujeito pode notificar diferentes tipos de observadores");
        System.out.println("  - padrão aplicável a muitos domínios diferentes");
        
        System.out.println("\npadrão observer implementado com sucesso");
    }
}
