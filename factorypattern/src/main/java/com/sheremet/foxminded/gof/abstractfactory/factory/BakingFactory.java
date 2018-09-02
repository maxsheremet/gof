package com.sheremet.foxminded.gof.abstractfactory.factory;

import com.sheremet.foxminded.gof.abstractfactory.bakeable.Bakeable;

public interface BakingFactory {
    Bakeable getBakeableForName(String name);

    final class BakingFactoryImpl implements BakingFactory {

        public Bakeable getBakeableForName(String name) {
            if ("toast".equalsIgnoreCase(name)) {
                return new Bakeable.Toast(Bakeable.Duration.Short);
            } else if ("pizza".equalsIgnoreCase(name)) {
                return new Bakeable.Pizza(Bakeable.Duration.Medium);
            } else if ("pie".equalsIgnoreCase(name)) {
                return new Bakeable.Pie(Bakeable.Duration.Long);
            } else {
                throw new RuntimeException(String.format("No item by the name of %s.", name));
            }
        }

    }
}
