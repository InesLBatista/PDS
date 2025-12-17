package Práticas.lab02.Turma4_Grupo8.lab01.aula1.src.aula01;
import java.io.IOException; 


public class WSSolver {
    public static void main(String [] args){
        if(args.length!=1){
            System.out.println("Usage: java WSSolver testing1.txt");
            System.exit(1);
        }

        String WordSoupFileName = args[0];  
        String WordSoupResultFileName = args[0].replace(".txt", "_result.txt");

        try{
            new WSSolverProcessing(WordSoupFileName, WordSoupResultFileName);
        } catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
