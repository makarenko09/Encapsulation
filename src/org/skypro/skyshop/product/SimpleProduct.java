package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(int price, String name) throws RuntimeException {
        super(name);
        try {
        this.price = price;
            if (this.price <= 0) {
            throw new IllegalArgumentException("цена не может быть отрицательной или нулём");
        }
        } catch (IllegalArgumentException e) {
            System.out.println("SimpleProduct.IllegalArgumentException");
            System.out.println(e);
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
