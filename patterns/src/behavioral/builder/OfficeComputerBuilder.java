package behavioral.builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU() {
        computer.setCpu("Intel i5");
    }

    @Override
    public void buildGPU() {
        computer.setGpu("Integrada");
    }

    @Override
    public void buildRAM() {
        computer.setRam("16GB");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("512GB SSD");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setSo("Windows 10");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
