package Práticas.lab03.lab03_new.Flights;

import java.util.List;
import java.util.stream.Collectors;

public class Reserva {
    private final String codigoReserva;            // Código único da reserva
    private final List<int[]> assentosAtribuidos;    // Lista de assentos atribuídos

    public Reserva(String codigo, char classe, List<int[]> assentos) {
        this.codigoReserva = codigo;                 // Define o código da reserva
        this.assentosAtribuidos = assentos;    // Armazena os assentos atribuídos
    }

    public String getCodigoReserva() {
        return codigoReserva;          // Retorna o código da reserva
    }

    public List<int[]> getAssentosAtribuidos() {
        return assentosAtribuidos;              // Retorna a lista de assentos
    }

    public List<String> getSeatCodes() {
        return assentosAtribuidos.stream()           // Converte assentos em códigos (ex.: 1A, 1B)
                .map(seat -> (seat[0] + 1) + String.valueOf((char) ('A' + seat[1]))) 
                .collect(Collectors.toList());     // Retorna lista de códigos
    }
}
