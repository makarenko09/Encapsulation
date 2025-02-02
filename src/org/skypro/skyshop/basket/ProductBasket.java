package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    //    private static final int MAX_PRODUCTS = 5;
//    private Product[] products;

    private final List<Product> productsListT;
    private int count = 0;

//    public ProductBasket() {
//        products = new Product[MAX_PRODUCTS];
//        productsList = Arrays.asList(products);
//
//    }


    public ProductBasket() {
        this.productsListT = new LinkedList<>();
    }


    public void addProduct(Product product) {
        productsListT.add(product);
        count++;
        System.out.println("Номер продукта: " + count + " - продукт добавлен : " + product);
        System.out.println(product.isSpecial());

    }

    public void printBasket() {
        System.out.println("\nProductBasket.printBasket");
        int size = productsListT.size();

        if (size == 0 /*|| productsList.get(0) == null*/) {
            System.out.println("«В корзине пусто».");
        } else {
            for (Product product : productsListT) {
                System.out.println(product);
            }
            System.out.println("Итого: <" + takePay() + ">");
        }
    }

    public List<Product> deleteProductFromBasket(String name) {
        List<Product> removeNameList = new LinkedList<>();
        if (productsListT.size() == 0) {
                System.out.println("Cписок пуст.");
            return removeNameList;
        }
        Iterator<Product> iterator = productsListT.iterator();

        while ((iterator.hasNext())) {
               Product element = iterator.next();
            if (element.getName().equalsIgnoreCase(name)) {
                removeNameList.add(element);

                iterator.remove();
                System.out.println("Продукт: " + name + " удален из корзины");
                count--;
                }
        }

        return removeNameList;
    }

    public int takePay() {
        int sumToPay = 0;
        for (Product product : productsListT) {
            if (product != null) {
                sumToPay += product.getPrice();
            }
        }
        return sumToPay;
    }

    public boolean checkProductOnBasket(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }

        for (Product product : productsListT) {
            if (product != null && product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void checkProduct(String name) {
        boolean checked = checkProductOnBasket(name);
        if (checked) {
            System.out.println("Продукт: '" + name + "' есть в корзине, " + checked);
        } else {
            System.out.println("Продукт: '" + name + "' отсутствует в корзине, " + checked);
        }
    }

    public void clearBasket() {

        productsListT.removeAll(productsListT);
        count = 0;
    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "products=" + productsListT +
                '}';
    }
}