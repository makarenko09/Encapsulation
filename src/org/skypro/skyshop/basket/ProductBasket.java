package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.IntStream;

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
        } else {
            productMap.values().stream().flatMap(Collection::stream).forEach(System.out::println);
            getSpecialCount();
            System.out.println("Количество специальных товаров в корзине: " + getSpecialCount());
            System.out.println("Итого: <" + takePay() + ">");
        }
    }

    private int getSpecialCount() {
        return (int) productMap.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
    }

    public int takePay() {
        return productMap.values().stream()
                .flatMap(Collection::stream)
                .map(Product::getPrice)
                .mapToInt(i -> i).sum();
    }

    public boolean checkProductOnBasket(String name) {
        return productMap.values().stream().flatMap(Collection::stream).filter(Objects::nonNull).map(Product::getName)
                .map(x -> x.equalsIgnoreCase(name))
                .findFirst().orElse(false);
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
