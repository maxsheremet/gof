package com.sheremet.foxminded.gof.abstractfactory.factory;

import com.sheremet.foxminded.gof.abstractfactory.bakeable.Bakeable;
import com.sheremet.foxminded.gof.abstractfactory.bakeable.Pie;
import com.sheremet.foxminded.gof.abstractfactory.bakeable.Pizza;
import com.sheremet.foxminded.gof.abstractfactory.bakeable.Toast;

public final class BakingFactoryImpl implements BakingFactory {

    public Bakeable getBakeableForName(String name) {
        if ("toast".equalsIgnoreCase(name)) {
            return new Toast(Bakeable.Duration.Short);
        } else if ("pizza".equalsIgnoreCase(name)) {
            return new Pizza(Bakeable.Duration.Medium);
        } else if ("pie".equalsIgnoreCase(name)) {
            return new Pie(Bakeable.Duration.Long);
        } else {
            throw new RuntimeException(String.format("No item by the name of %s.", name));
        }
    }

}
