package org.skypro.skyshop.search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchablesListT;
    private static final int MAX_RESPONSE = 5;
    private static final int MAX_SEARHOFRESPONSE = 6_000;
    private int sizeArrayOfAddSearchable = 0;

    public SearchEngine() {
        searchablesListT = new LinkedList<>();
    }

    public void add(Searchable searchable) {
        searchablesListT.add(searchable);
    }

    public List<Searchable> search(String queryRequest) {
        if (searchablesListT.size() == 0) {
            System.out.println("Нет товаров доступных для поиска.");
            return searchablesListT;
        }

        List<Searchable> searchList = new LinkedList<>();
        Iterator<Searchable> iterator = searchablesListT.iterator();
        while ((iterator.hasNext())) {
            Searchable element = iterator.next();
            if (element.getSearchTerm().equalsIgnoreCase(queryRequest)) {
                searchList.add(element);

                System.out.println("Поисковый запрос: '" + queryRequest + "' найден");
            }
        }
        if (searchList.size() == 0) {

                System.out.println("Поисковый запрос: '" + queryRequest + "' не найден");

        }
        return searchList;
    }

    private int resultFullyFound(String addedlyOrigOfSearch, String strOfSearch) {
        int x = addedlyOrigOfSearch.indexOf(strOfSearch);
        if (x != -1) {
            return x;
        }
        return 0;
    }

    public Searchable searchResults(String search) {
        System.out.println("SearchEngine.searchResults");
        int score = 0;
        int maxFound = 0;
        Searchable bestResult = null;
        for (Searchable searchable : searchablesListT) {
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

}
