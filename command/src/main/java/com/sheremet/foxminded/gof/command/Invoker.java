package com.sheremet.foxminded.gof.command;

import java.util.Map;
import java.util.TreeMap;

public final class Invoker {

    private final Map<String, PizzaCommand> added = new TreeMap<>();
    private final Map<String, PizzaCommand> undone = new TreeMap<>();

    public String invokeAllCommands(CommandReceiver commandReceiver) {
        return commandReceiver.prepare(added.values(), undone.values());
    }

    public Invoker addCommand(PizzaCommand pizzaCommand) {
        this.added.put(pizzaCommand.getName(), pizzaCommand);
        return this;
    }

    public Invoker undoCommand(PizzaCommand pizzaCommand) {
        this.undone.put(pizzaCommand.getName(), pizzaCommand);
        return this;
    }
}
