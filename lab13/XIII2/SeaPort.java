import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Gestor de porto marítimo
public class SeaPort implements Port {
	private final Map<String, Ship> ships; // Embarcações indexadas por código

	public SeaPort() {
		this.ships = new HashMap<>();
	}

	@Override
	public boolean add(String ref, Ship p) {
		ships.put(ref, p);
		return true;
	}

	@Override
	public boolean exists(String ref) {
		return ships.containsKey(ref);
	}

	@Override
	public Ship remove(String ref) {
		return ships.remove(ref);
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private final Iterator<Map.Entry<String, Ship>> it = ships.entrySet().iterator();

			@Override
			public boolean hasNext() {
				return it.hasNext();
			}

			@Override
			public String next() {
				Map.Entry<String, Ship> entry = it.next();
				return entry.getKey() + " -> " + entry.getValue();
			}
		};
	}
}
