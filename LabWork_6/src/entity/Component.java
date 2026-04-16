package entity;

public abstract class Component implements Comparable<Component> {
    protected String name;
    protected double price;
    protected Manufacturer manufacturer;

    public Component(String name, double price, Manufacturer manufacturer) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public abstract void info();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Component c)) return false;
        return name.equals(c.name) && manufacturer.equals(c.manufacturer);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + manufacturer.hashCode();
    }

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
