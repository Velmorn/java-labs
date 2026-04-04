package entity;

public class RAM extends Component {
    private int size;
    private int speed;

    public RAM(String name, double price, Manufacturer manufacturer,
               int size, int speed) {
        super(name, price, manufacturer);
        this.size = size;
        this.speed = speed;
    }

    @Override
    public void info() {
        System.out.println("RAM: " + name +
                " | " + size + "GB" +
                " | " + speed + "MHz" +
                " | $" + price +
                " | " + manufacturer);
    }

    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
