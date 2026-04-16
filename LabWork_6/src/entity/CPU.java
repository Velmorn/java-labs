package entity;

public class CPU extends Component implements Upgradable {
    private int cores;
    private int threads;
    private double frequency;

    public CPU(String name, double price, Manufacturer manufacturer,
               int cores, int threads, double frequency) {
        super(name, price, manufacturer);
        this.cores = cores;
        this.threads = threads;
        this.frequency = frequency;
    }

    @Override
    public void info() {
        System.out.println("CPU: " + name +
                " | " + cores + " cores / " + threads + " threads" +
                " | " + frequency + "GHz" +
                " | $" + price +
                " | " + manufacturer);
    }

    @Override
    public void upgrade() {
        frequency += 0.5;
        System.out.println("CPU upgraded! New frequency: " + frequency);
    }

    public int getCores() {
        return cores;
    }

    public int getThreads() {
        return threads;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Component component) {
        return 0;
    }
}
