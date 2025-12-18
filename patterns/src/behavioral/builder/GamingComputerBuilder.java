package behavioral.builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU() {
        computer.setCpu("Intel i9");
    }

    @Override
    public void buildGPU() {
        computer.setGpu("NVIDIA RTX 4090");
    }

    @Override
    public void buildRAM() {
        computer.setRam("32GB");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("2TB SSD");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setSo("Windows 11");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
