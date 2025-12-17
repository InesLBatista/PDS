package lab01.lab01_new;

import java.io.*;
import java.util.*;

public class WSGenerator {

    public static void main(String[] args) {
        try {
            // Lê e valida argumentos da linha de comando
            ArgumentParser parser = new ArgumentParser(args);

            // Lê lista de palavras do ficheiro
            List<String> words = WordReader.readFromFile(parser.getInputFile());

            // Valida tamanho da grelha e palavras
            parser.validate(words);

            // Gera a sopa de letras
            PuzzleGenerator generator = new PuzzleGenerator(parser.getSize(), words);
            char[][] grid = generator.generate();

            // Imprime grelha e lista de palavras
            PuzzlePrinter printer = new PuzzlePrinter(parser.getOutputFile());
            printer.print(grid, words);

        } catch (IllegalArgumentException | IOException e) {
            // Mostra erro e termina
            System.err.println("Erro: " + e.getMessage());
            System.exit(1);
        }
    }
}

// Classe responsável por tratar argumentos da linha de comando
class ArgumentParser {
    private final String inputFile;
    private final String outputFile;
    private final int size;

    public ArgumentParser(String[] args) {
        if (args.length < 4 || args.length > 6) {
            throw new IllegalArgumentException("Uso: java WSGenerator -i <ficheiro> -s <tamanho> [-o <ficheiro_saida>]");
        }

        String in = null, out = null;
        int s = -1;

        // Processa argumentos sequencialmente
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i" -> in = args[++i]; // ficheiro de entrada
                case "-s" -> s = Integer.parseInt(args[++i]); // tamanho da grelha
                case "-o" -> out = args[++i]; // ficheiro de saída opcional
                default -> throw new IllegalArgumentException("Argumento inválido: " + args[i]);
            }
        }

        this.inputFile = Objects.requireNonNull(in, "Ficheiro de entrada é obrigatório");
        this.outputFile = out;
        this.size = s;
    }

    public String getInputFile() { return inputFile; }
    public String getOutputFile() { return outputFile; }
    public int getSize() { return size; }

    // Valida tamanho da grelha e palavras
    public void validate(List<String> words) {
        if (size <= 0 || size > 40) throw new IllegalArgumentException("Tamanho inválido (1–40).");
        if (words.isEmpty()) throw new IllegalArgumentException("Lista de palavras vazia.");
        int maxLen = words.stream().mapToInt(String::length).max().orElse(0);
        if (maxLen > size) throw new IllegalArgumentException("A palavra '" +
            words.stream().filter(w -> w.length() == maxLen).findFirst().orElse("") +
            "' não cabe na grelha " + size + "x" + size);
    }
}

// Classe utilitária para ler palavras de um ficheiro
class WordReader {
    public static List<String> readFromFile(String filename) throws IOException {
        List<String> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("[,;\\s]+"); // separadores
                    for (String p : parts) {
                        if (p.matches("[A-Za-z]+")) list.add(p.toUpperCase()); // maiúsculas
                    }
                }
            }
        }
        return list;
    }
}

// Enum das 8 direções possíveis
enum Direction {
    N(-1, 0), NE(-1, 1), E(0, 1), SE(1, 1),
    S(1, 0), SW(1, -1), W(0, -1), NW(-1, -1);

    final int dr, dc;
    Direction(int dr, int dc) { this.dr = dr; this.dc = dc; }
}

// Classe que gera a sopa de letras
class PuzzleGenerator {
    private final int size;
    private final List<String> words;
    private final Random random = new Random();

    public PuzzleGenerator(int size, List<String> words) {
        this.size = size;
        this.words = new ArrayList<>(words);
        this.words.sort(Comparator.comparingInt(String::length).reversed()); // maior primeiro
    }

    // Gera a grelha final
    public char[][] generate() {
        char[][] grid = new char[size][size];
        for (char[] row : grid) Arrays.fill(row, '.'); // inicializa pontos

        // Coloca cada palavra
        for (String word : words) {
            if (!tryPlaceWord(grid, word)) throw new IllegalArgumentException("Não consegui colocar a palavra: " + word);
        }

        fillEmpty(grid); // preenche restantes com letras aleatórias
        return grid;
    }

    // Tenta colocar palavra em posições aleatórias
    private boolean tryPlaceWord(char[][] grid, String word) {
        int maxTries = 10000;
        for (int attempt = 0; attempt < maxTries; attempt++) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            Direction dir = Direction.values()[random.nextInt(Direction.values().length)];

            if (fits(grid, word, row, col, dir)) {
                place(grid, word, row, col, dir);
                return true;
            }
        }
        return false;
    }

    // Verifica se palavra cabe na posição/direção
    private boolean fits(char[][] grid, String word, int row, int col, Direction dir) {
        int endRow = row + dir.dr * (word.length() - 1);
        int endCol = col + dir.dc * (word.length() - 1);
        if (endRow < 0 || endRow >= size || endCol < 0 || endCol >= size) return false;

        int r = row, c = col;
        for (char ch : word.toCharArray()) {
            if (grid[r][c] != '.' && grid[r][c] != ch) return false;
            r += dir.dr;
            c += dir.dc;
        }
        return true;
    }

    // Coloca palavra na grelha
    private void place(char[][] grid, String word, int row, int col, Direction dir) {
        for (char ch : word.toCharArray()) {
            grid[row][col] = ch;
            row += dir.dr;
            col += dir.dc;
        }
    }

    // Preenche células vazias com letras aleatórias
    private void fillEmpty(char[][] grid) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (grid[i][j] == '.') grid[i][j] = (char) ('A' + random.nextInt(26));
    }
}

// Classe responsável por imprimir a grelha
class PuzzlePrinter {
    private final String outputFile;

    public PuzzlePrinter(String outputFile) { this.outputFile = outputFile; }

    public void print(char[][] grid, List<String> words) throws IOException {
        try (PrintStream out = (outputFile == null) ? System.out : new PrintStream(outputFile)) {
            for (char[] row : grid) out.println(new String(row)); // imprime grelha
            out.println(String.join(",", words)); // imprime lista de palavras
        }
    }
}

