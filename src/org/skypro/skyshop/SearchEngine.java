package org.skypro.skyshop;

public class SearchEngine {
    private Searchable[] searchables;
    private static final int MAX_RESPONSE = 5;
    private static final int MAX_SEARHOFRESPONSE = 6_000;
    private int sizeArrayOfAddSearchable = 0;

    public SearchEngine() {
        searchables = new Searchable[MAX_SEARHOFRESPONSE];
    }

    public void add(Searchable searchable) {
        if (sizeArrayOfAddSearchable < searchables.length) {
            this.searchables[sizeArrayOfAddSearchable++] = searchable;
        }
    }

    public Searchable[] search(String queryRequest) {
        Searchable[] results = new Searchable[MAX_RESPONSE];
        int count = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm(queryRequest).contains(queryRequest)) {
                results[count++] = searchable;
            }
            if (count == MAX_RESPONSE) break;
        }
        return results;
    }
}

