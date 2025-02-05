package org.skypro.skyshop.search;

public class BestResultNotFound extends RuntimeException {
    String search;

    public BestResultNotFound(String search) {
        super();
        this.search = search;
    }

    @Override
    public String toString() {
        return "BestResultNotFound{" +
                "search='" + search + '\'' +
                '}';
    }
}
