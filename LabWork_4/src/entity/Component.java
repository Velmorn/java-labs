package entity;

public abstract class Component {
    protected String name;
    protected double price;
    protected Manufacturer manufacturer;

    public Component(String name, double price, Manufacturer manufacturer) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public abstract void info();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
