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

    public void addProductFromMemoryProduct(Product product) {
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

    public void addProductOnBasket(ProductBasket basket, Product[] products) {
        System.out.println("Basket.addProductOnBasket");
        for (Product product : products) {
            basket.addProductFromMemoryProduct(product);
        }
        System.out.println("basket = " + basket);
    }

    public void printBasket() {
        System.out.println("\nProductBasket.printBasket");
        if (searchNull(products).length >= MAX_PRODUCTS) {
            System.out.println("«в корзине пусто».");
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

    public void clearBasket2() {
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



    public static void sumAndCompare(Integer[] nullIndices) {
        if (nullIndices != null) {
            int sum = 0;
            for (Integer index : nullIndices) {
                sum += index;
            }
            System.out.println("Сумма индексов null элементов: " + sum);
            System.out.println("Количество null элементов: " + nullIndices.length);
            if (sum > nullIndices.length) {
                System.out.println("Сумма индексов больше количества null элементов.");
            } else if (sum < nullIndices.length) {
                System.out.println("Сумма индексов меньше количества null элементов.");
            } else {
                System.out.println("Сумма индексов равна количеству null элементов.");
            }
        }
    }
}