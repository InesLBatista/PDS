package lab01.lab01_old;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class WSSolver {

    private enum Direction {
        N(-1, 0), NE(-1, 1), E(0, 1), SE(1, 1),
        S(1, 0), SW(1, -1), W(0, -1), NW(-1, -1);

        final int dr, dc;

        Direction(int dr, int dc) {
            this.dr = dr;
            this.dc = dc;
        }
    }

    private record WordInfo(String word, int length, int row, int col, int order, Direction direction) {}

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Uso: java WSSolver <puzzle.txt>");
            return;
        }

        Path inputFile = Paths.get(args[0]);
        List<String> lines = Files.readAllLines(inputFile);

        // Encontrar a linha onde começam as palavras (última linha não vazia)
        int puzzleSize = lines.get(0).length();
        List<String> puzzleLines = new ArrayList<>();
        List<String> wordLines = new ArrayList<>();
        
        for (String line : lines) {
            if (line.length() == puzzleSize && line.matches("[A-Z]+")) {
                puzzleLines.add(line);
            } else {
                wordLines.add(line);
            }
        }

        // Juntar todas as linhas de palavras
        String allWordsLine = String.join(" ", wordLines);
        String[] words = allWordsLine.split("[,;\\s]+");

        char[][] puzzle = new char[puzzleSize][puzzleSize];
        for (int i = 0; i < puzzleSize; i++) {
            puzzle[i] = puzzleLines.get(i).toCharArray();
        }

        char[][] solvedPuzzle = new char[puzzleSize][puzzleSize];
        for (int i = 0; i < puzzleSize; i++) {
            Arrays.fill(solvedPuzzle[i], '.'); // preenche tudo com pontos
        }

        Map<String, WordInfo> solvedWords = new HashMap<>();
        int order = 0;

        for (String word : words) {
            if (word.isEmpty()) continue;
            word = word.toUpperCase().trim();
            WordInfo wordInfo = findWord(puzzle, word, solvedPuzzle);
            if (wordInfo != null) {
                solvedWords.put(word, new WordInfo(word, word.length(), 
                    wordInfo.row(), wordInfo.col(), order++, wordInfo.direction()));
            } else {
                System.err.println("Aviso: palavra não encontrada - " + word);
            }
        }

        printSolvedPuzzle(solvedPuzzle, inputFile, solvedWords);
    }

    private static WordInfo findWord(char[][] puzzle, String word, char[][] solvedPuzzle) {
        int size = puzzle.length;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                for (Direction dir : Direction.values()) {
                    if (checkWord(puzzle, word, r, c, dir)) {
                        markWord(solvedPuzzle, word, r, c, dir);
                        return new WordInfo(word, word.length(), r, c, 0, dir);
                    }
                }
            }
        }
        return null;
    }

    private static boolean checkWord(char[][] puzzle, String word, int row, int col, Direction dir) {
        int size = puzzle.length;

        for (int k = 0; k < word.length(); k++) {
            int newRow = row + k * dir.dr;
            int newCol = col + k * dir.dc;
            if (newRow < 0 || newRow >= size || newCol < 0 || newCol >= size)
                return false;
            if (puzzle[newRow][newCol] != word.charAt(k))
                return false;
        }
        return true;
    }

    private static void markWord(char[][] solvedPuzzle, String word, int row, int col, Direction dir) {
        for (int k = 0; k < word.length(); k++) {
            int newRow = row + k * dir.dr;
            int newCol = col + k * dir.dc;
            solvedPuzzle[newRow][newCol] = word.charAt(k);
        }
    }

    private static void printSolvedPuzzle(char[][] solvedPuzzle, Path inputFile, Map<String, WordInfo> solvedWords) throws IOException {
        // Criar nome do ficheiro de saída
        String inputFileName = inputFile.getFileName().toString();
        String baseName = inputFileName.replaceFirst("[.][^.]+$", "");
        String outputFileName = "out" + baseName.substring(Math.max(0, baseName.length() - 2)) + ".txt";
        
        Path outputFile = Paths.get(outputFileName);
        
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(outputFile))) {
            // Escrever a sopa resolvida
            int size = solvedPuzzle.length;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    writer.print(solvedPuzzle[i][j]);
                }
                writer.println();
            }
            
            // Escrever as palavras encontradas
            if (!solvedWords.isEmpty()) {
                writer.println();
                List<WordInfo> sortedWords = solvedWords.values().stream()
                    .sorted(Comparator.comparingInt(WordInfo::order))
                    .collect(Collectors.toList());
                
                for (WordInfo wordInfo : sortedWords) {
                    writer.printf("%-15s %-2d %2d,%-2d %s%n",
                        wordInfo.word().toLowerCase(),
                        wordInfo.length(),
                        wordInfo.row() + 1,
                        wordInfo.col() + 1,
                        wordInfo.direction().name());
                }
            }
        }
        
        System.out.println("Sopa resolvida salva em: " + outputFileName);
    }
}