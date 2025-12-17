import java.util.Iterator;

public class RiverPort implements Port {
	private final SeaPort seaPort;
	private final RiverLogger logger;
	private static final double MAX_SIZE = 10.0;

	private RiverPort(RiverLogger logger) {
		this.seaPort = new SeaPort();
		this.logger = logger;
	}

	// Método fábrica - forma recomendada de criar RiverPort
	public static RiverPort createRiverPort(RiverLogger logger) {
		return new RiverPort(logger);
	}

	@Override
	public boolean add(String ref, Ship p) {
		if (p instanceof CargoShip cs) {
			if (cs.getCargo() > MAX_SIZE) {
				if (logger != null) {
					logger.log("ADD_REJECTED", ref, "Ship too large: " + cs.getCargo());
				}
				return false;
			}
		}
		
		boolean result = seaPort.add(ref, p);
		if (logger != null) {
			logger.log("ADD", ref, result ? "Success" : "Failed");
		}
		return result;
	}

	@Override
	public boolean exists(String ref) {
		boolean result = seaPort.exists(ref);
		if (logger != null) {
			logger.log("EXISTS", ref, String.valueOf(result));
		}
		return result;
	}

	@Override
	public Ship remove(String ref) {
		Ship result = seaPort.remove(ref);
		if (logger != null) {
			logger.log("REMOVE", ref, result != null ? "Success" : "Not found");
		}
		return result;
	}

	@Override
	public Iterator<String> iterator() {
		return seaPort.iterator();
	}
}
