package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(int price, String name) {
        super(name);
        this.price = price;
        if (this.price <= 0) {
            throw new IllegalArgumentException("цена не может быть отрицательной или нулём");
        }
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "<" + this.getName() + ">:" + " " + "<" + this.getPrice() + ">";
    }
}
