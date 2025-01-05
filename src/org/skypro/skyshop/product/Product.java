package org.skypro.skyshop.product;

public class Product {

    private String name;
    private int price;

    public Product(int price, String name) {
        if (price <= 0) {
            throw new IllegalArgumentException("цена не может быть отрицательной или нулём");
        }
        if (name.length() < 2 || name.length() > 20 || name == null) {
            throw new IllegalArgumentException("имя товара должно быть от 2 до 20 символов");
        }
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }


}