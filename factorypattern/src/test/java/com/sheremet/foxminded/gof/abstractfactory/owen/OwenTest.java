package com.sheremet.foxminded.gof.abstractfactory.owen;

import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OwenTest {

    private final Owen owen = new Owen();

    @Test
    public void testToast() {
        assertThat(owen.bake("toast"), is("Toast takes 15 to bake."));
    }

    @Test
    public void testPizza() {
        assertThat(owen.bake("pizza"), is("Pie takes 30 mins to bake."));
    }

    @Test
    public void testPie() {
        assertThat(owen.bake("pie"), is("Pie takes 60 mins to bake."));
    }

    @Test(expected = RuntimeException.class)
    public void testSomething() {
        owen.bake(UUID.randomUUID().toString());
    }

}
