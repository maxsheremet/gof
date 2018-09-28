package com.sheremet.foxminded.gof.command;

import org.apache.log4j.Logger;

public interface PizzaCommand {

    Logger LOG = Logger.getLogger(PizzaCommand.class);

    String getName();

    void addIngredient(CommandReceiver commandReceiver);

    void removeIngredient(CommandReceiver commandReceiver);

    final class CheeseCommand implements PizzaCommand {

        @Override
        public String getName() {
            return "Cheese";
        }

        @Override
        public void addIngredient(CommandReceiver commandReceiver) {
            LOG.info("Adding cheese to the pizza");
            commandReceiver.addIngredientAction("cheese");
        }

        @Override
        public void removeIngredient(CommandReceiver commandReceiver) {
            LOG.info("Removing cheese to the pizza");
            commandReceiver.removeIngredientAction("cheese");
        }
    }

    final class BaconCommand implements PizzaCommand {

        @Override
        public String getName() {
            return "Bacon";
        }

        @Override
        public void addIngredient(CommandReceiver commandReceiver) {
            LOG.info("Adding bacon to the pizza");
            commandReceiver.addIngredientAction("bacon");
        }

        @Override
        public void removeIngredient(CommandReceiver commandReceiver) {
            LOG.info("Removeing bacon to the pizza");
            commandReceiver.removeIngredientAction("bacon");
        }
    }

    final class PineappleCommand implements PizzaCommand {
        @Override
        public String getName() {
            return "Pineapple";
        }

        @Override
        public void addIngredient(CommandReceiver commandReceiver) {
            LOG.info("Adding pineapple to the pizza");
            commandReceiver.addIngredientAction("pineapple");
        }

        @Override
        public void removeIngredient(CommandReceiver commandReceiver) {
            LOG.info("Adding pineapple to the pizza");
            commandReceiver.removeIngredientAction("pineapple");
        }
    }

    final class MushroomsCommand implements PizzaCommand {

        @Override
        public String getName() {
            return "Mushroom";
        }

        @Override
        public void addIngredient(CommandReceiver commandReceiver) {
            LOG.info("Adding mushrooms to the pizza");
            commandReceiver.addIngredientAction("mushrooms");
        }

        @Override
        public void removeIngredient(CommandReceiver commandReceiver) {
            LOG.info("Adding mushrooms to the pizza");
            commandReceiver.removeIngredientAction("mushrooms");
        }

    }

    final class SeafoodCommand implements PizzaCommand {

        @Override
        public String getName() {
            return "Seafood";
        }

        @Override
        public void addIngredient(CommandReceiver commandReceiver) {
            LOG.info("Adding seafood to the pizza");
            commandReceiver.addIngredientAction("seafood");
        }

        @Override
        public void removeIngredient(CommandReceiver commandReceiver) {
            LOG.info("Adding seafood to the pizza");
            commandReceiver.removeIngredientAction("seafood");
        }
    }
}
