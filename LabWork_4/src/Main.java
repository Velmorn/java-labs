import entity.*;

public class Main {
    public static void main(String[] args) {

        Manufacturer intel = new Manufacturer("Intel", "USA");
        Manufacturer nvidia = new Manufacturer("Nvidia", "USA");
        Manufacturer kingston = new Manufacturer("Kingston", "USA");

        CPU cpu = new CPU("i5-12400F", 180, intel, 6, 12, 2.5);
        RAM ram = new RAM("Fury Beast", 70, kingston, 16, 3200);
        GPU gpu = new GPU("RTX 3060", 350, nvidia, 12, 1777);

        Computer pc = new Computer(cpu, ram, gpu);

        pc.showSpecs();

        Computer.description();

        gpu.upgrade();
        cpu.upgrade();

        User user = new User("Max", 19);
        user.useComputer(pc);
    }
}