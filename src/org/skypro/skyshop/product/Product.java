package org.skypro.skyshop.product;

public class Product {

    private String name;
    private Integer price;

    public Product(int price, String name) {
        if (price <= 0) {
            throw new IllegalArgumentException("цена не может быть отрицательной или нулём");
        }
        if (name.length() < 2 || name.length() > 20) {
            throw new IllegalArgumentException("имя товара должно быть от 2 до 20 символов");
        }
        this.price = price;
        this.name = name;

    }

    public String getName() {

        if (name == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return "price=" + price +
                ", name='" + name + '\'';
    }
}