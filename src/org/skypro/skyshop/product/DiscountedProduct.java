package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basicPrice;
    private int discountInTargetCurrencies;

    public DiscountedProduct(String name, int basicPrice, int discountInTargetCurrencies) {
        super(name);
        this.basicPrice = basicPrice;
        if (basicPrice <= 0) {
            throw new IllegalArgumentException("цена не может быть отрицательной или нулём");
        }
        this.discountInTargetCurrencies = discountInTargetCurrencies;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return basicPrice * (100 - discountInTargetCurrencies) / 100;
    }

    @Override
    public String toString() {
        return "<" + getName() + ">:" + " " + "<" + getPrice() + ">" + "(<" + discountInTargetCurrencies + ">%)";
    }
}
