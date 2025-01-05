package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class Basket {
    private Product[] basket;
    private Product product;
    private int idCounter = 1;
    private int id;

    public Basket(int quantity) {
        basket = new Product[quantity];
    }

    public void addProductToBasket(String nameWhose) {
        System.out.println("Basket.addProductToBasket");
        if (nameWhose == product.getName()) {
            basket[id] = product;
        }
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + Arrays.toString(basket) +
                '}';
    }
}