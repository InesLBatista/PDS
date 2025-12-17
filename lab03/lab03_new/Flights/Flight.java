package Práticas.lab03.lab03_new.Flights;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight {

    private final String flightCode;            // Código do voo
    private final Aviao aviao;          // Instância do avião
    private final Map<Integer, Reserva> reservations; // Mapa de reservas
    private int nextReservationId = 1;          // Próximo ID de reserva

    public Flight(String flightCode, String execConfig, String touristConfig) {
        this.flightCode = flightCode;           // Define código do voo
        this.aviao = new Aviao(execConfig, touristConfig); // Cria avião com configurações
        this.reservations = new HashMap<>();   // Inicializa mapa de reservas
    }
    
    public String getFlightCode() { return flightCode; } // Retorna código do voo

    public String getAvailableSeatsStr() {
        long execTotal = (long) aviao.getExecRows() * aviao.getMaxSeatsPerRow(); // Total executiva
        long touristTotal = (long) (aviao.getTotalRows() - aviao.getExecRows()) * aviao.getMaxSeatsPerRow(); // Total turística

        List<String> parts = new java.util.ArrayList<>(); // Lista de partes da string
        if (execTotal > 0) parts.add(execTotal + " lugares em classe Executiva"); // Adiciona executiva
        if (touristTotal > 0) parts.add(touristTotal + " lugares em classe Turística"); // Adiciona turística
        
        return String.join("; ", parts) + ".";     // Retorna string final
    }

    public Reserva addReservation(char pClass, int numSeats) {
        if (Character.toUpperCase(pClass) == 'E' && aviao.getExecRows() == 0) { // Executiva indisponível
            System.out.println("Classe executiva não disponível neste voo."); 
            return null; 
        }

        List<int[]> assignedSeats = aviao.findAvailableSeats(pClass, numSeats); // Encontra assentos

        if (assignedSeats == null) {                // Assentos insuficientes
            System.out.println("Não foi possível obter lugares para a reserva: " + Character.toUpperCase(pClass) + " " + numSeats);
            return null;
        }

        int reservationId = this.nextReservationId++;            // Atribui ID de reserva
        String reservationCode = this.flightCode + ":" + reservationId; // Cria código da reserva
        
        for (int[] seat : assignedSeats) aviao.setSeat(seat[0], seat[1], reservationId); // Marca assentos

        Reserva newReservation = new Reserva(reservationCode, pClass, assignedSeats); // Cria objeto reserva
        this.reservations.put(reservationId, newReservation); // Adiciona reserva ao mapa
        return newReservation;                       // Retorna reserva
    }

    public void cancelReservation(String reservationCode) {
        try {
            int resId = Integer.parseInt(reservationCode.split(":")[1]); // Obtém ID da reserva
            if (reservations.containsKey(resId)) {                       // Verifica existência
                Reserva res = reservations.get(resId);                   // Obtém reserva
                for (int[] seat : res.getAssentosAtribuidos())         // Percorre assentos
                    aviao.setSeat(seat[0], seat[1], 0);                 // Liberta assento
                reservations.remove(resId);                               // Remove reserva
                System.out.println("Reserva " + reservationCode + " cancelada."); // Mensagem de sucesso
            } else {
                System.out.println("Erro: Reserva '" + reservationCode + "' não encontrada."); // Mensagem erro
            }
        } catch (Exception e) {
            System.out.println("Erro: Formato de código de reserva inválido '" + reservationCode + "'."); // Erro de formato
        }
    }

    public void displayMap() {
        int totalRows = aviao.getTotalRows();                        // Total de filas
        int maxSeats = aviao.getMaxSeatsPerRow();              // Maior número de assentos por fila
        int[][] map = aviao.getSeatingMap();                         // Mapa de assentos

        System.out.printf("%-3s", "");                               // Cabeçalho vazio
        for (int i = 1; i <= totalRows; i++) System.out.printf("%-3d", i); // Números das filas
        System.out.println();

        for (int s = 0; s < maxSeats; s++) {                        // Percorre lugares
            System.out.printf("%-3s", (char) ('A' + s));            // Letras das colunas
            for (int r = 0; r < totalRows; r++) {              // Percorre filas
                if (s < aviao.getSeatsPerRow(r))                // Se lugar válido
                    System.out.printf("%-3d", map[r][s]);           // Mostra ID da reserva
                else
                    System.out.printf("%-3s", "");                  // Espaço vazio
            }
            System.out.println();                                // Nova linha
        }
    }
}

