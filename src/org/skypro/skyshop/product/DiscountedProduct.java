package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basicPrice;
    private int discountInTargetCurrencies;

    public DiscountedProduct(String name, int basicPrice, int discountInTargetCurrencies) throws IllegalArgumentException{
        super(name);
        this.discountInTargetCurrencies = discountInTargetCurrencies;
        this.basicPrice = basicPrice;
            if (basicPrice < 0) {
                System.out.println("BasicPrice.Exc.ZeroDown.toString{" +
                        "price=" + basicPrice +
                        '}');
                throw new IllegalArgumentException("Цена не может быть ниже нуля");
            }
            if ((discountInTargetCurrencies < 0 || discountInTargetCurrencies > 100)) {
                System.out.println("Discount.Exc.Value{" +
                        "discount=" + discountInTargetCurrencies +
                        ", price=" + basicPrice +
                        '}');
                throw new IllegalArgumentException("Скидка не может быть ниже 0 и больше 100-та");
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
