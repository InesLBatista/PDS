package behavioral.builder;

public class Computer {

    private String cpu;
    private String gpu;
    private String ram;
    private String storage;
    private String so;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setSo(String so) {
        this.so = so;
    }

    @Override
    public String toString() {
        return "Computer {" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", so='" + so + '\'' +
                '}';
    }
}