package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CompositeSearchStrategy implements SearchStrategy {
    private final Collection<SearchStrategy> searchStrategies = new ArrayList<>();

    public CompositeSearchStrategy(SearchStrategy... searchStrategies) {
        this.searchStrategies.addAll(Arrays.asList(searchStrategies));
    }

    @Override
    public boolean filter(Order order) {
        boolean result = true;
        for (SearchStrategy searchStrategy : searchStrategies) {
            result = result && searchStrategy.filter(order);
        }
        return result;
    }
}
