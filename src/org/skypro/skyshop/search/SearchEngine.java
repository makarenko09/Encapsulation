package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchables;
    private static final int MAX_RESPONSE = 5;
    private static final int MAX_SEARHOFRESPONSE = 6_000;
    private int sizeArrayOfAddSearchable = 0;

    public SearchEngine() {
        searchables = new Searchable[MAX_SEARHOFRESPONSE];
    }

    public Searchable searchResults(String search) {
        System.out.println("SearchEngine.searchResults");
        int score = 0;
        int maxFound = 0;
        Searchable bestResult = null;
        for (Searchable searchable : searchables) {
            try {
                String strOrig = searchable.getSearchTerm().toLowerCase();
                String subStringOrig = search.toLowerCase();
                score = resultFullyFound(strOrig, subStringOrig);
                if (score > maxFound) {
                    maxFound = score;
                    bestResult = searchable;
                }
            } catch (NullPointerException ignored) {
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound(search);
        }
        return bestResult;
    }

    private int resultFullyFound(String addedlyOrigOfSearch, String strOfSearch) {
        int x = addedlyOrigOfSearch.indexOf(strOfSearch);
        if (x != -1) {
            return x;
        }
        return 0;
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
            if (searchable != null && searchable.getSearchTerm().contains(queryRequest)) {
                results[count++] = searchable;
            }
            if (count == MAX_RESPONSE) break;
        }
        return results;
    }
}

