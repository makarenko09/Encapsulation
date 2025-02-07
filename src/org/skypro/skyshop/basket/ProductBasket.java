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
            System.out.println(product.isSpecial());
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

//        public int takePay() {
//            int sumToPay = 0;
//
//            Iterator<List<Product>> iteratorProductMap = productMap.values().iterator();
//            while (iteratorProductMap.hasNext()) {
//                List<Product> payProductList = payProductList = iteratorProductMap.next();
//                Iterator<Product> iteratorList = payProductList.iterator();
//
//                while (iteratorList.hasNext()) {
//                    Product element = iteratorList.next();
//                    sumToPay += element.getPrice();
//
//                }
//            }
//            return sumToPay;
//        }
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
                System.out.println("Продукт: '" + name + "' есть в корзине, " + checked);
            } else {
                System.out.println("Продукт: '" + name + "' отсутствует в корзине, " + checked);
            }
        }

        public void clearBasket() {
            Iterator<List<Product>> iteratorProductMap = productMap.values().iterator();
            while (iteratorProductMap.hasNext()) {
                List<Product> payProductList = payProductList = iteratorProductMap.next();
                iteratorProductMap.remove();
            }
                count = 0;
        }
//        public List<Product> deleteProductFromBasket(String name) {
//                            List<Product> removeNameList = new LinkedList<>();
//                            if (productsListT.size() == 0) {
//                                System.out.println("Cписок пуст.");
//                                return removeNameList;
//                            }
//                            Iterator<Product> iterator = productsListT.iterator();
//
//                            while ((iterator.hasNext())) {
//                                Product element = iterator.next();
//                                if (element.getName().equalsIgnoreCase(name)) {
//                                    removeNameList.add(element);
//
//                                    iterator.remove();
//                                    System.out.println("Продукт: " + name + " удален из корзины");
//                                    count--;
//                                }
//                            }
//
//                            return removeNameList;
//                        }

    }

    //        class ProductBasketList extends ProductBasket {
    //            private List<Product> productsListT;
    //
    //            @Override
    //            public boolean equals(Object o) {
    //                if (this == o) return true;
    //                if (o == null || getClass() != o.getClass()) return false;
    //                ProductBasketList that = (ProductBasketList) o;
    //                return Objects.equals(productsListT, that.productsListT);
    //            }
    //
    //            @Override
    //            public int hashCode() {
    //                return Objects.hashCode(productsListT);
    //            }
    //
    //            public ProductBasketList() {
    //                this.productsListT = new LinkedList<>();
    //            }
    //
    //            public void printBasket() {
    //                System.out.println("\nProductBasket.printBasket");
    //
    //                if (productsListT.size() == 0) {
    //                    System.out.println("«В корзине пусто».");
    //                    return;
    //                }
    //                for (Product product : productsListT) {
    //                    System.out.println(product);
    //                }
    //                System.out.println("Итого: <" + takePay() + ">");
    //            }
    //
    //            public List<Product> deleteProductFromBasket(String name) {
    //                List<Product> removeNameList = new LinkedList<>();
    //                if (productsListT.size() == 0) {
    //                    System.out.println("Cписок пуст.");
    //                    return removeNameList;
    //                }
    //                Iterator<Product> iterator = productsListT.iterator();
    //
    //                while ((iterator.hasNext())) {
    //                    Product element = iterator.next();
    //                    if (element.getName().equalsIgnoreCase(name)) {
    //                        removeNameList.add(element);
    //
    //                        iterator.remove();
    //                        System.out.println("Продукт: " + name + " удален из корзины");
    //                        count--;
    //                    }
    //                }
    //
    //                return removeNameList;
    //            }
    //
    //            public int takePay() {
    //                int sumToPay = 0;
    //                for (Product product : productsListT) {
    //                    if (product != null) {
    //                        sumToPay += product.getPrice();
    //                    }
    //                }
    //                return sumToPay;
    //            }
    //
    //            public boolean checkProductOnBasket(String name) {
    //                if (name == null) {
    //                    throw new IllegalArgumentException("Имя продукта не может быть null");
    //                }
    //
    //                for (Product product : productsListT) {
    //                    if (product != null && product.getName().equalsIgnoreCase(name)) {
    //                        return true;
    //                    }
    //                }
    //                return false;
    //            }
    //
    //            public void checkProduct(String name) {
    //                boolean checked = checkProductOnBasket(name);
    //                if (checked) {
    //                    System.out.println("Продукт: '" + name + "' есть в корзине, " + checked);
    //                } else {
    //                    System.out.println("Продукт: '" + name + "' отсутствует в корзине, " + checked);
    //                }
    //            }
    //
    //            public void clearBasket() {
    //
    //                productsListT.removeAll(productsListT);
    //                count = 0;
    //            }
    //
    //            @Override
    //            public String toString() {
    //                return "ProductBasket{" +
    //                        "products=" + productsListT +
    //                        '}';
    //            }
    //        }
    //
    //    }