package com.sheremet.foxminded.gof.abstractfactory.bakeable;

public final class Toast implements Bakeable {

    private final Duration duration;

    public Toast(Duration duration) {
        this.duration = duration;
    }

    public String getBakingInstructions() {
        return String.format("Toast takes %d to bake.", duration.getValue());
    }
}
