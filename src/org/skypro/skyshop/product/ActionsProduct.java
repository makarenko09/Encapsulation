package org.skypro.skyshop.product;

public class ActionsProduct {
    private Product product;

    public static Product createProduct(String name, int price) {
        {
            System.out.println("ActionsProduct.createProduct");
            Product one = new Product(price, name);
            System.out.println(one + " создан, в наличии");
            return one;
        }
    }


}

