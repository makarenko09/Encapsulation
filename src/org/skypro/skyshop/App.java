package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product[] products = new Product[10];
        ProductBasket basket = new ProductBasket();

        addProduct(products);
        print(products);

        System.out.println("Sum of products in the basket = " + basket.takePay());
        basket.printBasket();

        String productNameToCheck = "яблоко Эдема";
        checkProduct(basket, productNameToCheck);

        basket.clearBasket();
        print(products);
        basket.printBasket();

        //demo
        System.out.println("\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n###################################################\n!Добавление продукта в корзину...");
        Product[] productsDemo = new Product[10];
        ProductBasket basketDemo = new ProductBasket();
        productsDemo[0] = new Product(200, "упаковка яиц 10шт.");
        basketDemo.addProduct(productsDemo[0]);

        System.out.println("!Добавление продукта в заполненную корзину, в которой нет свободного места...");
        ProductBasket fullPullBasketDemo = new ProductBasket();
        productsDemo[5] = new Product(15_000, "МОЁТ");
        productsDemo[6] = new Product(200, "молоко");
        productsDemo[7] = new Product(300, "сыр");
        productsDemo[3] = new Product(450, "телёнок");
        productsDemo[4] = new Product(500, "печенье");
        basketDemo.addProduct(productsDemo[0]);
        fullPullBasketDemo.addProduct(productsDemo[5]);
        fullPullBasketDemo.addProduct(productsDemo[6]);
        fullPullBasketDemo.addProduct(productsDemo[7]);
        fullPullBasketDemo.addProduct(productsDemo[3]);
        fullPullBasketDemo.addProduct(productsDemo[4]);

        System.out.println("!Печать содержимого корзины с несколькими товарами...");
        print(productsDemo);
        fullPullBasketDemo.printBasket();
        basketDemo.printBasket();

        System.out.println("!Получение стоимости корзины с несколькими товарами...");
        System.out.println(fullPullBasketDemo.takePay());
        System.out.println(basketDemo.takePay());

        System.out.println("!Поиск товара, который есть в корзине...");
        System.out.println(fullPullBasketDemo.checkProductOnBasket("молоко"));

        System.out.println("!Поиск товара, которого нет в корзине.");
        System.out.println(fullPullBasketDemo.checkProductOnBasket("упаковка яиц 10шт"));

        System.out.println("!Очистка корзины...");
        fullPullBasketDemo.clearBasket();
        basketDemo.clearBasket();

        System.out.println("!Печать содержимого пустой корзины...");
        fullPullBasketDemo.printBasket();
        basketDemo.printBasket();

        System.out.println("!Получение стоимости пустой корзины...");
        System.out.println(fullPullBasketDemo.takePay());
        System.out.println(basketDemo.takePay());

        System.out.println("!Поиск товара по имени в пустой корзине...");
        System.out.println(fullPullBasketDemo.checkProductOnBasket("молоко"));
        System.out.println(fullPullBasketDemo.checkProductOnBasket("сыр"));
        System.out.println(basketDemo.checkProductOnBasket("молоко"));
        System.out.println(basketDemo.checkProductOnBasket("сыр"));

    }

    private static void checkProduct(ProductBasket basket, String name) {
        boolean checked = basket.checkProductOnBasket(name);
        if (checked) {
            System.out.println("Продукт: '" + name + "' есть в корзине, " + checked);
        } else {
            System.out.println("Продукт: '" + name + "' отсутствует в корзине, " + checked);
        }
    }

    private static void addProduct(Product[] products) {
        products[0] = new Product(100, "яицо");
        products[1] = new Product(200, "молоко");
        products[2] = new Product(300, "сыр");
        products[3] = new Product(450, "телёнок");
        products[4] = new Product(500, "печенье");
        products[5] = new Product(90_009_666, "яблоко Эдема");
    }

    private static void print(Product[] products) {
        System.out.println("\nApp.print");
        System.out.println("Список продуктов:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}