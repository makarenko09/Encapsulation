package org.skypro.skyshop.search;

public interface Searchable {

    String searchTerm();

    default String getStringRepresentation() {
        return this.getClass().getSimpleName() + "-" + getContentType();
    }

    String getContentType();

    }
