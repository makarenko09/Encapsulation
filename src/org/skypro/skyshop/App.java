package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    private static final int fixIndexValueOfMethodToAddProduct = 600;
    private static int coast = 0;
    public static void main(String[] args) {
//        taskOne();
//        startDemo();
//        taskTwo();
        taskThree();

    }

    private static void taskThree() {
        System.out.println("#####\n#####\n#####\n#####\n#####" +
                "\n#####\n!Создайте один объект типа SearchEngine " +
                "и добавьте в него все товары, которые создаются для проверки других методов....");
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(new SimpleProduct(100, "яицо"));
        searchEngine.add(new SimpleProduct(146, "milk"));
        searchEngine.add(new SimpleProduct(15_000, "МОЁТ"));
        searchEngine.add(new SimpleProduct(200, "молоко"));
        searchEngine.add(new SimpleProduct(300, "сыр"));
        searchEngine.add(new SimpleProduct(450, "телёнок"));
        searchEngine.add(new SimpleProduct(500, "печенье"));
        searchEngine.add(new DiscountedProduct("Килька в томатном соусе", 150, 15));
        searchEngine.add(new DiscountedProduct("Икра красная", 2700, 26));
        searchEngine.add(new SimpleProduct(50, "Капуста зеленая"));
        searchEngine.add(new SimpleProduct(280, "Перец острый-Чили"));
        searchEngine.add(new FixPriceProduct("Банка пива ж/б 0.5л. «ОХОТА КРЕПКАЯ»"));
        searchEngine.add(new FixPriceProduct("Лимонад Макеевский с/б 0.45л. «Клюква»"));
        searchEngine.add(new DiscountedProduct("Фигурка Альтаира", 18_000000, 99));
        searchEngine.add(new Article("Искусственный интеллект в медицине", "Искусственный интеллект (ИИ) революционизирует сферу здравоохранения, предоставляя новые инструменты для диагностики, лечения и прогнозирования заболеваний. Данная статья рассматривает текущие применения ИИ в медицине и потенциальные перспективы его развития."));
        searchEngine.add(new Article("Квантовые компьютеры: будущее вычислений", "Квантовые компьютеры обещают произвести революцию в мире вычислений, предлагая беспрецедентную вычислительную мощность для решения сложных задач. В этой статье мы исследуем принципы работы квантовых компьютеров и их потенциальное влияние на различные области науки и технологий."));
        searchEngine.add(new Article("Глобальное потепление: вызовы и решения", "Глобальное потепление представляет собой одну из наиболее серьезных угроз для нашей планеты. Эта статья анализирует текущие тенденции изменения климата, их последствия и предлагает возможные стратегии по смягчению и адаптации к этим изменениям."));
        searchEngine.add(new Article("Нейропластичность: как мозг меняется в течение жизни", "Нейропластичность - удивительная способность мозга изменяться и адаптироваться на протяжении всей жизни. В этой статье мы рассмотрим механизмы нейропластичности и их значение для обучения, восстановления после травм и общего когнитивного здоровья."));
        searchEngine.add(new Article("Блокчейн: за пределами криптовалют", "Хотя блокчейн наиболее известен как технология, лежащая в основе криптовалют, его потенциал выходит далеко за рамки финансового сектора. Эта статья исследует инновационные применения блокчейна в различных отраслях, от управления цепочками поставок до защиты авторских прав."));
        searchEngine.add(new Article("Генная инженерия: этические вопросы и перспективы", "Генная инженерия открывает беспрецедентные возможности для лечения заболеваний и улучшения качества жизни. Однако она также поднимает серьезные этические вопросы. В этой статье мы рассмотрим текущее состояние генной инженерии, ее потенциальные применения и связанные с ней этические дилеммы."));
        searchEngine.add(new Article("Возобновляемые источники энергии: путь к устойчивому будущему", "Переход к возобновляемым источникам энергии является ключевым фактором в борьбе с изменением климата и обеспечении устойчивого развития. Эта статья анализирует текущее состояние и перспективы развития различных видов возобновляемой энергии, включая солнечную, ветровую и геотермальную."));
        searchEngine.add(new Article("Психология социальных сетей: влияние на общество", "Социальные сети стали неотъемлемой частью нашей жизни, но их влияние на психологическое здоровье и социальные взаимодействия остается предметом интенсивных исследований. В этой статье мы рассмотрим как позитивные, так и негативные аспекты использования социальных сетей."));
        searchEngine.add(new Article("Космический туризм: новая эра исследования космоса", "Космический туризм перестает быть научной фантастикой и становится реальностью. Эта статья исследует текущее состояние индустрии космического туризма, технологические достижения, делающие его возможным, и потенциальные последствия для будущего космических исследований."));
        searchEngine.add(new Article("Биомимикрия: инновации, вдохновленные природой", "Биомимикрия - это подход к инновациям, который ищет устойчивые решения, подражая природным образцам и стратегиям. В этой статье мы рассмотрим, как принципы биомимикрии применяются в различных областях, от архитектуры до робототехники, и как это может помочь в решении глобальных проблем."));

        System.out.println("Search results :");
        System.out.println(Arrays.toString(searchEngine.search("яицо")));
        System.out.println(Arrays.toString(searchEngine.search("Капуста зеленая")));
        System.out.println(Arrays.toString(searchEngine.search("Икра")));
        System.out.println(Arrays.toString(searchEngine.search("milk")));
        System.out.println(Arrays.toString(searchEngine.search("интеллект")));
    }

    private static void taskTwo() {
        System.out.println("#####\n#####\n#####\n#####\n#####\n#####\n!Создайте в методе несколько товаров специальных типов вместо " +
                "SimpleProduct...");
        Product[] productsDemo = new Product[10];
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

    private static void startDemo() {
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
    }

    private static void taskOne() {
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