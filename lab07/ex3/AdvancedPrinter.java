package Praticas.lab07.ex3;

import java.util.*;
import java.util.concurrent.*;

public class AdvancedPrinter implements AdvancedPrinterInterface {

    class PrinterService implements Runnable {
        private final LinkedBlockingQueue<PrintJob> printQueue;
        private final ExecutorService pool;
        private int jobCounter = 0;
        private volatile boolean running = true;
        private BasicPrinter physicalPrinter;
        private volatile PrintJob currentJob;
     
        public PrinterService() {
            printQueue = new LinkedBlockingQueue<>();
            pool = Executors.newFixedThreadPool(1);
            physicalPrinter = new BasicPrinter();
        }
     
        public void run() {
            try {
                while (running && !Thread.currentThread().isInterrupted()) {
                    currentJob = printQueue.take();
                    
                    Future<Boolean> future = pool.submit(currentJob);
                    Boolean success = future.get(); // Espera a conclusão
                    
                    if (success) {
                        System.out.println("Finished Job " + currentJob.getJobId() + ": \"" 
                            + currentJob.getDocument().getText().substring(0, Math.min(20, currentJob.getDocument().getText().length())) + "...\"");
                    }
                    currentJob = null;
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                System.out.println("Error printing job " + (currentJob != null ? currentJob.getJobId() : "unknown"));
            } finally {
                shutdownAndAwaitTermination();
            }
        }

        public int newPrintJob(Document doc) {
            PrintJob job = new PrintJob(doc, physicalPrinter, jobCounter);
            if (running && printQueue.offer(job)) {
                return jobCounter++;
            }
            System.out.println("Job rejected by spool: service shutting down?");
            return -1;
        }

        public boolean cancelJob(int jobId) {
            // Procurar na fila
            Iterator<PrintJob> iterator = printQueue.iterator();
            while (iterator.hasNext()) {
                PrintJob job = iterator.next();
                if (job.getJobId() == jobId) {
                    iterator.remove();
                    System.out.println("Cancelled Job " + jobId + ": \"" 
                        + job.getDocument().getText().substring(0, Math.min(20, job.getDocument().getText().length())) + "...\"");
                    return true;
                }
            }
            
            // Verificar se é o job atual
            if (currentJob != null && currentJob.getJobId() == jobId) {
                System.out.println("Cannot cancel Job " + jobId + ": already printing");
                return false;
            }
            
            System.out.println("Job " + jobId + " not found");
            return false;
        }
        
        public void cancelAll() {
            printQueue.clear();
            System.out.println("All jobs cancelled");
        }
        
        public List<PrintJob> getQueuedJobs() {
            List<PrintJob> jobs = new ArrayList<>(printQueue);
            if (currentJob != null) {
                jobs.add(0, currentJob); // Job atual no início
            }
            return jobs;
        }
        
        public void stop() {
            running = false;
            pool.shutdownNow();
            printQueue.clear();
            if (spoolThread != null) {
                spoolThread.interrupt();
            }
        }
    
        void shutdownAndAwaitTermination() {
            pool.shutdown();
            try {
                if (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
                    pool.shutdownNow();
                }
            } catch (InterruptedException ie) {
                pool.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    private PrinterService spool;
    private Thread spoolThread;

    public AdvancedPrinter() {
        this.spool = new PrinterService();
        this.spoolThread = new Thread(this.spool);
        this.spoolThread.start();
    }

    @Override
    public int print(Document doc) {
        System.out.println("Spooling 1 document.");
        int jobId = spool.newPrintJob(doc);
        return jobId;
    }

    @Override
    public List<Integer> print(List<Document> docs) {
        System.out.println("Spooling " + docs.size() + " documents.");
        List<Integer> jobIds = new ArrayList<>();
        for (Document doc : docs) {
            int jobId = spool.newPrintJob(doc);
            if (jobId != -1) {
                jobIds.add(jobId);
            }
        }
        return jobIds;
    }

    @Override
    public void showQueuedJobs() {
        List<PrintJob> queuedJobs = spool.getQueuedJobs();
        if (queuedJobs.isEmpty()) {
            System.out.println("No spooled jobs.");
        } else {
            System.out.println("Spooled jobs:");
            for (PrintJob job : queuedJobs) {
                // Mostrar apenas jobs que ainda não começaram a imprimir
                if (job != spool.currentJob) {
                    System.out.println("  * Job " + job.getJobId() + ": \"" 
                        + job.getDocument().getText().substring(0, Math.min(20, job.getDocument().getText().length())) + "...\"");
                }
            }
        }
    }

    @Override
    public boolean cancelJob(int jobId) {
        return spool.cancelJob(jobId);
    }

    @Override
    public void cancelAll() {
        spool.cancelAll();
    }
    
    public void shutdown() {
        spool.stop();
    }
}