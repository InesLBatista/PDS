package creational.singleton;

// classe logger garante apenas uma instância no sistema
// padrão singleton no controlo dos logs
public class Logger {
    private static Logger instancia;

    private Logger() {
        System.out.println("Logger iniciado - Instância única criada.");
    }


    // método estático para obter a instância única do logger
    // usa synchronized para garantir thread-safety
    public static synchronized Logger getInstancia() {
        if (instancia == null) {
            instancia = new Logger();
        }
        return instancia;
    }

    // regista uma mensagem do log
    public void log(String mensagem) {
        String timestamp = java.time.LocalDateTime.now().toString();
        System.out.println("[" + timestamp + "] LOG: " + mensagem);
    }

    // regista uma mensagem de log com nível associado
    public void log(String nivel, String mensagem) {
        String timestamp = java.time.LocalDateTime.now().toString();
        System.out.println("[" + timestamp + "] " + nivel + ": " + mensagem);
    }

    // mensagem de informação
    public void info(String mensagem) {
        log("INFO", mensagem);
    }

    // mensagem de aviso 
    public void warning(String mensagem) {
        log("WARNING", mensagem);
    }

    // mensagem de erro
    public void error(String mensagem) {
        log("ERROR", mensagem);
    }
}
