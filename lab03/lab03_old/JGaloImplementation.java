package Práticas.lab03.lab03_old;

public class JGaloImplementation implements JGaloInterface {

    private char[][] table = new char[3][3];
    private final char DEFAULT = ' ';
    private char currentPlayer = 'X';
    private int playCount = 0;

    // Construtor: inicia o tabuleiro vazio
    public JGaloImplementation() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = DEFAULT;
            }
        }
    }

    // Indica que jogador tem a jogada atual
    public char getActualPlayer() {
        return currentPlayer;
    }

    // Regista jogada se posição estiver livre e alterna o jogador
    public boolean setJogada(int lin, int col) {
        if (table[lin - 1][col - 1] == DEFAULT) {
            table[lin - 1][col - 1] = currentPlayer;
            playCount++;
            // Alterna jogador
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        }
        return false;
    }

    // Indica se o jogo terminou (vitória ou empate)
    public boolean isFinished() {
        return checkResult() != DEFAULT || playCount == 9;
    }

    // Verifica resultado (vitória ou empate)
    public char checkResult() {
        char result = checkLineWin();
        if (result != DEFAULT) return result;
        return checkDiagonalWin();
    }

    // Verifica linhas e colunas
    private char checkLineWin() {
        for (int i = 0; i < 3; i++) {
            char firstHorizontalCell = table[i][0];
            char firstVerticalCell = table[0][i];

            // Linhas
            if (firstHorizontalCell != DEFAULT &&
                firstHorizontalCell == table[i][1] &&
                firstHorizontalCell == table[i][2]) {
                return firstHorizontalCell;
            }

            // Colunas
            if (firstVerticalCell != DEFAULT &&
                firstVerticalCell == table[1][i] &&
                firstVerticalCell == table[2][i]) {
                return firstVerticalCell;
            }
        }
        return DEFAULT;
    }

    // Verifica diagonais
    private char checkDiagonalWin() {
        if (table[1][1] != DEFAULT) {
            // Diagonal principal
            if (table[0][0] == table[1][1] && table[1][1] == table[2][2])
                return table[1][1];
            // Diagonal secundária
            if (table[0][2] == table[1][1] && table[1][1] == table[2][0])
                return table[1][1];
        }
        return DEFAULT;
    }
}
