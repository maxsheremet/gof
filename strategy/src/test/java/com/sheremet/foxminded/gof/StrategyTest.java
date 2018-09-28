package com.sheremet.foxminded.gof;

import com.sheremet.foxminded.gof.strategy.DataWrapper;
import com.sheremet.foxminded.gof.strategy.Sortable;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class StrategyTest {

    private final Sortable regular = new Sortable.RegularSort();
    private final Sortable reverse = new Sortable.ReverseSort();

    private final DataWrapper integers = new DataWrapper(asList(2, 3, 4, 1));
    private final DataWrapper strings = new DataWrapper(asList("b", "c", "d", "a"));

    @Test
    public void test() {
        assertThat(integers.sortTheData(regular), is("[1, 2, 3, 4]"));
        assertThat(integers.sortTheData(reverse), is("[4, 3, 2, 1]"));
        assertThat(strings.sortTheData(regular), is("[a, b, c, d]"));
        assertThat(strings.sortTheData(reverse), is("[d, c, b, a]"));
    }
}
