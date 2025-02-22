package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;
import java.util.regex.Pattern;

public abstract class Product implements Searchable {
    protected String name;


    public Product(String name) {
        if (!Pattern.matches("^.{2,20}$",name)) {
            System.out.println("Product.getName");
            System.out.println("Name.Exc.toString{" +
                    "name='" + name + '}');
            throw new IllegalArgumentException("Некорректное имя продукта");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product)) return false;
        return Objects.equals(name, ((Product) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerm() {
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
        return "name='" + name + '\'';
    }
}