package com.sheremet.foxminded.gof.command;

import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class CommandInvokerTest {

    @BeforeClass
    public static void init() {
        BasicConfigurator.configure();
    }

    @Test
    public void testAddAndRemoveInvoker() {
        Invoker addAndRemoveInvoker = new Invoker()
                .addCommand(new PizzaCommand.CheeseCommand())
                .addCommand(new PizzaCommand.BaconCommand())
                .addCommand(new PizzaCommand.PineappleCommand())
                .addCommand(new PizzaCommand.MushroomsCommand())
                .addCommand(new PizzaCommand.SeafoodCommand())
                .undoCommand(new PizzaCommand.CheeseCommand())
                .undoCommand(new PizzaCommand.SeafoodCommand());

        assertThat(addAndRemoveInvoker.invokeAllCommands(new CommandReceiver()),
                is("Baking pizza from : bacon,mushrooms,pineapple"));
    }

    @Test
    public void testAddInvoker() {
        Invoker addInvoker = new Invoker()
                .addCommand(new PizzaCommand.CheeseCommand())
                .addCommand(new PizzaCommand.BaconCommand())
                .addCommand(new PizzaCommand.PineappleCommand())
                .addCommand(new PizzaCommand.MushroomsCommand())
                .addCommand(new PizzaCommand.SeafoodCommand());

        assertThat(addInvoker.invokeAllCommands(new CommandReceiver()),
                is("Baking pizza from : bacon,cheese,mushrooms,pineapple,seafood"));
    }
}
