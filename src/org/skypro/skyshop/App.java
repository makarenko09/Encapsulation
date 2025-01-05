package org.skypro.skyshop;

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.ActionsProduct;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        Basket basket = new Basket(5); //createBasket1
        takeProducToBasket(basket);
    }

    public static Product[] addProductsOnSomeSpace() {
        Product egg = new Product(100, "яицо");
        Product milk = new Product(200, "молоко");
        Product cheese = new Product(300, "сыр");
        Product calf = ActionsProduct.createProduct("телёнок", 450);
    }

    public static void takeProducToBasket(Basket basket, Product[] product) {
        basket.addProductToBasket("яицо");
        System.out.println("basket = " + basket);
    }
}