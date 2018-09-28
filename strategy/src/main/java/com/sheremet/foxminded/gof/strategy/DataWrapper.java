package com.sheremet.foxminded.gof.strategy;

import java.util.List;

public final class DataWrapper {
    private final List<Comparable> data;

    public DataWrapper(List<Comparable> data) {
        this.data = data;
    }

    public String sortTheData(Sortable sortable) {
        return sortable.sort(data);
    }
}
