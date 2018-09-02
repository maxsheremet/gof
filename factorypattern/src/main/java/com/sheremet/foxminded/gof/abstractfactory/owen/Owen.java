package com.sheremet.foxminded.gof.abstractfactory.owen;

import com.sheremet.foxminded.gof.abstractfactory.factory.BakingFactory;
import com.sheremet.foxminded.gof.abstractfactory.factory.BakingFactoryImpl;

public final class Owen {
    private final BakingFactory bakingFactory = new BakingFactoryImpl();

    public String bake(String name) {
        return bakingFactory.getBakeableForName(name).getBakingInstructions();
    }

}
