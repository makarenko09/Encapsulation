package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

public class Article implements Searchable {
    private String name;
    private String title;

    public Article(String name, String title) {
        this.name = name;
        this.title = title;
    }

    @Override
    public String searchTerm(String nameOrTitle) {
        if (nameOrTitle == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }
        return name + " " + " \n"
                + title;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return name +"\n"+ title;
    }
}