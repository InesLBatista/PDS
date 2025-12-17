package Práticas.lab03.lab03_new.Flights;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final FlightManager manager = new FlightManager(); // Instância do gestor de voos

    public static void main(String[] args) {
        if (args.length > 0) {               // Se argumento de ficheiro fornecido
            runFromFile(args[0]);            // Executa comandos a partir do ficheiro
        } else {
            runInteractive();                // Executa modo interativo
        }
    }

    private static void runInteractive() {
        printHelp();                          // Mostra menu de ajuda
        try (Scanner scanner = new Scanner(System.in)) { // Scanner para input do utilizador
            while (true) {
                System.out.print("Escolha uma opção: (H para ajuda) "); // Prompt
                String line = scanner.nextLine().trim(); // Lê linha
                if (line.isEmpty()) continue;        // Ignora linha vazia
                if (processCommand(line)) break;     // Processa comando e termina se necessário
            }
        }
    }

    private static void runFromFile(String filename) {
        try {
            List<String> commands = Files.readAllLines(Paths.get(filename)); // Lê todas as linhas
            for (String command : commands) {
                if (!command.trim().isEmpty()) {         // Ignora linhas vazias
                    System.out.println("\n> " + command); // Mostra comando
                    if (processCommand(command.trim())) break; // Processa comando e termina se necessário
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler o ficheiro de comandos '" + filename + "': " + e.getMessage()); // Mensagem de erro
        }
    }

    private static boolean processCommand(String line) {
        String[] parts = line.split("\\s+");   // Divide comando em partes
        String command = parts[0].toUpperCase(); // Comando principal

        switch (command) {
            case "H": printHelp(); break;      // Menu de ajuda
            case "I":                          // Lê voo de ficheiro
                if (parts.length == 2) manager.loadFlightFromFile(parts[1]); 
                else System.out.println("Uso: I <filename>"); 
                break;
            case "M":                          // Mostra mapa do voo
                if (parts.length == 2) {
                    Flight f = manager.getFlight(parts[1]); // Obtém voo
                    if (f != null) f.displayMap();         // Mostra mapa
                    else System.out.println("Erro: Voo '" + parts[1] + "' não encontrado."); // Erro
                } else System.out.println("Uso: M <flight_code>");
                break;
            case "F": manager.addFlight(parts); break; // Adiciona novo voo
            case "R":                          // Cria nova reserva
                if (parts.length == 4) {
                    Flight f = manager.getFlight(parts[1]); // Obtém voo
                    if (f != null) {
                        Reserva r = f.addReservation(parts[2].charAt(0), Integer.parseInt(parts[3])); // Adiciona reserva
                        if (r != null) {
                            System.out.println(r.getCodigoReserva() + " = " + String.join(" ", r.getSeatCodes())); // Mostra reserva
                        }
                    } else System.out.println("Erro: Voo '" + parts[1] + "' não encontrado."); // Erro
                } else System.out.println("Uso: R <flight_code> <class> <num_seats>");
                break;
            case "C":                          // Cancela reserva
                if (parts.length == 2) {
                    String flightCode = parts[1].split(":")[0]; // Extrai código do voo
                    Flight f = manager.getFlight(flightCode);  // Obtém voo
                    if (f != null) f.cancelReservation(parts[1]); // Cancela reserva
                    else System.out.println("Erro: Voo '" + flightCode + "' não encontrado."); // Erro
                } else System.out.println("Uso: C <reservation_code>");
                break;
            case "Q": System.out.println("A terminar o programa."); return true; // Termina programa
            default: System.out.println("Comando inválido. Digite H para ajuda."); // Comando desconhecido
        }
        return false;                        // Continua execução
    }

    private static void printHelp() {        // Mostra lista de comandos
        System.out.println("\nComandos disponíveis:");
        System.out.println("H                               - Menu de ajuda");
        System.out.println("I <filename>                    - Lê a informação de um voo de um ficheiro.");
        System.out.println("M <flight_code>                 - Mapa de reservas de um voo.");
        System.out.println("F <code> <exec> <tourist>       - Acrescenta um novo voo (ex., F TP123 4x3 20x3).");
        System.out.println("F <code> <tourist>              - Acrescenta um novo voo (só com classe turística).");
        System.out.println("R <code> <class> <num>          - Nova reserva.");
        System.out.println("C <reservation_code>            - Cancela uma reserva (ex., C TP123:1).");
        System.out.println("Q                               - Termina o programa.\n");
    }
}
