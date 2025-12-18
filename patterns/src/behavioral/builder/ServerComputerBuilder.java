package behavioral.builder;

public class ServerComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public ServerComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU() {
        computer.setCpu("AMD EPYC");
    }

    @Override
    public void buildGPU() {
        computer.setGpu("Nenhuma");
    }

    @Override
    public void buildRAM() {
        computer.setRam("64GB ECC");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("4TB NVMe");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setSo("Linux Server");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
