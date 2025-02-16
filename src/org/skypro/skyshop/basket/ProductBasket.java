package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> productMap;
    private int count = 0;

    public ProductBasket() {
        productMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        productMap.computeIfAbsent(product.getName(), k -> new LinkedList<Product>()).add(product);

        count++;
        System.out.println("Номер продукта: " + count + " - продукт добавлен : " + product);
        System.out.println("Особый продукт: return " + product.isSpecial());
    }

    public void printBasket() {
        System.out.println("\nProductBasket.printBasket");

        if (productMap.size() == 0) {
            System.out.println("«В корзине пусто».");
            return;
        }

        System.out.println(productMap);

        int countSpecial = 0;
        for (List<Product> productList : productMap.values()) {

            for (Product product : productList) {
                if (product != null && product.isSpecial()) {
                    countSpecial++;
                }
            }

        }
        System.out.println("Итого: <" + takePay() + ">");
        System.out.println("Количество специальных товаров в корзине: " + countSpecial);
    }

    public int takePay() {
        int sumToPay = 0;

        for (List<Product> productList : productMap.values()) {
            for (Product element : productList) {
                sumToPay += element.getPrice();

            }
        }
        return sumToPay;
    }

    public boolean checkProductOnBasket(String name) {
        for (List<Product> productList : productMap.values()) {
            for (Product product : productList) {
                if (product != null && product.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void checkProduct(String name) {
        boolean checked = checkProductOnBasket(name);
        if (checked) {
            System.out.println("Продукт: '" + name + "' есть в корзине, return " + checked);
        } else {
            System.out.println("Продукт: '" + name + "' отсутствует в корзине, return " + checked);
        }
    }

    public void clearBasket() {
        System.out.println("ProductBasket.clearBasket");
        Iterator<List<Product>> iteratorProductMap = productMap.values().iterator();
        while (iteratorProductMap.hasNext()) {
            List<Product> payProductList = iteratorProductMap.next();
            iteratorProductMap.remove();
        }
        count = 0;
    }

    public List<Product> deleteProductFromBasket(String name) {
        System.out.println("ProductBasket.deleteProductFromBasket");
        List<Product> removeNameList = new LinkedList<>();
        if (productMap.size() == 0) {
            System.out.println("«В корзине пусто».");
            return removeNameList;
        }
        if (!checkProductOnBasket(name)) {
            checkProduct(name);
            return removeNameList;
        } else {

            return productMap.remove(name);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket basket = (ProductBasket) o;
        return Objects.equals(productMap, basket.productMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productMap);
    }
}
