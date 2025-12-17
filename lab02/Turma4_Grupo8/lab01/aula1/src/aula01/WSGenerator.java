package Práticas.lab02.Turma4_Grupo8.lab01.aula1.src.aula01;

import java.io.*;
import java.nio.file.*;
import java.text.Normalizer;
import java.util.*;

public class WSGenerator {
    private static final int GRID_SIZE = 15;
    private char[][] grid;
    private List<String> words;
    private Random random;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    
    public WSGenerator(String wordFile, String outputFile) throws IOException {
        grid = new char[GRID_SIZE][GRID_SIZE];
        random = new Random();
        words = new ArrayList<>();
        loadWords(wordFile);
        initializeGrid();
        placeWords();
        fillEmptySpaces();
        if (outputFile == null) {
            for (int i = 0; i < GRID_SIZE; i++) {
                System.out.println(new String(grid[i]));
            }
            for (String word : words) {
                word = word.substring(0, 1).toUpperCase() + word.substring(1);
                System.out.println(word);
            }
        } else{
            saveToFile(outputFile);
        }
    }
    
    // Le as palavras do ficheiro fornecido verifica se a palavra é valida, se for adiciona a lista
    private void loadWords(String wordFile) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(wordFile));
        for (String line : lines) {
            line = line.trim();
            if (!line.isEmpty()) {
                
                // Verifica se começa com maiúscula
                if (!Character.isUpperCase(line.charAt(0))) {
                    throw new IllegalArgumentException("Palavra inválida (não começa com maiúscula): " + line);
                }
                
                // Verifica se contém números
                if (line.matches(".*\\d.*")) {
                    throw new IllegalArgumentException("Palavra inválida (contém números): " + line);
                }
                
                // Retira acentos e adiciona à lista
                String normalized = Normalizer.normalize(line, Normalizer.Form.NFD)
                        .replaceAll("[^\\p{ASCII}]", "")
                        .toLowerCase();
                
                if (normalized.length() < 3 || normalized.length() > 15) {
                    throw new IllegalArgumentException("Palavra inválida (tamanho fora do limite): " + line);
                }
                words.add(normalized);
            }
        }
    }

    // Cria uma grade com todos os espaços ocupados com "_" 
    private void initializeGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            Arrays.fill(grid[i], '_');
        }
    }
    
    //tendo em conta a posição da primeira letre e da ultima letra, verifica se a palavra cabe no grid
    private boolean canPlaceWord(String word, int row, int col, int dRow, int dCol) {
        int len = word.length();
        int endRow = row + dRow * (len - 1);
        int endCol = col + dCol * (len - 1);
        
        if (endRow < 0 || endRow >= GRID_SIZE || endCol < 0 || endCol >= GRID_SIZE) {
            return false;
        }
        
        for (int i = 0; i < len; i++) {
            int r = row + i * dRow;
            int c = col + i * dCol;
            if (grid[r][c] != '_' && grid[r][c] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    // Percorre todas as posições do grid, para todas as direções guarda a posição da ultima letra da palavra
    // chama a função canPlace para verificar se é valido
    // se for valida guarda, dps escolhe aleatoria qual a posição inicial e coloca a palavra no grid
    private void placeWord(String word) {
        int[] directions = {-1, 0, 1};
        List<int[]> validPositions = new ArrayList<>();
        
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                for (int dRow : directions) {
                    for (int dCol : directions) {
                        if (dRow == 0 && dCol == 0) continue;
                        if (canPlaceWord(word, row, col, dRow, dCol)) {
                            validPositions.add(new int[]{row, col, dRow, dCol});
                        }
                    }
                }
            }
        }
        
        if (validPositions.isEmpty()) {
            throw new IllegalArgumentException("Não foi possível colocar a palavra: " + word);
        }
        
        int[] chosen = validPositions.get(random.nextInt(validPositions.size()));
        int row = chosen[0], col = chosen[1], dRow = chosen[2], dCol = chosen[3];
        for (int i = 0; i < word.length(); i++) {
            grid[row + i * dRow][col + i * dCol] = word.charAt(i);
        }
    }
    
    private void placeWords() {
        for (String word : words) {
            placeWord(word);
        }
    }
    
    //random preenchimento de letras para os espaços vazios
    private void fillEmptySpaces() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == '_') {
                    grid[i][j] = ALPHABET.charAt(random.nextInt(ALPHABET.length()));
                }
            }
        }
    }
    
    //Guarda a sopa de letras num ficheiro fornecido
    private void saveToFile(String outputFile) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        for (int i = 0; i < GRID_SIZE; i++) {
            writer.println(new String(grid[i]));
        }
        for (String word : words) {
            word = word.substring(0, 1).toUpperCase() + word.substring(1);
            writer.println(word);
        }
        writer.close();
    }
    
    public static void main(String[] args) {
        // se comando java WSGenerator -w <wordFile> o resultado é imprimido no terminal
        // se o comando for java WSGenerator -w <wordFile> -s <outputFile> o resultado é guardado num ficheiro
        if (args.length < 2 || args.length > 4) {
            System.out.println("Utilização: java WSGenerator -w <wordFile> [-s <outputFile>]");
            return;
        }
    
        String wordFile = null;
        String outputFile = null;
    
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-w") && i + 1 < args.length) {
                wordFile = args[i + 1];
                i++;
            } else if (args[i].equals("-s") && i + 1 < args.length) {
                outputFile = args[i + 1];
                i++;
            }
        }
    
        if (wordFile == null) {
            System.out.println("Utilização: java WSGenerator -w <wordFile> [-s <outputFile>]");
            return;
        }
    
        try {
            new WSGenerator(wordFile, outputFile);
            System.out.println("Sopa de letras gerada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao processar arquivos: " + e.getMessage());
        }
    }
}
