package lab01.lab01_new;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;


public class WSSolver {

    public static void main(String[] args) {
        // Verifica se foi passado ficheiro como argumento
        if (args.length == 0) {
            System.err.println("Uso: java WSSolver <puzzle.txt>");
            return;
        }

        try {
            // Lê puzzle e lista de palavras
            PuzzleInput input = PuzzleInput.fromFile(Paths.get(args[0]));

            // Procura as palavras no puzzle
            WordFinder finder = new WordFinder(input.getPuzzle());
            Map<String, WordInfo> solvedWords = finder.solve(input.getWords());

            // Imprime a solução num ficheiro
            SolutionPrinter printer = new SolutionPrinter(input.getInputFile());
            printer.print(finder.getSolvedPuzzle(), solvedWords);

        } catch (IOException e) {
            // Mostra erro caso exista problema com ficheiro
            System.err.println("Erro ao processar ficheiro: " + e.getMessage());
        }
    }
}

// Classe que representa a entrada do puzzle (grelha + palavras)
class PuzzleInput {
    private final Path inputFile;
    private final char[][] puzzle;
    private final List<String> words;

    private PuzzleInput(Path inputFile, char[][] puzzle, List<String> words) {
        this.inputFile = inputFile;
        this.puzzle = puzzle;
        this.words = words;
    }

    // Cria PuzzleInput a partir de ficheiro
    public static PuzzleInput fromFile(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        int size = lines.get(0).length(); // tamanho da grelha

        List<String> puzzleLines = new ArrayList<>();
        List<String> wordLines = new ArrayList<>();

        // Separa linhas da grelha e linhas de palavras
        for (String line : lines) {
            if (line.length() == size && line.matches("[A-Z]+")) puzzleLines.add(line);
            else if (!line.isBlank()) wordLines.add(line);
        }

        // Constrói a grelha
        char[][] puzzle = new char[size][size];
        for (int i = 0; i < size; i++) puzzle[i] = puzzleLines.get(i).toCharArray();

        // Junta todas as palavras numa lista
        String allWords = String.join(" ", wordLines);
        List<String> words = Arrays.stream(allWords.split("[,;\\s]+"))
                                   .filter(w -> !w.isBlank())
                                   .map(String::toUpperCase)
                                   .toList();

        return new PuzzleInput(path, puzzle, words);
    }

    public Path getInputFile() { return inputFile; }
    public char[][] getPuzzle() { return puzzle; }
    public List<String> getWords() { return words; }
}

// Enum das 8 direções possíveis
enum SolverDirection {
    N(-1, 0), NE(-1, 1), E(0, 1), SE(1, 1),
    S(1, 0), SW(1, -1), W(0, -1), NW(-1, -1);

    final int dr, dc;
    SolverDirection(int dr, int dc) { this.dr = dr; this.dc = dc; }
}

// Estrutura que guarda informação de uma palavra encontrada
record WordInfo(String word, int length, int row, int col, int order, SolverDirection direction) {}

// Classe responsável por procurar palavras no puzzle
class WordFinder {
    private final char[][] puzzle;
    private final char[][] solvedPuzzle;
    private int orderCounter = 0;

    public WordFinder(char[][] puzzle) {
        this.puzzle = puzzle;
        this.solvedPuzzle = new char[puzzle.length][puzzle.length];
        // Inicializa grelha de solução com pontos
        for (char[] row : solvedPuzzle) Arrays.fill(row, '.');
    }

    // Procura todas as palavras na grelha
    public Map<String, WordInfo> solve(List<String> words) {
        Map<String, WordInfo> solved = new HashMap<>();
        for (String word : words) {
            findWord(word).ifPresentOrElse(
                wi -> solved.put(word, wi), // palavra encontrada
                () -> System.err.println("Aviso: palavra não encontrada - " + word) // aviso caso não encontre
            );
        }
        return solved;
    }

    public char[][] getSolvedPuzzle() { return solvedPuzzle; }

    // Tenta encontrar uma palavra no puzzle
    private Optional<WordInfo> findWord(String word) {
        int size = puzzle.length;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                for (SolverDirection dir : SolverDirection.values()) {
                    if (checkWord(word, r, c, dir)) {
                        markWord(word, r, c, dir); // marca palavra na grelha de solução
                        return Optional.of(new WordInfo(word, word.length(), r, c, orderCounter++, dir));
                    }
                }
            }
        }
        return Optional.empty(); // palavra não encontrada
    }

    // Verifica se a palavra existe a partir da posição (r,c) numa direção
    private boolean checkWord(String word, int row, int col, SolverDirection dir) {
        int size = puzzle.length;
        for (int k = 0; k < word.length(); k++) {
            int nr = row + k * dir.dr;
            int nc = col + k * dir.dc;
            if (nr < 0 || nr >= size || nc < 0 || nc >= size) return false;
            if (puzzle[nr][nc] != word.charAt(k)) return false;
        }
        return true;
    }

    // Marca a palavra na grelha de solução
    private void markWord(String word, int row, int col, SolverDirection dir) {
        for (int k = 0; k < word.length(); k++) {
            int nr = row + k * dir.dr;
            int nc = col + k * dir.dc;
            solvedPuzzle[nr][nc] = word.charAt(k);
        }
    }
}

// Classe responsável por imprimir a solução da sopa de letras
class SolutionPrinter {
    private final Path inputFile;

    public SolutionPrinter(Path inputFile) { this.inputFile = inputFile; }

    // Escreve grelha e lista de palavras encontradas num ficheiro
    public void print(char[][] solvedPuzzle, Map<String, WordInfo> solvedWords) throws IOException {
        // Gera nome de ficheiro de saída
        String baseName = inputFile.getFileName().toString().replaceFirst("[.][^.]+$", "");
        String outputFileName = "out" + baseName.substring(Math.max(0, baseName.length() - 2)) + ".txt";
        Path outputFile = Paths.get(outputFileName);

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(outputFile))) {
            // Escreve grelha da solução
            for (char[] row : solvedPuzzle) writer.println(new String(row));

            // Escreve lista de palavras com metadados
            if (!solvedWords.isEmpty()) {
                writer.println();
                List<WordInfo> sorted = solvedWords.values().stream()
                        .sorted(Comparator.comparingInt(WordInfo::order))
                        .collect(Collectors.toList());

                for (WordInfo wi : sorted) {
                    writer.printf("%-15s %-2d %2d,%-2d %s%n",
                            wi.word().toLowerCase(),
                            wi.length(),
                            wi.row() + 1,
                            wi.col() + 1,
                            wi.direction().name());
                }
            }
        }

        // Mostra no console nome do ficheiro gerado
        System.out.println("Sopa resolvida salva em: " + outputFileName);
    }
}
