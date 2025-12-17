package Práticas.lab03.lab03_new.Flights;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FlightManager {

    private final Map<String, Flight> flights = new HashMap<>(); // Mapa de voos pelo código

    public void addFlight(String[] parts) {
        String flightCode, execConfig = null, touristConfig;   // Variáveis para configuração
        if (parts.length == 3) {                                // Comando sem executiva
            flightCode = parts[1]; touristConfig = parts[2];    // Define código e turística
        } else if (parts.length == 4) {                         // Comando com executiva
            flightCode = parts[1]; execConfig = parts[2]; touristConfig = parts[3]; // Define configs
        } else {
            System.out.println("Erro: Número de argumentos inválido para o comando F."); return; // Erro
        }

        if (flights.containsKey(flightCode)) {                  // Verifica voo duplicado
            System.out.println("Erro: Voo com o código '" + flightCode + "' já existe."); return; // Erro
        }
        
        try {
            Flight flight = new Flight(flightCode, execConfig, touristConfig); // Cria voo
            flights.put(flightCode, flight);                     // Adiciona ao mapa
            System.out.println("Voo " + flightCode + " criado com sucesso."); // Mensagem sucesso
        } catch (Exception e) {
            System.out.println("Erro ao criar voo: " + e.getMessage()); // Mensagem de erro
        }
    }

    public Flight getFlight(String flightCode) {
        return flights.get(flightCode);                        // Retorna voo pelo código
    }
    
    public void loadFlightFromFile(String filename) {
        try (Scanner fileScanner = new Scanner(new File(filename))) { // Lê ficheiro
            String[] parts = fileScanner.nextLine().substring(1).trim().split("\\s+"); // Primeira linha
            String flightCode = parts[0];                       // Código do voo
            String execConfig = null, touristConfig;            // Inicializa configs

            if (parts.length == 3) { execConfig = parts[1]; touristConfig = parts[2]; } // Configs completas
            else { touristConfig = parts[1]; }                  // Apenas turística

            Flight flight = new Flight(flightCode, execConfig, touristConfig); // Cria voo
            flights.put(flightCode, flight);                    // Adiciona ao mapa
            System.out.println("Código de voo " + flight.getFlightCode() + ". Lugares disponíveis: " + flight.getAvailableSeatsStr()); // Mensagem

            while (fileScanner.hasNextLine()) {                 // Percorre linhas restantes
                String[] resParts = fileScanner.nextLine().trim().split("\\s+"); // Divide dados
                if (resParts.length == 2)                         // Verifica formato
                    flight.addReservation(resParts[0].charAt(0), Integer.parseInt(resParts[1])); // Adiciona reserva
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Ficheiro '" + filename + "' não encontrado."); // Ficheiro não existe
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao ler o ficheiro: " + e.getMessage()); // Erro genérico
            e.printStackTrace();                                  // Mostra stack trace
        }
    }
}

