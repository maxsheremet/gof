package com.sheremet.foxminded.gof.abstractfactory.factory;

import com.sheremet.foxminded.gof.abstractfactory.bakeable.Bakeable;

public interface BakingFactory {
    Bakeable getBakeableForName(String name);
}
