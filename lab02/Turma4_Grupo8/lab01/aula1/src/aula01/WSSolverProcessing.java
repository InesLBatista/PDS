package Práticas.lab02.Turma4_Grupo8.lab01.aula1.src.aula01;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WSSolverProcessing {
    private static final int MAX_size = 15;
    
    //linhas válidas lidas do ficheiro (ignorar comentários)
    private List<String> fileLines;
    
    //15 primeiras linhas (depois de retirar comentários) constituem o puzzle
    private List<String> puzzleLines;
    
    //lista de palavras que tem de procurar (das ultimas linhas)
    private List<String> wordsList;
    
    //puzzle convertido para array de caracteres
    private char[][] grid;
    
    // Mapa (em ordem de inserção) que guarda, para cada palavra (conforme a lista final), 
    // a informação: palavra (em maiúsculas), linha (1-indexada), coluna (1-indexada) e direcção.
    private LinkedHashMap<String, FoundWord> foundWordsMap;

    private static class FoundWord {
        String word;     
        int row;          
        int col;          
        String direction; 

        public FoundWord(String word, int row, int col, String direction) {
            this.word = word;
            this.row = row;
            this.col = col;
            this.direction = direction;
        }
    }
    
    public WSSolverProcessing(String inputFileName, String outputFileName) throws IOException {
        readFile(inputFileName);
        
        //check se existem pelo menos 15 linhas para o puzzle + 1 para a lista de palavras a encontrar
        if (fileLines.size() < MAX_size + 1) {
            throw new IllegalArgumentException("Ficheiro com linhas insuficientes: são necessárias 15 linhas para o puzzle e, pelo menos, 1 para a lista de palavras.");
        }
        
        //15 primeiras linhas constituem o puzzle
        puzzleLines = fileLines.subList(0, MAX_size);
        
        validatePuzzle();
        buildGrid();
        processWordsList();
        validateWords();
        filterContainedWords();
        foundWordsMap = new LinkedHashMap<>();
        searchAllWords();

        outputResults(outputFileName);
    }
    
    private void readFile(String inputFileName) throws IOException {
        fileLines = new ArrayList<>();
        List<String> allLines = Files.readAllLines(Paths.get(inputFileName));
        int lineNumber = 0;
        for (String line : allLines) {
            lineNumber++;
            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                throw new IllegalArgumentException("Linha vazia encontrada no ficheiro (linha " + lineNumber + ").");
            }
            
            int commentIndex = trimmed.indexOf("#"); //dividir a linha em comentário e letras
            if (commentIndex != -1) {
                trimmed = trimmed.substring(0, commentIndex).trim();
            }
            if (!trimmed.isEmpty()) {  
                fileLines.add(trimmed);
            }
        }
    }
    
    private void validatePuzzle() {
        for (int i = 0; i < MAX_size; i++) {
            String line = puzzleLines.get(i);
            if (line.length() != MAX_size) {
                throw new IllegalArgumentException("A linha " + (i + 1) + " do puzzle não tem exatamente " + MAX_size + " caracteres.");
            }
            for (int j = 0; j < MAX_size; j++) {
                char c = line.charAt(j);
                if (!Character.isLowerCase(c)) {
                    throw new IllegalArgumentException("O carácter na posição (" + (i + 1) + "," + (j + 1) + ") não é minúsculo.");
                }
            }
        }
    }
    
    private void buildGrid() {
        grid = new char[MAX_size][MAX_size];
        for (int i = 0; i < MAX_size; i++) {
            String line = puzzleLines.get(i);
            for (int j = 0; j < MAX_size; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
    }
    
    //processa as linhas finais para obter a lista de palavras a procurar
    private void processWordsList() {
        wordsList = new ArrayList<>();
        for (int i = MAX_size; i < fileLines.size(); i++) {
            String line = fileLines.get(i);
            // Separa por vírgula, ponto-e-vírgula ou espaços (um ou mais)
            String[] tokens = line.split("[,;\\s]+");
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    wordsList.add(token);
                }
            }
        }
        if (wordsList.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma palavra encontrada na lista de palavras.");
        }
    }
    
    private void validateWords() {
        for (String word : wordsList) {
            if (word.length() < 3) {
                throw new IllegalArgumentException("A palavra \"" + word + "\" tem menos de 3 caracteres.");
            }
            if (!Character.isUpperCase(word.charAt(0))) {
                throw new IllegalArgumentException("A palavra \"" + word + "\" não começa com letra maiúscula.");
            }
            for (int i = 0; i < word.length(); i++) {
                if (!Character.isLetter(word.charAt(i))) {
                    throw new IllegalArgumentException("A palavra \"" + word + "\" contém carácter não alfabético.");
                }
            }
        }
    }
    
    //no caso de existir palavras contidas noutras, remover as menores
    private void filterContainedWords() {
        LinkedHashSet<String> filtered = new LinkedHashSet<>(wordsList);
        List<String> temp = new ArrayList<>(filtered);
        for (String wordA : temp) {
            for (String wordB : temp) {
                if (!wordA.equals(wordB) && wordB.length() > wordA.length() && wordB.contains(wordA)) {
                    filtered.remove(wordA);
                    break;
                }
            }
        }
        wordsList = new ArrayList<>(filtered);
    }
    
    private void searchAllWords() {
        // Vetores para as 8 direções: (dRow[i], dCol[i])
        int[] dRow = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dCol = { -1,  0,  1, -1, 1, -1, 0, 1 };
        String[] directionNames = { "UpLeft", "Up", "UpRight", "Left", "Right", "DownLeft", "Down", "DownRight" };
    
        for (String word : wordsList) {
            String lowerWord = word.toLowerCase();
            boolean found = false; // Indica se já encontramos a palavra
    
            for (int i = 0; i < MAX_size && !found; i++) {
                for (int j = 0; j < MAX_size && !found; j++) {
                    if (grid[i][j] != lowerWord.charAt(0)) {
                        continue;
                    }
                    for (int d = 0; d < 8 && !found; d++) {
                        int k;
                        for (k = 0; k < lowerWord.length(); k++) {
                            int newRow = i + k * dRow[d];
                            int newCol = j + k * dCol[d];
                            if (newRow < 0 || newRow >= MAX_size || newCol < 0 || newCol >= MAX_size) {
                                break;
                            }
                            if (grid[newRow][newCol] != lowerWord.charAt(k)) {
                                break;
                            }
                        }
                        if (k == lowerWord.length()) { // Palavra encontrada nesta direção
                            found = true;
                            foundWordsMap.put(word, new FoundWord(word.toUpperCase(), i + 1, j + 1, directionNames[d]));
                        }
                    }
                }
            }
    
            if (!found) {
                throw new IllegalArgumentException("A palavra \"" + word + "\" não foi encontrada no puzzle.");
            }
        }
    }
    
    
    private void outputResults(String outputFileName) throws IOException {
        char[][] outputGrid = new char[MAX_size][MAX_size];
        for (int i = 0; i < MAX_size; i++) {
            Arrays.fill(outputGrid[i], '_');
        }
        
        int[] dRow = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dCol = { -1,  0,  1, -1, 1, -1, 0, 1 };
        String[] directionNames = { "UpLeft", "Up", "UpRight", "Left", "Right", "DownLeft", "Down", "DownRight" };

        //para cada palavra encontrada, marca as posições utilizadas no grid de output
        for (FoundWord fw : foundWordsMap.values()) {
            int dIndex = -1;
            for (int d = 0; d < 8; d++) {
                if (directionNames[d].equals(fw.direction)) {
                    dIndex = d;
                    break;
                }
            }
            int startRow = fw.row - 1;
            int startCol = fw.col - 1;
            for (int k = 0; k < fw.word.length(); k++) {
                int r = startRow + k * dRow[dIndex];
                int c = startCol + k * dCol[dIndex];
                outputGrid[r][c] = fw.word.charAt(k);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (FoundWord fw : foundWordsMap.values()) {
            sb.append(String.format("%-15s %2d %3d,%3d %-10s%n", 
                    fw.word, fw.word.length(), fw.row, fw.col, fw.direction));
        }
        sb.append("\n");
        for (int i = 0; i < MAX_size; i++) {
            for (int j = 0; j < MAX_size; j++) {
                sb.append(outputGrid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        PrintWriter writer = new PrintWriter(new FileWriter(outputFileName));
        writer.print(sb.toString());
        writer.close();
        
        System.out.println(sb.toString());
    }
}
