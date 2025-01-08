package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private static final int MAX_PRODUCTS = 5;
    private final Product[] products;
        private int count = 0;

    public ProductBasket() {
        products = new Product[MAX_PRODUCTS];

    }

    public void addProduct(Product product) {
        if (count >= MAX_PRODUCTS) {
            System.out.println("Корзина заполнена, невозможно добавить продукт: " + product);
            return;
        }
        if (product == null) {
            System.out.println("Нельзя добавить null-продукт");
            return;
        }
        products[count++] = product;
    }

    public void printBasket() {
        System.out.println("\nProductBasket.printBasket");
        int nullCount = 0;
        for (Product product : products) {
            if (product == null) {
                nullCount++;
            }
        }
        if (nullCount >= products.length) {
            System.out.println("«В корзине пусто».");
        } else {
            for (Product product : products) {
                if (product != null) { // Проверяем, чтобы продукт не был null

                    System.out.println("<" + product.getName() + ">: " + "<" + product.getPrice() + ">");

                }
            }
            System.out.println("Итого: <" + takePay() + ">");
        }
    }

    public int takePay() {
        int sumToPay = 0;
        for (Product product : products) {
            if (product != null) {
                sumToPay += product.getPrice();
            } else {
                return sumToPay += 0;
            }
        }
        return sumToPay;
    }

    public boolean checkProductOnBasket(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }

        for (Product product : products) {
            if (product != null && product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                products[i] = null;
            }
        }
    }



    @Override
    public String toString() {
        return "ProductBasket{" +
                "products=" + Arrays.toString(products) +
                '}';
    }



    public static Integer[] searchNull(Product[] products) {
        Integer[] integerArray = new Integer[products.length];
        int count = 0;

        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                integerArray[count] = i;
                count++;
            }
        }

        return Arrays.copyOf(integerArray, count);
    }
}