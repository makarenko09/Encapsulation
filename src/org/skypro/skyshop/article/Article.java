package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private String name;
    private String title;

    public Article(String name, String title) {
        this.name = name;
        this.title = title;
        if (title == null || name == null) {
            System.out.println("Article.Exc.Null.toString{" +
                    "name=" + name + ", title= " + title + '}');
            throw new IllegalArgumentException("Имя и/или содержание статьи не может быть null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article)) return false;
        return Objects.equals(name, ((Article) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String getSearchTerm() {

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
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return name +"\n"+ title;
    }
}