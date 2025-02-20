package org.skypro.skyshop.search;
import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchablesScroll;

    public SearchEngine() {
        searchablesScroll = new HashSet<>();
    }

    public Set<Searchable> search(String queryRequest) {

        if (searchablesScroll.size() == 0) {
            System.out.println("Нет товаров доступных для поиска.");
        }

        if (queryRequest.isBlank()) {
            System.out.println("SearchEngine.getSpaceInQueryRequest");
            System.out.println("SearchTerm.Exc.Value.toString{" +
                    "Term='" + queryRequest + "'}");
            throw new IllegalArgumentException("Не должно быть пробелов в названии запроса");
        }
        Set<Searchable> searchablesSet = searchablesScroll.stream()
                .filter(searchable -> searchable.getSearchTerm().contains(queryRequest))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchComparator())));

//                Set<Searchable> searchablesSet = new TreeSet<Searchable>(new SearchComparator());
//                searchablesScroll.stream()
//                .map(Searchable::getSearchTerm)
//                .filter(name -> name.contains(queryRequest))
//                        .sorted(new SearchComparator())
//                .collect(Collectors.toCollection(searchablesSet));

        if (searchablesSet.size() == 0) {
            System.out.println("Поисковый запрос: '" + queryRequest + "' не найден");

        } else {
            System.out.println("Поисковый запрос: '" + queryRequest + "' найден");
        }
        return searchablesSet;
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
        Set<Searchable> searchablesSet = new HashSet<>(search(search));
        Searchable bestResult = null;
        for (Searchable searchable : searchablesSet) {

                String strOrig = searchable.getSearchTerm().toLowerCase();
                String subStringOrig = search.toLowerCase();
                score = resultFullyFound(strOrig, subStringOrig);
                if (score > maxFound) {
                    maxFound = score;
                    bestResult = searchable;
                }

            }

        if (bestResult == null) {
            throw new BestResultNotFound(search);
        }
        return bestResult;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SearchEngine)) return false;
        return Objects.equals(searchablesScroll, ((SearchEngine) o));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(searchablesScroll);
    }
}

class SearchComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        String term1 = o1.getSearchTerm().toLowerCase();
        String term2 = o2.getSearchTerm().toLowerCase();
        int resultOfCompare = Integer.compare(term2.length(), term1.length());
        if (resultOfCompare == 0) return term2.compareTo(term1);
        return resultOfCompare;
    }
}
