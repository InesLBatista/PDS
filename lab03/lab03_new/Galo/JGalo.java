package Práticas.lab03.lab03_new.Galo;

import java.util.Scanner;

public class JGalo implements JGaloInterface {

    private char currentPlayer;   // Jogador atual ('X' ou 'O')
    private char nextPlayer;      // Próximo jogador
    private final char[][] board; // Tabuleiro 3x3 do jogo
    private char winner;          // Guarda o vencedor ou ' ' para empate

    public JGalo() {
        this.board = new char[3][3];          // Inicializa tabuleiro vazio
        this.currentPlayer = askStartingPlayer(); // Define quem começa
        this.nextPlayer = currentPlayer;      // Inicializa próximo jogador
        this.winner = '\0';                   // Sem vencedor inicial
    }

    private char askStartingPlayer() {
        System.out.print("Digite se quer começar como O ou X: ");
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine().trim().toUpperCase(); // Lê input
            if (input.isEmpty()) return 'X';                   // Valor padrão
            char c = input.charAt(0);                          // Primeiro caractere
            return (c == 'X' || c == 'O') ? c : 'X';           // Validação simples
        }
    }

    @Override
    public char getActualPlayer() {
        currentPlayer = nextPlayer;                            // Define jogador atual
        nextPlayer = (nextPlayer == 'X') ? 'O' : 'X';          // Alterna jogador
        return currentPlayer;                                  // Retorna símbolo
    }

    @Override
    public boolean setJogada(int lin, int col) {
        int row = lin - 1;                                     // Ajusta índice da linha
        int column = col - 1;                                  // Ajusta índice da coluna
        if (board[row][column] != '\0') return false;           // Verifica célula ocupada
        board[row][column] = currentPlayer;                    // Regista jogada
        return true;                                           // Jogada válida
    }

    @Override
    public boolean isFinished() {
        for (int i = 0; i < 3; i++) {                          // Percorre linhas e colunas
            if (checkLine(board[i][0], board[i][1], board[i][2])) return true; // Linha
            if (checkLine(board[0][i], board[1][i], board[2][i])) return true; // Coluna
        }
        if (checkLine(board[0][0], board[1][1], board[2][2])) return true;     // Diagonal principal
        if (checkLine(board[0][2], board[1][1], board[2][0])) return true;     // Diagonal secundária
        if (isBoardFull()) { winner = ' '; return true; }      // Verifica empate
        return false;                                          // Jogo continua
    }

    private boolean checkLine(char a, char b, char c) {
        if (a != '\0' && a == b && b == c) {                   // Verifica linha igual
            winner = a;                                        // Define vencedor
            return true;                                       // Vitória encontrada
        }
        return false;                                          // Sem vitória
    }

    private boolean isBoardFull() {
        for (char[] row : board)                               // Percorre linhas
            for (char cell : row)                              // Percorre células
                if (cell == '\0') return false;                 // Há espaço livre
        return true;                                           // Tabuleiro cheio
    }

    @Override
    public char checkResult() {
        return winner;                                         // Retorna resultado final
    }
}
