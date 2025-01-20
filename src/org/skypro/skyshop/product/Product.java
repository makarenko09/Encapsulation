package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected String name;

    public Product(String name) {
        this.name = name;
        if (this.name.length() < 2 || this.name.length() > 150) {
            throw new IllegalArgumentException("имя товара должно быть от 2 до 20 символов");
        }
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String searchable() {
        return toString();
    }

    @Override
    public String searchTerm(String request) {
        if (name == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }
        return name;

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