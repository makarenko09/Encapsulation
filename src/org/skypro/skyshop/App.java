package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    private static final int fixIndexValueOfMethodToAddProduct = 600;
    private static int coast = 0;
    public static void main(String[] args) {
        Product[] products = new Product[fixIndexValueOfMethodToAddProduct];
        products[coast++] = new SimpleProduct(100, "яицо");
        products[coast++] = new SimpleProduct(200, "молоко");
        products[coast++] = new SimpleProduct(300, "сыр");
        products[coast++] = new SimpleProduct(450, "телёнок");
        products[coast++] = new SimpleProduct(500, "печенье");
        products[coast++] = new SimpleProduct(90_009_666, "яблоко Эдема");
        products[coast++] = new SimpleProduct(78, "кефир");
        products[coast++] = new SimpleProduct(350, "грецкий орех 110г.");
        products[coast++] = new SimpleProduct(496, "прокладки");
        products[coast++] = new SimpleProduct(47, "хлеб");

        print(products);
        ProductBasket basket = new ProductBasket();

        System.out.println("Sum of products in the basket = " + basket.takePay());
        basket.printBasket();

        String productNameToCheck = "яблоко Эдема";
        basket.checkProduct(productNameToCheck);

        basket.clearBasket();
        print(products);
        basket.printBasket();

        //demo
        System.out.println("#####\n#####\n#####\n#####\n#####\n#####\n!Добавление продукта в корзину...");
        Product[] productsDemo = new Product[10];
        ProductBasket basketDemo = new ProductBasket();
        productsDemo[0] = new SimpleProduct(200, "упаковка яиц 10шт.");
        basketDemo.addProduct(productsDemo[0]);

        System.out.println("!Добавление продукта в заполненную корзину, в которой нет свободного места...");
        ProductBasket fullPullBasketDemo = new ProductBasket();
        productsDemo[5] = new SimpleProduct(15_000, "МОЁТ");
        productsDemo[6] = new SimpleProduct(200, "молоко");
        productsDemo[7] = new SimpleProduct(300, "сыр");
        productsDemo[3] = new SimpleProduct(450, "телёнок");
        productsDemo[4] = new SimpleProduct(500, "печенье");
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
        // lesson two
        System.out.println("#####\n#####\n#####\n#####\n#####\n#####\n!Создайте в методе несколько товаров специальных типов вместо " +
                "SimpleProduct...");
        productsDemo[0] = new DiscountedProduct("Килька в томатном соусе", 150, 15);
        productsDemo[1] = new DiscountedProduct("Икра красная", 2700, 26);
        productsDemo[2] = new SimpleProduct(50, "Капуста зеленая");
        productsDemo[3] = new SimpleProduct(280, "Перец острый-Чили");
        productsDemo[6] = new FixPriceProduct("Банка пива ж/б 0.5л. «ОХОТА КРЕПКАЯ»");
        productsDemo[7] = new FixPriceProduct("Лимонад Макеевский с/б 0.45л. «Клюква»");
        productsDemo[4] = new DiscountedProduct("Фигурка Альтаира", 18_000000, 99);
        ProductBasket newBasketDemo = new ProductBasket();
        newBasketDemo.addProduct(productsDemo[0]);
        newBasketDemo.addProduct(productsDemo[1]);
        newBasketDemo.addProduct(productsDemo[6]);
        newBasketDemo.addProduct(productsDemo[7]);
        newBasketDemo.addProduct(productsDemo[4]);

        System.out.println("!Проверьте, что все методы выводят правильные значения...");
        print(productsDemo);
        System.out.println("!Убедитесь, что метод печати содержимого корзины выводит результат в нужной форме...");
        newBasketDemo.printBasket();
        System.out.println("newBasketDemo.takePay() = " + newBasketDemo.takePay());
    }

    private static void print(Product[] products) {
        System.out.println("\nApp.print");
        System.out.println("Список продуктов:");
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }

        }
    }
}