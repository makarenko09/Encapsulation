package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(int price, String name) {
        super(name);
        this.price = price;
        try {
            if (price == 0 || price < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("SimpleProductOnConstructor.ExceptionOfPrice: " + price);
            System.out.println("Exc.Price.toString{" +
                    "price=" + price +
                    '}');
            System.err.println(e);
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
