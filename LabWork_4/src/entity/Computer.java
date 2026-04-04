package entity;

public class Computer {

    private CPU cpu;
    private RAM ram;
    private GPU gpu;

    public Computer(CPU cpu, RAM ram, GPU gpu) {
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = gpu;
    }

    public void showSpecs() {
        cpu.info();
        ram.info();
        gpu.info();
        System.out.println("Total price: $" + getTotalPrice());
    }

    public double getTotalPrice() {
        return cpu.getPrice() + ram.getPrice() + gpu.getPrice();
    }

    class PowerSupply {
        private int wattage = 600;

        public void supplyPower() {
            System.out.println("Power supply: " + wattage + "W working");
        }
    }

    public static void description() {
        System.out.println("Computer = CPU + RAM + GPU");
    }

    public void run() {

        class OperatingSystem {
            public void boot() {
                System.out.println("OS booted successfully");
            }
        }

        OperatingSystem os = new OperatingSystem();
        os.boot();

        PowerSupply ps = new PowerSupply();
        ps.supplyPower();

        System.out.println("Computer is running...");
    }
}