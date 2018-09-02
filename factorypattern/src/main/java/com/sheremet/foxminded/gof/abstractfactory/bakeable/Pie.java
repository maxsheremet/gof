package com.sheremet.foxminded.gof.abstractfactory.bakeable;

public final class Pie implements Bakeable {
    private final Duration duration;

    public Pie(Duration duration) {
        this.duration = duration;
    }

    public String getBakingInstructions() {
        return String.format("Pie takes %d mins to bake.", duration.getValue());
    }
}
