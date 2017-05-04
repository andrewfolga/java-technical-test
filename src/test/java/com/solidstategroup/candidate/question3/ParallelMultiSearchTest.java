package com.solidstategroup.candidate.question3;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by andrzejfolga on 04/05/2017.
 */
public class ParallelMultiSearchTest {

    private ParallelMultiSearch parallelMultiSearch = new ParallelMultiSearch();

    @Test
    public void shouldReturnResultInParallel() throws Exception {
        List<Search> searches = new ArrayList<>();
        searches.add(new GoogleSearch());
        searches.add(new YahooSearch());
        parallelMultiSearch.setSearches(searches);

        List<String> result = parallelMultiSearch.search("London");

        List<String> expected = Arrays.asList("BigBen", "Parliament", "Tate", "Waterloo", "London Eye", "Soho");
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReturnOnlyOneResultIfOtherFails() throws Exception {
        List<Search> searches = new ArrayList<>();
        searches.add(new GoogleSearch());
        searches.add(new FailingSearch());
        parallelMultiSearch.setSearches(searches);

        List<String> result = parallelMultiSearch.search("London");

        List<String> expected = Arrays.asList("BigBen", "Parliament", "Tate", "Waterloo");
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReturnEmptyResultIfNoSearches() throws Exception {
        parallelMultiSearch.setSearches(Collections.emptyList());
        List<String> result = parallelMultiSearch.search("London");

        assertThat(result, is(Collections.emptyList()));
    }

    @Test
    public void shouldReturnEmptyResultIfNullSearches() throws Exception {
        List<String> result = parallelMultiSearch.search("London");

        assertThat(result, is(Collections.emptyList()));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThowExceptionIfNoValue() throws Exception {
        parallelMultiSearch.search(null);
    }

    class GoogleSearch implements Search {

        private final List<String> searchResults = Arrays.asList("BigBen", "Parliament", "Tate", "Waterloo");

        @Override
        public List<String> search(String query) throws IOException, InterruptedException {
            Thread.sleep(1000l);
            return searchResults;
        }
    }

    class YahooSearch implements Search {

        private final List<String> searchResults = Arrays.asList("Parliament", "Tate", "Waterloo", "London Eye", "Soho");

        @Override
        public List<String> search(String query) throws IOException, InterruptedException {
            Thread.sleep(2000l);
            return searchResults;
        }
    }

    class FailingSearch implements Search {

        private final List<String> searchResults = Arrays.asList("Parliament", "Tate", "Waterloo", "London Eye", "Soho");

        @Override
        public List<String> search(String query) throws IOException, InterruptedException {
            throw new IOException();
        }
    }
}