package com.sheremet.foxminded.gof.abstractfactory.owen;

import com.sheremet.foxminded.gof.abstractfactory.factory.BakingFactory;

public final class Owen {
    private final BakingFactory bakingFactory = new BakingFactory.BakingFactoryImpl();

    public String bake(String name) {
        return bakingFactory.getBakeableForName(name).getBakingInstructions();
    }
}
