package com.solidstategroup.candidate.question3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Execute {@link MultiSearch} in parallel for speed.
 */
public class ParallelMultiSearch extends MultiSearch {

    @Override
    public List<String> search(String query) throws IOException {
        if (query == null) throw new NullPointerException("Query has to be a value!");

        if (getSearches() == null || getSearches().isEmpty()) return Collections.emptyList();

        List<String> allResults = getSearches().parallelStream().map(s -> {
            List<String> results = new ArrayList<>();
            try {
                results.addAll(s.search(query));
            } catch (Exception exp) {
                System.out.println("Something went wrong! " + exp);
            }
            return results;
        }).flatMap(e -> e.stream()).distinct().collect(toList());

        return allResults;
    }


}
