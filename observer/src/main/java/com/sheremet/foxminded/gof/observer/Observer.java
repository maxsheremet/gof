package com.sheremet.foxminded.gof.observer;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

public interface Observer {

    SortedSet<String> update(Collection<Observable> observable);

    String isDangerous(Observable observable);

    String isNotDangerous(Observable observable);

    Set<String> getAllObservables();

    int getThreshold();

    String getName();

    final class Aircraft implements Observer {

        private final Map<String, Observable> storms = new TreeMap<>();
        private final String name;
        private final int threshold;

        public Aircraft(String name, int threshold) {
            this.name = name;
            this.threshold = threshold;
        }

        @Override
        public SortedSet<String> update(Collection<Observable> observables) {
            return observables.stream().map(observable -> {
                if (storms.containsKey(observable.getName()) && observable.getStrength() < getThreshold()) {
                    //remove storm
                    return isNotDangerous(observable);
                } else if (!storms.containsKey(observable.getName()) && observable.getStrength() >= getThreshold()) {
                    //add storm
                    return isDangerous(observable);
                } else if (storms.containsKey(observable.getName()) && observable.getStrength() >= getThreshold()) {
                    //continue watching
                    return String.format("Storm [%d/%s] WATCHING [%s/%d]",
                            observable.getStrength(), observable.getName(), getName(), getThreshold());
                } else {
                    //ignoring
                    return String.format("Storm [%d/%s] IGNORED [%s/%d]",
                            observable.getStrength(), observable.getName(), getName(), getThreshold());
                }
            }).collect(toCollection(TreeSet::new));
        }


        @Override
        public String isDangerous(Observable observable) {
            this.storms.put(observable.getName(), observable);
            return String.format("Storm [%d/%s] DANGEROUS [%s/%d]",
                    observable.getStrength(), observable.getName(), getName(), getThreshold());
        }

        @Override
        public String isNotDangerous(Observable observable) {
            this.storms.remove(observable.getName());
            return String.format("Storm [%d/%s] NOT DANGEROUS [%s/%d]",
                    observable.getStrength(), observable.getName(), getName(), getThreshold());
        }

        @Override
        public Set<String> getAllObservables() {
            return storms.keySet();
        }

        @Override
        public int getThreshold() {
            return this.threshold;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}