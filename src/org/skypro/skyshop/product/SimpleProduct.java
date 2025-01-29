package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(int price, String name) throws IllegalArgumentException {
        super(name);
        this.price = price;

        if (price == 0 || price < 0) {
            System.out.println("Price.Exc.ZeroDownANDZero.toString{" +
                    "price=" + price +
                    '}');
            throw new IllegalArgumentException();
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
