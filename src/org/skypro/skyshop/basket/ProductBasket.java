    package org.skypro.skyshop.basket;

    import org.skypro.skyshop.product.Product;

    import java.util.*;

    public class ProductBasket {
        private Map<String, List<Product>> productMap;
        private int count = 0;

        public ProductBasket() {
            this.productMap = new HashMap<>();
        }

        public void addProduct(Product product) {
            productMap.computeIfAbsent(product.getName(), k -> new LinkedList<Product>()).add(product);
            //        productsListT.add(product);
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

            System.out.println("Итого: <" + takePay() + ">");
        }

        public int takePay() {
            int sumToPay = 0;

            Iterator<List<Product>> iteratorProductMap = productMap.values().iterator();
            while (iteratorProductMap.hasNext()) {
                List<Product> payProductList = iteratorProductMap.next();

                for (Product element : payProductList) {
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
                List<Product> payProductList = payProductList = iteratorProductMap.next();
                iteratorProductMap.remove();
            }
            count = 0;
        }

                public List<Product> deleteProductFromBasket(String name) {
                    System.out.println("ProductBasket.deleteProductFromBasket");
                    List<Product> removeNameList = new LinkedList<>();
                    checkProduct(name);

                    if (productMap.size() == 0) {
                        System.out.println("«В корзине пусто».");
                        return removeNameList;
                    }
                    if (!checkProductOnBasket(name)) {
                        return removeNameList;
                    }
                    Iterator<Map.Entry<String, List<Product>>> entryIterator = productMap.entrySet().iterator();
                    while (entryIterator.hasNext()) {
                        Map.Entry<String, List<Product>> entry = entryIterator.next();
                        List<Product> productList = entry.getValue();

                        Iterator<Product> productIterator = productList.iterator();
                        while (productIterator.hasNext()) {
                            Product product = productIterator.next();
                            if (product.getName().equalsIgnoreCase(name)) {
                                removeNameList.add(product);
                                productIterator.remove();

                            }
                        }

                        if (productList.isEmpty()) {
                            entryIterator.remove();
                        }
                    }

                    System.out.println("Удалено продуктов: " + removeNameList.size());
                    return removeNameList;
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
