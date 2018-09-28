package com.sheremet.foxminded.gof.abstractfactor.visitor;

import com.sheremet.foxminded.gof.abstractfactor.products.Topping;
import com.sheremet.foxminded.gof.abstractfactor.products.Visitable;

public interface PizzaVisitor {
    void visit(Visitable.Pizza pizza);

    final class CheesePizzaVisitor implements PizzaVisitor {
        @Override
        public void visit(Visitable.Pizza pizza) {
            pizza.addTopping(Topping.Cheese);
        }
    }

    final class BaconPizzaVisitor implements PizzaVisitor {
        @Override
        public void visit(Visitable.Pizza pizza) {
            pizza.addTopping(Topping.Bacon);
        }
    }

    final class MushroomPizzaVisitor implements PizzaVisitor {
        @Override
        public void visit(Visitable.Pizza pizza) {
            pizza.addTopping(Topping.Mushroom);
        }
    }

    final class PineapplePizzaVisitor implements PizzaVisitor {
        @Override
        public void visit(Visitable.Pizza pizza) {
            pizza.addTopping(Topping.Pineapple);
        }
    }

    final class SeafoodPizzaVisitor implements PizzaVisitor {
        @Override
        public void visit(Visitable.Pizza pizza) {
            pizza.addTopping(Topping.Seafood);
        }
    }
}
