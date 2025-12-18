package creational.builder;

public class Director {
    public void constructComputer(ComputerBuilder builder) {
        builder.buildCPU();
        builder.buildGPU();
        builder.buildRAM();
        builder.buildStorage();
        builder.buildOperatingSystem();
    }
}
