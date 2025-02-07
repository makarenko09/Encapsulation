package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private Map<String, List<Searchable>> searchablesMap;

    public SearchEngine() {
        searchablesMap = new LinkedHashMap<>();
    }

    public Map<String, List<Searchable>> search(String queryRequest) {
        Map<String, List<Searchable>> result = new LinkedHashMap<>();
        if (searchablesMap.size() == 0) {
            System.out.println("Нет товаров доступных для поиска.");
            return result;
        }

        Iterator<Map.Entry<String, List<Searchable>>> mapIterator = searchablesMap.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, List<Searchable>> entry = mapIterator.next();
            String searchName = entry.getKey();
            List<Searchable> searchables = entry.getValue();

            List<Searchable> matchingSearchables = new ArrayList<>();

            Iterator<Searchable> listIterator = searchables.iterator();
            while (listIterator.hasNext()) {
                Searchable searchable = listIterator.next();
                if (searchable.getSearchTerm().equalsIgnoreCase(queryRequest)) {
                    matchingSearchables.add(searchable);

                }
            }

            if (!(matchingSearchables.isEmpty())) {
                result.put(searchName, matchingSearchables);
                System.out.println("Поисковый запрос: '" + queryRequest + "' найден в " + searchName);
            }
        }

        if (result.isEmpty()) {
            System.out.println("Поисковый запрос: '" + queryRequest + "' не найден");
        }

        return result;
    }

    public void add(Searchable searchable) {
        searchablesMap.computeIfAbsent(searchable.getSearchTerm(), k -> new ArrayList<>()).add(searchable);
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
        for (Map.Entry<String, List<Searchable>> entry : searchablesMap.entrySet()) {

            List<Searchable> searchables = entry.getValue();
            for (Searchable searchable : searchables) {

                String strOrig = searchable.getSearchTerm().toLowerCase();
                String subStringOrig = search.toLowerCase();
                score = resultFullyFound(strOrig, subStringOrig);
                if (score > maxFound) {
                    maxFound = score;
                    bestResult = searchable;
                }

            }

        }
        if (bestResult == null) {
            throw new BestResultNotFound(search);
        }
        return bestResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchEngine that = (SearchEngine) o;
        return Objects.equals(searchablesMap, that.searchablesMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(searchablesMap);
    }
}
