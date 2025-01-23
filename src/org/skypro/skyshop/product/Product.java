package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected String name;


    public Product(String name) throws RuntimeException {
            this.name = name;
        try {
            getExcWithName();
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("ProductOnConstructor.ExceptionOfName");
            System.out.println(e);
        }
    }

    private void getExcWithName() {
        if (name == null) {
            System.out.println("Product.ExceptionOfNullInName");
            System.out.println("Exc.ExceptionOfNullInName.toString" + ": недопустимое значение Null - " + name);
            throw new NullPointerException(name);
        }
        if (this.name.length() < 2 || this.name.length() > 20) {
            System.out.println("Product.getOutForm2and20");
            System.out.println("Exc.OutFromRangeOfValueSumSymbolInStringName.toString{" +
                    "name='" + name + '\'' + "- имя товара должно быть от 2 до 20 символов\"" +
                    '}');
            throw new IllegalArgumentException(name);
        }

        if (name.isBlank()) {
            System.out.println("Product.getExcWithSpace");
            System.out.println("Exc.DangerOfValueSymbolInStringName.toString{" +
                    "name='" + name + "' - неправильное название для продукта.\"" + '\'' +
                    '}');
            throw new IllegalArgumentException(name);
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