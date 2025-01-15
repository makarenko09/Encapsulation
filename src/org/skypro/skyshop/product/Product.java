package org.skypro.skyshop.product;

public abstract class Product {
    protected String name;

    public Product(String name) {
        this.name = name;
        if (this.name.length() < 2 || this.name.length() > 150) {
            throw new IllegalArgumentException("имя товара должно быть от 2 до 20 символов");
        }
    }

    public abstract int getPrice();
public abstract boolean isSpecial();
    public String getName() {

        if (name == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }
        return this.name;
    }

    public String toString() {
        return  "name='" + name + '\'';
    }
}