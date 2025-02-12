package org.skypro.skyshop.search;
import java.util.*;

public class SearchEngine {
    private List<Searchable> searchablesScroll;

    public SearchEngine() {
        searchablesScroll = new LinkedList<>();
    }

    public Map<String, List<Searchable>> search(String queryRequest) {
        Map<String, List<Searchable>> searchablesMap = new LinkedHashMap<>();
        if (searchablesScroll.size() == 0) {
            System.out.println("Нет товаров доступных для поиска.");
            return searchablesMap;
        }
        for (Searchable searchable : searchablesScroll) {
                if (searchable.getSearchTerm().equalsIgnoreCase(queryRequest)) {
                    System.out.println("Поисковый запрос: '" + queryRequest + "' найден");
                    searchablesMap.computeIfAbsent(searchable.getSearchTerm(), k -> new ArrayList<>()).add(searchable);
                }
            }
        if (searchablesMap.size() == 0) {
            System.out.println("Поисковый запрос: '" + queryRequest + "' не найден");
        }
        return searchablesMap;
    }

    public void add(Searchable searchable) {
        searchablesScroll.add(searchable);
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
        Map<String, List<Searchable>> searchablesMap = new LinkedHashMap<>(search(search));
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
        if (o == null || getClass() != o.getClass()) return false;
        SearchEngine that = (SearchEngine) o;
        return Objects.equals(searchablesScroll, that.searchablesScroll);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(searchablesScroll);
    }
}
