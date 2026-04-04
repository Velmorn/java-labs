package entity;

public class GPU extends Component implements Upgradable {
    private int vram;
    private int clockSpeed;

    public GPU(String name, double price, Manufacturer manufacturer,
               int vram, int clockSpeed) {
        super(name, price, manufacturer);
        this.vram = vram;
        this.clockSpeed = clockSpeed;
    }

    @Override
    public void info() {
        System.out.println("GPU: " + name +
                " | VRAM: " + vram + "GB" +
                " | Clock: " + clockSpeed + "MHz" +
                " | $" + price +
                " | " + manufacturer);
    }

    @Override
    public void upgrade() {
        vram += 2;
        clockSpeed += 100;
        System.out.println("GPU upgraded!");
    }

    public int getVram() {
        return vram;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setVram(int vram) {
        this.vram = vram;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }
}