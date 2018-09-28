package com.sheremet.foxminded.gof.state;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class OwenImplTest {

    private final Owen owen = new Owen.OwenImpl("PizzaOwen");

    /**
     * Implementing the state pattern using an owen with cold/ready/burning states when baking a meal.
     */
    @Test
    public void testOwen() {
        //owen is cold
        assertThat(owen.prepareTheMeal("Pizza"), is("Cold owen cannot prepare Pizza."));
        assertThat(owen.triggerTheAlarm(), is("Cold owen cannot be overheated."));
        assertThat(owen.powerUp(), is("PizzaOwen ready to be used."));
        //owen is ready
        assertThat(owen.powerUp(), is("PizzaOwen is already powered up."));
        assertThat(owen.triggerTheAlarm(), is("Ready owen is not overheated."));
        assertThat(owen.prepareTheMeal("Pizza"), is("Preparing the meal from Pizza."));
        //owen is overheated
        assertThat(owen.powerUp(), is("PizzaOwen is already powered up and overheating."));
        assertThat(owen.prepareTheMeal("Pizza"), is("Pizza is burning, consider removing."));
        assertThat(owen.triggerTheAlarm(), is("PizzaOwen needs to cool down."));
    }

}
