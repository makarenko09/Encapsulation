package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basicPrice;
    private int discountInTargetCurrencies;

    public DiscountedProduct(String name, int basicPrice, int discountInTargetCurrencies) {
        super(name);
        this.discountInTargetCurrencies = discountInTargetCurrencies;
        this.basicPrice = basicPrice;
        try {
            if (basicPrice < 0) {
                System.out.println("Exc.Price.toString{" +
                        "price=" + basicPrice +
                        '}');
                throw new IllegalArgumentException(String.valueOf(basicPrice));
            }
            if ((discountInTargetCurrencies < 0 || discountInTargetCurrencies > 100)) {
                System.out.println("ExceptionFixPrice{" +
                        "discountInTargetCurrencies=" + discountInTargetCurrencies +
                        ", price=" + basicPrice +
                        '}');
                throw new IllegalArgumentException(String.valueOf(discountInTargetCurrencies));
            }
                } catch (IllegalArgumentException e) {
            System.out.println("DiscountedProductOnConstructor.ExceptionOfPrice");
            System.out.println(e);
        }
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return basicPrice * (100 - discountInTargetCurrencies) / 100;
    }

    public int getDiscountInTargetCurrencies() {
        return discountInTargetCurrencies;
    }

    @Override
    public String toString() {
        return "<" + getName() + ">:" + " " + "<" + getPrice() + ">" + "(<" + discountInTargetCurrencies + ">%)";
    }
}
