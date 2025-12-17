package Praticas.lab07.ex3;

import java.util.concurrent.Callable;

public class PrintJob implements Callable<Boolean> {
    private Document document;
    private BasicPrinter printer;
    private int jobId;
    
    public PrintJob(Document document, BasicPrinter printer, int jobId) {
        this.document = document;
        this.printer = printer;
        this.jobId = jobId;
    }
    
    @Override
    public Boolean call() throws Exception {
        // Simular tempo de processamento antes de verificar recursos
        Thread.sleep(1000);
        
        String[] content = { document.getText() };
        boolean success = printer.print(content);
        
        if (!success && (!printer.hasInk() || !printer.hasPaper())) {
            System.out.println("Job rejected by spool: out of ink or paper");
            printer.refill();
            // Tentar novamente após refill
            success = printer.print(content);
        }
        
        return success;
    }
    
    public int getJobId() {
        return jobId;
    }
    
    public Document getDocument() {
        return document;
    }
}