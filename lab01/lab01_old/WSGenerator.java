package lab01.lab01_old;

import java.io.*;
import java.util.*;

public class WSGenerator {

    private static int size = 0;
    private static String inputFile = null;
    private static String outputFile = null;
    private static List<String> words = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        readArgs(args);
        validateArgs();

        char[][] grid = generatePuzzle(size, words);

        if (grid == null) {
            System.err.println("Erro: não foi possível gerar o puzzle.");
            System.exit(1);
        }

        printOutput(grid, words);
    }

    // ----------------------------
    // GERAÇÃO DO PUZZLE - CORRIGIDO
    // ----------------------------
    private static char[][] generatePuzzle(int n, List<String> wordList) {
        char[][] grid = new char[n][n];
        
        // Inicializa grelha com pontos
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }

        // Ordena palavras por tamanho (maiores primeiro) para melhor colocação
        wordList.sort((a, b) -> Integer.compare(b.length(), a.length()));

        // Coloca palavras
        for (String word : wordList) {
            if (!placeWord(grid, word.toUpperCase())) {
                System.err.println("Aviso: não consegui colocar a palavra: " + word);
                return null; // Não conseguiu colocar uma palavra importante
            }
        }

        // Preenche espaços vazios com letras aleatórias
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '.') {
                    grid[i][j] = (char) ('A' + random.nextInt(26));
                }
            }
        }

        return grid;
    }

    private static boolean placeWord(char[][] grid, String word) {
        int n = grid.length;
        int maxTries = 10000; // Aumenta tentativas

        // Tenta todas as direções possíveis
        int[] dirRow = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dirCol = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int attempt = 0; attempt < maxTries; attempt++) {
            int row = random.nextInt(n);
            int col = random.nextInt(n);
            int d = random.nextInt(8);

            int dr = dirRow[d];
            int dc = dirCol[d];

            // Verificar se cabe
            int endRow = row + dr * (word.length() - 1);
            int endCol = col + dc * (word.length() - 1);

            if (endRow < 0 || endRow >= n || endCol < 0 || endCol >= n) {
                continue; // não cabe
            }

            // Verificar conflitos
            boolean ok = true;
            int r = row, c = col;
            for (int k = 0; k < word.length(); k++) {
                if (grid[r][c] != '.' && grid[r][c] != word.charAt(k)) {
                    ok = false;
                    break;
                }
                r += dr;
                c += dc;
            }
            if (!ok) continue;

            // Colocar palavra
            r = row;
            c = col;
            for (int k = 0; k < word.length(); k++) {
                grid[r][c] = word.charAt(k);
                r += dr;
                c += dc;
            }
            return true;
        }

        return false; // não conseguiu colocar
    }

    // ----------------------------
    // ARGS E I/O
    // ----------------------------
    private static void readArgs(String[] args) {
        if (args.length < 4 || args.length > 6) {
            error();
        }

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i":
                    if (i + 1 >= args.length) error();
                    inputFile = args[++i];
                    break;
                case "-s":
                    if (i + 1 >= args.length) error();
                    size = Integer.parseInt(args[++i]);
                    break;
                case "-o":
                    if (i + 1 >= args.length) error();
                    outputFile = args[++i];
                    break;
                default:
                    error();
            }
        }

        words = readWords(inputFile);
    }

    private static List<String> readWords(String filename) {
        List<String> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("[,;\\s]+");
                    for (String p : parts) {
                        if (p.matches("[A-Za-z]+")) {
                            list.add(p.toUpperCase());
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erro a ler ficheiro: " + filename);
            System.exit(1);
        }
        return list;
    }

    private static void validateArgs() {
        if (size <= 0 || size > 40) {
            System.err.println("Erro: tamanho inválido (1–40).");
            System.exit(1);
        }
        if (words.isEmpty()) {
            System.err.println("Erro: lista de palavras vazia.");
            System.exit(1);
        }
        
        // Verifica se as palavras cabem no puzzle
        int maxWordLength = words.stream().mapToInt(String::length).max().orElse(0);
        if (maxWordLength > size) {
            System.err.println("Erro: palavra '" + 
                words.stream().filter(w -> w.length() == maxWordLength).findFirst().get() + 
                "' é muito grande para o puzzle de tamanho " + size);
            System.exit(1);
        }
    }

    // ----------------------------
    // OUTPUT - CORRIGIDO
    // ----------------------------
    private static void printOutput(char[][] grid, List<String> words) {
        try {
            PrintStream out = (outputFile == null) ? System.out : new PrintStream(outputFile);

            // Imprime o puzzle
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    out.print(grid[i][j]);
                }
                out.println();
            }

            // Imprime as palavras na última linha
            out.println(String.join(",", words));

            if (outputFile != null) out.close();

        } catch (Exception e) {
            System.err.println("Erro a escrever saída.");
        }
    }

    private static void error() {
        System.err.println("Uso: java WSGenerator -i <ficheiro> -s <tamanho> [-o <ficheiro_saida>]");
        System.exit(1);
    }
}