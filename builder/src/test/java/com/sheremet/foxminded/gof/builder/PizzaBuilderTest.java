package com.sheremet.foxminded.gof.builder;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class PizzaBuilderTest {
    @Test
    public void testMeatFeastPizzaBuilder() {
        final PizzaDTO meatFeast = new PizzaDTO.MeatFeastPizzaBuilder()
                .cheese(0)
                .bacon(100)
                .pineapple(0)
                .mushrooms(10)
                .seafood(100)
                .build();
        assertThat(meatFeast.toString(), is(new StringBuilder("PizzaDTO{")
                .append("cheese=MeatFeastPizza requires 0 gram of cheese, ")
                .append("bacon=MeatFeastPizza requires 100 gram of bacon, ")
                .append("pineapple=MeatFeastPizza requires 0 gram of pineapple, ")
                .append("mushrooms=MeatFeastPizza requires 10 gram of mushrooms, ")
                .append("seafood=MeatFeastPizza requires 100 gram of seafood")
                .append("}")
                .toString()));
    }

    @Test
    public void testHawaiianPizzaBuilder() {
        final PizzaDTO meatFeast = new PizzaDTO.HawaiianPizzaBuilder()
                .cheese(100)
                .bacon(0)
                .pineapple(100)
                .mushrooms(10)
                .seafood(50)
                .build();
        assertThat(meatFeast.toString(), is(new StringBuilder("PizzaDTO{")
                .append("cheese=HawaiianPizza requires 100 gram of cheese, ")
                .append("bacon=HawaiianPizza requires 0 gram of bacon, ")
                .append("pineapple=HawaiianPizza requires 100 gram of pineapple, ")
                .append("mushrooms=HawaiianPizza requires 10 gram of mushrooms, ")
                .append("seafood=HawaiianPizza requires 50 gram of seafood")
                .append("}")
                .toString()));
    }
}
