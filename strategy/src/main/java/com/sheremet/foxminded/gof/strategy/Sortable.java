package com.sheremet.foxminded.gof.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public interface Sortable {
    String sort(List<Comparable> data);

    final class RegularSort implements Sortable {
        @Override
        public String sort(List<Comparable> data) {
            return Arrays.toString(new TreeSet(data).toArray());
        }
    }

    final class ReverseSort implements Sortable {
        @Override
        public String sort(List<Comparable> data) {
            return Arrays.toString(new TreeSet(data).descendingSet().toArray());
        }
    }
}
