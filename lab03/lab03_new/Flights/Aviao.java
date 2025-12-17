package Práticas.lab03.lab03_new.Flights;

import java.util.ArrayList;
import java.util.List;

public class Aviao {

    private final int execRows;                // Número de filas na classe executiva
    private final int execSeatsPerRow;         // Lugares por fila na classe executiva
    private final int touristRows;             // Número de filas na classe económica
    private final int touristSeatsPerRow;      // Lugares por fila na classe económica
    private final int totalRows;               // Número total de filas do avião
    private final int[][] seatingMap;          // Mapa do assento com reservas

    public Aviao(String execConfig, String touristConfig) {
        int[] exec = parseConfig(execConfig);                      // Analisa configuração executiva
        this.execRows = exec[0];                                   // Define filas executivas
        this.execSeatsPerRow = exec[1];                            // Define lugares por fila executiva

        int[] tourist = parseConfig(touristConfig);                // Analisa configuração económica
        this.touristRows = tourist[0];                             // Define filas económicas
        this.touristSeatsPerRow = tourist[1];                      // Define lugares por fila económica

        if (this.execSeatsPerRow > 26 || this.touristSeatsPerRow > 26)
            throw new IllegalArgumentException("O número de lugares por fila não pode exceder 26."); // Limite de lugares

        this.totalRows = this.execRows + this.touristRows;         // Calcula número total de filas
        this.seatingMap = new int[totalRows][];                    // Inicializa mapa do assento
        for (int i = 0; i < this.execRows; i++) seatingMap[i] = new int[this.execSeatsPerRow]; // Preenche filas executivas
        for (int i = 0; i < this.touristRows; i++) seatingMap[execRows + i] = new int[this.touristSeatsPerRow]; // Preenche filas económicas
    }

    private int[] parseConfig(String config) {
        if (config == null || config.isEmpty()) return new int[]{0, 0}; // Retorna zero se vazio
        String[] parts = config.toLowerCase().split("x");               // Separa número de filas e lugares
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])}; // Converte para inteiros
    }

    public int getExecRows() { return execRows; }                        // Retorna filas executivas
    public int getTotalRows() { return totalRows; }                       // Retorna filas totais
    public int[][] getSeatingMap() { return seatingMap; }                 // Retorna mapa de assentos
    public int getSeatsPerRow(int row) { return seatingMap[row].length; } // Retorna lugares numa fila
    public int getMaxSeatsPerRow() { return Math.max(execSeatsPerRow, touristSeatsPerRow); } // Retorna maior fila

    public void setSeat(int row, int col, int reservationId) {           // Define reserva para um assento
        this.seatingMap[row][col] = reservationId;                       // Regista reserva
    }

    public List<int[]> findAvailableSeats(char pClass, int numSeats) {
        int startRow = (Character.toUpperCase(pClass) == 'E') ? 0 : execRows; // Determina fila inicial
        int endRow = (Character.toUpperCase(pClass) == 'E') ? execRows : totalRows; // Determina fila final

        List<int[]> availableSeats = new ArrayList<>();                   // Lista de assentos disponíveis
        for (int r = startRow; r < endRow; r++)                           // Percorre filas
            for (int s = 0; s < seatingMap[r].length; s++)                // Percorre lugares
                if (seatingMap[r][s] == 0) availableSeats.add(new int[]{r, s}); // Adiciona assento livre

        if (availableSeats.size() < numSeats) return null;                // Retorna null se insuficiente

        List<Integer> emptyRows = new ArrayList<>();                      // Lista de filas vazias
        for (int r = startRow; r < endRow; r++) {                         // Percorre filas
            boolean rowIsEmpty = true;                                    // Assume fila vazia
            for (int seat : seatingMap[r]) if (seat != 0) { rowIsEmpty = false; break; } // Verifica ocupação
            if (rowIsEmpty) emptyRows.add(r);                              // Adiciona fila vazia
        }

        int seatsInEmptyRows = emptyRows.size() * ((Character.toUpperCase(pClass) == 'E') ? execSeatsPerRow : touristSeatsPerRow); // Calcula assentos livres
        if (seatsInEmptyRows >= numSeats) {                                // Se filas vazias suficientes
            List<int[]> assigned = new ArrayList<>();                      // Lista de assentos atribuídos
            int seatsToAssign = numSeats;                                  // Contador de assentos
            for (int rowIdx : emptyRows) {                                 // Percorre filas vazias
                if (seatsToAssign == 0) break;                             // Termina se preencher todos
                for (int seatIdx = 0; seatIdx < seatingMap[rowIdx].length; seatIdx++) {
                    if (seatsToAssign == 0) break;                         // Termina se preencher todos
                    assigned.add(new int[]{rowIdx, seatIdx});              // Adiciona assento
                    seatsToAssign--;                                       // Decrementa contador
                }
            }
            return assigned;                                               // Retorna assentos atribuídos
        } else {                                                           // Se filas vazias insuficientes
            return availableSeats.subList(0, numSeats);                    // Retorna primeiros assentos disponíveis
        }
    }
}
