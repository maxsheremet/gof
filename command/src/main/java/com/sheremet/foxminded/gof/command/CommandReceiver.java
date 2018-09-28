package com.sheremet.foxminded.gof.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class CommandReceiver {
    private final List<String> ingredients = new ArrayList<>();

    public void addIngredientAction(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredientAction(String ingredient) {
        this.ingredients.remove(ingredient);
    }

    public String prepare(Collection<PizzaCommand> added, Collection<PizzaCommand> undone) {
        added.forEach(command -> command.addIngredient(this));
        undone.forEach(pizzaCommand -> pizzaCommand.removeIngredient(this));
        return "Baking pizza from : " + String.join(",", ingredients);
    }
}
