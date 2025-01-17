package org.skypro.skyshop;


public interface Searchable {

    String searchTerm(String request);

    default void getStringRepresentation(Object object) {
        System.out.println("имя " + searchable(object) + "-объекта — тип " + getContentType(object) + "-объекта");
    }

    default String getContentType(Object types) {
        return String.valueOf(types.getClass().getSimpleName()).toUpperCase();
    }

    private String searchable(Object object) {
        return String.valueOf(getClass());
    }
}
