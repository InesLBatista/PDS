import java.util.ArrayList;
import java.util.List;

public class CargoShip implements Ship {
	private final String id;
	private final String name;
	private final double cargo;
	private final List<PassengerShip> ships;
	private final int maxShips;

	public CargoShip(String id, String name, double cargo) {
		this.id = id;
		this.name = name;
		this.cargo = cargo;
		this.ships = null;
		this.maxShips = 0;
	}

	// Construtor para navio que transporta outros navios
	public CargoShip(String id, String name, double cargo, int maxShips) {
		this.id = id;
		this.name = name;
		this.cargo = cargo;
		this.ships = new ArrayList<>();
		this.maxShips = maxShips;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	public double getCargo() {
		return cargo;
	}

	public boolean addPassengerShip(PassengerShip ship) {
		if (ships == null || ships.size() >= maxShips) {
			return false;
		}
		ships.add(ship);
		return true;
	}

	public boolean removePassengerShip(PassengerShip ship) {
		if (ships == null) {
			return false;
		}
		return ships.remove(ship);
	}

	@Override
	public String toString() {
		if (ships != null) {
			StringBuilder sb = new StringBuilder();
			sb.append("CargoShip [id=").append(id).append(", name=").append(name)
				.append(", cargo=").append(cargo).append(", maxShips=").append(maxShips)
				.append(", ships=").append(ships.size()).append("]");
			for (PassengerShip ship : ships) {
				sb.append("\n  ").append(ship);
			}
			return sb.toString();
		}
		return "CargoShip [id=" + id + ", name=" + name + ", cargo=" + cargo + "]";
	}
}
