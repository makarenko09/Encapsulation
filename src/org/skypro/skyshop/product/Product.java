package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected String name;


    public Product(String name) throws NullPointerException, IllegalArgumentException {
            this.name = name;
        if (name == null) {
            System.out.println("Product.getNullInName");
            System.out.println("Name.Exc.Null.toString{" +
                    "name='" + name + '}');
            throw new NullPointerException("Имя продукта не может быть null");
        }
        if (this.name.length() < 2 || this.name.length() > 20) {
            System.out.println("Product.getRangeInName");
            System.out.println("Name.Exc.Range.toString{" +
                    "name='" + name + '}');
            throw new IllegalArgumentException("Имя продукта должно быть от 2 до 20 символов");
        }
        if (name.isBlank()) {
            System.out.println("Product.getSpaceInName");
            System.out.println("Name.Exc.Value.toString{" +
                    "name='" + name +   '}');
            throw new IllegalArgumentException("Не должно быть пробелов взаместо имени продукта");
        }

    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerm() {
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