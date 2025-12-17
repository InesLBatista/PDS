// Navio de passageiros
public class PassengerShip implements Ship {
	private final String id;
	private final String name;
	private final int maxPassengers; // Capacidade máxima

	public PassengerShip(String id, String name, int maxPassengers) {
		this.id = id;
		this.name = name;
		this.maxPassengers = maxPassengers;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}

	@Override
	public String toString() {
		return "PassengerShip [id=" + id + ", name=" + name + ", maxPassengers=" + maxPassengers + "]";
	}
}
