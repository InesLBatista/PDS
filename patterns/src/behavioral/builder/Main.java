package behavioral.builder;

public class Main {
    public static void main(String[] args) {

        Director director = new Director();

        String[] tipos = { "GAMING", "OFFICE", "SERVER" };

        for (String tipoComputador : tipos) {

            ComputerBuilder builder;

            switch (tipoComputador) {
                case "GAMING":
                    builder = new GamingComputerBuilder();
                    break;
                case "OFFICE":
                    builder = new OfficeComputerBuilder();
                    break;
                case "SERVER":
                    builder = new ServerComputerBuilder();
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de computador não suportado");
            }

            director.constructComputer(builder);
            Computer computer = builder.getComputer();

            System.out.println("Tipo de computador: " + tipoComputador);
            System.out.println(computer);
        }
    }
}
