import java.util.ArrayList;
import java.util.List;

// Regista todas as operações realizadas
public class RiverLogger {
	private final List<String> logs; // Histórico de operações

	public RiverLogger() {
		this.logs = new ArrayList<>();
	}

	public void log(String operation, String ref, String details) {
		String logEntry = String.format("[%s] %s: %s - %s", 
			new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()),
			operation, ref, details);
		logs.add(logEntry);
	}

	public List<String> getLogs() {
		return new ArrayList<>(logs);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String log : logs) {
			sb.append(log).append("\n");
		}
		return sb.toString();
	}
}
