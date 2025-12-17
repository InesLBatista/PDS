import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WSGenerator {   
    private static final Random random = new Random();
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("O ficheiro de palavras não foi fornecido nos argumentos.\n" +
            "Utilização: java WSGenerator -w <input.txt> (opcional: -s <output.txt>)");
            return;
        }
        
        Map<String, String> argMap = new HashMap<>();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            if (arg.startsWith("-")) {
                if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                    argMap.put(arg, args[i + 1]);
                    i++;
                } else {
                    argMap.put(arg, null);
                }
            }

            if (argMap.get("-w") == null) {
                System.err.println("[Erro]: O argumento -w é obrigatório e deve ser seguido por um nome de ficheiro.");
                return;
            }
        }

        File wordsFile = new File(argMap.get("-w"));
        if (wordsFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(wordsFile))) {
                ArrayList<String> words = new ArrayList<>();
                String line;
                
                while ((line = reader.readLine()) != null) {
                    line = line.replaceAll("#.*", "").trim();
                    
                    if (!line.isEmpty()) {
                        String[] splitWords = line.split(",|;| ");
                        for (String word : splitWords) {
                            word = word.trim();
                            if (!word.isEmpty()) {
                                if (word.length() < 3) {
                                    System.err.println("[Erro]: A palavra '" + word + "' tem menos de 3 caracteres.");
                                    return;
                                } else if (!word.chars().allMatch(Character::isLetter)) {
                                    System.err.println("[Erro]: A palavra '" + word + "' contém caracteres não alfabéticos.");
                                    return;
                                } else if (words.contains(word.toLowerCase())) {
                                    System.err.println("[Erro]: A palavra '" + word + "' está repetida na lista.");
                                    return;
                                } else if (word.length() > 15) {
                                    System.err.println("[Erro]: A palavra '" + word + "' é maior que o tamanho da sopa (15x15).");
                                    return;
                                }
                                words.add(word.toLowerCase());
                            }
                        }
                    }
                }
                
                if (words.isEmpty()) {
                    System.err.println("[Erro]: Nenhuma palavra válida encontrada na lista de palavras.");
                    return;
                }
                
                // generate the word search
                WordGrid wordGrid = generateWordSearch(words);
                
                // display word search and optionally save to file
                displayWS(wordGrid.getGrid(), words, argMap.get("-s"));
                
            } catch (IOException e) {
                System.err.println("[Erro]: " + e.getMessage());
            }
        } else {
            System.err.println("[Erro]: Ficheiro não encontrado: " + argMap.get("-w"));
        }
    }

    public static WordGrid generateWordSearch(ArrayList<String> words) {
        WordGrid wordGrid = new WordGrid(15);
        List<WordLocation> placedWords = new ArrayList<>();
        
        // 1. longest words first
        words.sort(Comparator.comparing(String::length).reversed());
        
        // 2. try to place words in a random assortment
        for (String word : words) {
            boolean placed = false;
            int attempts = 0;
            
            while (!placed && attempts < 100) {
                Direction dir = Direction.values()[random.nextInt(Direction.values().length)];
                int row = random.nextInt(15);
                int col = random.nextInt(15);
                
                if (canPlaceWord(wordGrid.getGrid(), word, row, col, dir)) {
                    placeWord(wordGrid.getGrid(), word, row, col, dir);
                    placedWords.add(new WordLocation(word, row, col, dir));
                    placed = true;
                }
                
                attempts++;
            }
            
            if (!placed) {
                System.out.println("[Erro]: Não foi possível colocar a palavra: " + word);
            }
        }
        
        // 3. fill remaining empty spaces with random letters
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (wordGrid.getGrid()[i][j] == '_') {
                    wordGrid.getGrid()[i][j] = (char) ('a' + random.nextInt(26));
                }
            }
        }
        
        return wordGrid;
    }
    
    private static boolean canPlaceWord(char[][] grid, String word, int row, int col, Direction dir) {
        for (int i = 0; i < word.length(); i++) {
            int newRow = row + dir.getDx() * i;
            int newCol = col + dir.getDy() * i;
            
            if (newRow < 0 || newRow >= 15 || newCol < 0 || newCol >= 15) {
                return false;
            }
            
            if (grid[newRow][newCol] != '_' && grid[newRow][newCol] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    private static void placeWord(char[][] grid, String word, int row, int col, Direction dir) {
        for (int i = 0; i < word.length(); i++) {
            int newRow = row + dir.getDx() * i;
            int newCol = col + dir.getDy() * i;
            grid[newRow][newCol] = word.charAt(i);
        }
    }

    public static void displayWS(char[][] wordSoup, ArrayList<String> words, String filename) {
        // print to console
        for (char[] row : wordSoup) {
            System.out.println(new String(row));
        }
        for (String word : words) {
            System.out.println(Character.toUpperCase(word.charAt(0)) + word.substring(1));
        }
        
        // optionally save to file
        if (filename != null) {
            File file = new File(filename);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                for (char[] row : wordSoup) {
                    writer.println(new String(row));
                }
                for (String word : words) {
                    writer.println(Character.toUpperCase(word.charAt(0)) + word.substring(1));
                }
            } catch (IOException e) {
                System.err.println("[Erro]: Falha ao salvar a sopa de letras: " + e.getMessage());
            }
        }
    }
}