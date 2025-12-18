package behavioral.builder;

public interface ComputerBuilder {
    void buildCPU();
    void buildGPU();
    void buildRAM();
    void buildStorage();
    void buildOperatingSystem();

    Computer getComputer();
}
