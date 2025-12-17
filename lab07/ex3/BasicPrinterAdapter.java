package Praticas.lab07.ex3;

import java.util.ArrayList;
import java.util.List;

public class BasicPrinterAdapter implements AdvancedPrinterInterface {

    private BasicPrinter basicPrinter;
    private static int jobCounter = 0;

    public BasicPrinterAdapter(BasicPrinter printer) {
        this.basicPrinter = printer;
    }

    @Override
    public int print(Document doc) {
        System.out.println("Spooling 1 document.");
        String[] content = { doc.getText() };

        // tentar imprimir
        boolean success = basicPrinter.print(content);
        if (!success) {
            System.out.println("Job rejected by spool: out of ink or paper.");
            basicPrinter.refill();
            if (basicPrinter.print(content)) {
                System.out.println("Finished Job " + jobCounter + ": \"" 
                    + doc.getText().substring(0, Math.min(20, doc.getText().length())) + "...\"");
                return jobCounter++;
            }
            return -1;
        }

        System.out.println("Finished Job " + jobCounter + ": \"" 
            + doc.getText().substring(0, Math.min(20, doc.getText().length())) + "...\"");
        return jobCounter++;
    }

    @Override
    public List<Integer> print(List<Document> docs) {
        System.out.println("Spooling " + docs.size() + " documents.");
        List<Integer> jobIds = new ArrayList<>();

        for (Document d : docs) {
            int id = print(d);
            if (id != -1)
                jobIds.add(id);
            }
        return jobIds;
    }

    @Override
    public void showQueuedJobs() {
        System.out.println("No spooled jobs."); // BasicPrinter não tem fila
    }

    @Override
    public boolean cancelJob(int jobId) {
        System.out.println("Cannot cancel job " + jobId + ": BasicPrinter prints immediately.");
        return false;
    }

    @Override
    public void cancelAll() {
        System.out.println("Cannot cancel all jobs: BasicPrinter prints immediately.");
    }
}
