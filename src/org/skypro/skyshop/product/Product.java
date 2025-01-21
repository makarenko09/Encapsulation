package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected String name;


    public Product(String name) throws RuntimeException {
        try {
            this.name = name;
            getExcWithName();
        } catch (ExceptionOfNullInName | ExceptionOutFromRangeOfValueSumSymbolInStringName | ExceptionDangerOfValueSymbolInStringName e) {
            System.out.println(e);
            System.out.println("ProductOnConstructor.ExceptionOfName");
        }
    }

    private void getExcWithName () throws ExceptionOfNullInName, ExceptionOutFromRangeOfValueSumSymbolInStringName, ExceptionDangerOfValueSymbolInStringName {
        if (name == null) {
            System.out.println("Product.ExceptionOfNullInName");
            throw new ExceptionOfNullInName();
        }
        ExceptionOutFromRangeOfValueSumSymbolInStringName e = new ExceptionOutFromRangeOfValueSumSymbolInStringName(name);
        e.getExcDangerValueFromNameOfProduct();
        System.out.println("Product.getOutForm2and20");
        ExceptionDangerOfValueSymbolInStringName e1 = new ExceptionDangerOfValueSymbolInStringName(name);
        e1.getExcSpace();
        System.out.println("Product.getExcWithSpace");
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String searchTerm() {
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