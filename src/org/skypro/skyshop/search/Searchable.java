package org.skypro.skyshop.search;

public interface Searchable {

    String searchTerm(String request);

    default String getStringRepresentation() {
        return this.getClass().getSimpleName() + "-" + searchable();
    }

    String getContentType();

    String searchable();

}
