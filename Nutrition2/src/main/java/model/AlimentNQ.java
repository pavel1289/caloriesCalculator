package model;

import java.util.Objects;

public class AlimentNQ {
    private String name;
    private double quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlimentNQ alimentNQ = (AlimentNQ) o;
        return name.equals(alimentNQ.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
