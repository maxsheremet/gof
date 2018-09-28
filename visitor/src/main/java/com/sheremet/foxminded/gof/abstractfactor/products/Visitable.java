package com.sheremet.foxminded.gof.abstractfactor.products;

import com.sheremet.foxminded.gof.abstractfactor.visitor.PizzaVisitor;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public interface Visitable {
    void accept(PizzaVisitor visitor);

    final class Pizza implements Visitable {

        private final List<Topping> ingredients = new ArrayList<>();

        public void addTopping(Topping topping) {
            this.ingredients.add(topping);
        }

        @Override
        public String toString() {
            return "Added toppings : " + ingredients.stream().map(Topping::name).collect(joining(","));
        }

        @Override
        public void accept(PizzaVisitor visitor) {
            visitor.visit(this);
        }
    }
}
