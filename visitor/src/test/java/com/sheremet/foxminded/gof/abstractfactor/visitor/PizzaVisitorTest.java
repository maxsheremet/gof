package com.sheremet.foxminded.gof.abstractfactor.visitor;

import com.sheremet.foxminded.gof.abstractfactor.products.Visitable;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class PizzaVisitorTest {

    @Test
    public void testPizzaVisitor() {
        Visitable.Pizza pizza = new Visitable.Pizza();

        pizza.accept(new PizzaVisitor.CheesePizzaVisitor());
        pizza.accept(new PizzaVisitor.BaconPizzaVisitor());
        pizza.accept(new PizzaVisitor.MushroomPizzaVisitor());
        pizza.accept(new PizzaVisitor.PineapplePizzaVisitor());
        pizza.accept(new PizzaVisitor.SeafoodPizzaVisitor());

        assertThat(pizza.toString(),
                is("Added toppings : Cheese,Bacon,Mushroom,Pineapple,Seafood"));
    }

}
