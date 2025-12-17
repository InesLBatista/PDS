package Praticas.lab07.ex3;

import java.util.ArrayList;
import java.util.List;

public class PrinterTest {

    private static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Document> docs = new ArrayList<>();
        docs.add(new Document("This is a great text about software design patterns."));
        docs.add(new Document("Natural language generation is an amazing technology."));
        docs.add(new Document("You wish to know how to adapt systems seamlessly."));

        AdvancedPrinterInterface advPrinter = new AdvancedPrinter();

        // Teste 1: Imprimir 1 documento
        advPrinter.print(docs.get(0));
        pause(1500); // Esperar terminar
        
        // Teste 2: Imprimir 3 documentos
        advPrinter.print(docs);
        pause(500); // Pequena pausa para alguns jobs entrarem na fila
        advPrinter.showQueuedJobs(); // Deve mostrar jobs 2 e 3 na fila
        pause(4000); // Esperar todos terminarem
        
        // Teste 3: Nova impressão e cancelamento
        List<Integer> jobIds = advPrinter.print(docs);
        pause(500); // Pequena pausa
        advPrinter.cancelJob(6); // Cancelar job 6 (terceiro documento)
        pause(500);
        advPrinter.showQueuedJobs(); // Deve mostrar job 5 na fila
        pause(3000); // Esperar jobs restantes
        
        // Teste 4: Última impressão e shutdown
        advPrinter.print(docs);
        pause(500);
        advPrinter.cancelAll();
        advPrinter.showQueuedJobs();

        // Shutdown
        if (advPrinter instanceof AdvancedPrinter) {
            ((AdvancedPrinter) advPrinter).shutdown();
        }
        
        pause(1000);
        System.out.println("Test completed.");
    }
}