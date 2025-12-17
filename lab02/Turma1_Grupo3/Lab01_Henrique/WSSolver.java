import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WSSolver {   
    public static void main(String[] args)
    {
        if (args.length == 0) {
            System.out.println("O ficheiro de texto para resolver não foi fornecido nos argumentos.\nUtilização: java WSSolver <ficheiro.txt>");	
            return;
        }
        
        File soup = new File(args[0]);
        if (soup.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(soup))) {
                String line;
                WordGrid wordSearch = new WordGrid(15);
                List<String> words = new ArrayList<>();
                int row = 0;
                boolean isWordSearch = true;
                
                while ((line = reader.readLine()) != null) {
                    line = line.replaceAll("#.*", "").trim();
                    if (!line.isEmpty()) {
                        if (isWordSearch) {
                            // word search
                            if (line.length() != 15) {
                                System.err.println("[Erro]: A sopa de letras deve ter exatamente 15 colunas.");
                                return;
                            }
                            
                            for (int col = 0; col < 15; col++) {
                                if (line.charAt(col) < 'a' || line.charAt(col) > 'z') {
                                    System.err.println("[Erro]: Apenas letras minúsculas são permitidas na sopa de letras.");
                                    return;
                                }
                                wordSearch.getGrid()[row][col] = line.charAt(col);
                            }
                            
                            row++;
                            if (row == 15) {
                                isWordSearch = false;
                            }
                        } else {
                            // words
                            String[] splitWords = line.split(",|;| ");
                            for (String word : splitWords) {
                                if (!word.isEmpty()) {
                                    if (!Character.isUpperCase(word.charAt(0))) {
                                        System.err.println("[Erro]: A palavra '" + word + "' a resolver não começa com letra maiúscula.");
                                        return;
                                    } else if (word.length() < 3) {
                                        System.err.println("[Erro]: A palavra '" + word + "' a resolver tem menos de 3 caracteres.");
                                        return;
                                    } else if (!word.chars().allMatch(Character::isLetter)) {
                                        System.err.println("[Erro]: A palavra '" + word + "' a resolver contém caracteres não alfabéticos.");
                                        return;
                                    } else if (words.contains(word)) {
                                        System.err.println("[Erro]: A palavra '" + word + "' a resolver está repetida na lista.");
                                        return;
                                    }
                                    words.add(word.toLowerCase().trim());
                                }
                            }
                        }
                    } else {
                        System.err.println("[Erro]: O ficheiro não pode conter linhas vazias.");
                        return;
                    }
                }
                solve(wordSearch, words);
            } catch (IOException e) {
                System.err.println("[Erro]: " + e.getMessage());
            }
        } else {
            System.out.println("[Erro]: Ficheiro não encontrado: " + args[0]);
        }
    }

    public static void solve(WordGrid wordSearch, List<String> words) {
        // if any word contains a shorter word the shorter one is taken out back
        List<String> processed = new ArrayList<>(words);
        for (int i = 0; i < processed.size(); i++) {
            for (int j = 0; j < processed.size(); j++) {
                if (i != j && processed.get(i).contains(processed.get(j))) {
                    processed.remove(j);
                    j--;
                    if (j < i) i--;
                }
            }
        }

        // grid to plot solution
        char[][] solvedWS = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                solvedWS[i][j] = '_';
            }
        }

        List<String> foundWords = new ArrayList<>();
        Map<String, String> matches = new HashMap<>();
        Map<String, WordLocation> foundLocations = new HashMap<>();
        
        // check each word search letter as a potential starting point
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                // each direction
                for (Direction dir : Direction.values()) {
                    for (String word : processed) {
                        boolean found = true;
                        // check if word matches in this direction
                        for (int charIndex = 0; charIndex < word.length(); charIndex++) {
                            int newRow = row + dir.getDx() * charIndex;
                            int newCol = col + dir.getDy() * charIndex;
                            
                            // boundaries / mismatch
                            if (newRow < 0 || newRow >= 15 || 
                                newCol < 0 || newCol >= 15 ||
                                word.charAt(charIndex) != wordSearch.getGrid()[newRow][newCol]) {
                                found = false;
                                break;
                            }
                        }
                        
                        if (found) {
                            // mark found word in the solution grid
                            for (int charIndex = 0; charIndex < word.length(); charIndex++) {
                                int newRow = row + dir.getDx() * charIndex;
                                int newCol = col + dir.getDy() * charIndex;
                                solvedWS[newRow][newCol] = Character.toUpperCase(wordSearch.getGrid()[newRow][newCol]);
                            }

                            WordLocation location = new WordLocation(word, row, col, dir);
                            matches.put(word, String.format("%-15s %5d %5d,%-5d %-10s%n", 
                                    word, word.length(), (row+1), (col+1), dir.getName()));

                            if (foundWords.contains(word)) {
                                // check if it's a palindrome in the same position but different direction
                                WordLocation prevLocation = foundLocations.get(word);
                                boolean sameWordDifferentDirection = isPalindrome(location, prevLocation);
                                
                                if (!sameWordDifferentDirection) {
                                    System.err.println("[Erro]: A palavra '" + word + "' a resolver está repetida na lista.");
                                    return;
                                }
                            } else {
                                foundWords.add(word);
                                foundLocations.put(word, location);
                            }
                        }
                    }
                }
            }
        }
        
        if (foundWords.size() != processed.size()) {
            System.err.println("[Erro]: As palavras não foram todas encontradas.");
            return;
        }

        // print matches in original order
        for (String w : words) {
            System.out.print(matches.get(w));
        }
        System.out.println();
        for (char[] r : solvedWS) {
            System.out.println(new String(r));
        }
    }
    
    private static boolean isPalindrome(WordLocation loc1, WordLocation loc2) {
        return loc1.getStartRow() == loc2.getEndRow() && 
               loc1.getStartCol() == loc2.getEndCol() && 
               loc1.getEndRow() == loc2.getStartRow() && 
               loc1.getEndCol() == loc2.getStartCol();
    }
}