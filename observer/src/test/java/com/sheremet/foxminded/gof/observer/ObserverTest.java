package com.sheremet.foxminded.gof.observer;

import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public final class ObserverTest {

    //Create storms with name and strength.
    private final Map<String, Observable> storms = asList(
            new Observable.Storm("Weak", 1),
            new Observable.Storm("Medium", 3),
            new Observable.Storm("Strong", 5)
    )
            .stream().collect(toMap(Observable::getName, o -> o));

    //create aircraft with name and resistance.
    private final Map<String, Observer> aircrafts = asList(
            new Observer.Aircraft("Airbus320", 2),
            new Observer.Aircraft("Airbus340", 4),
            new Observer.Aircraft("Airbus380", 6))
            .stream().collect(toMap(Observer::getName, o -> o));

    private String updateStormReport() {
        return aircrafts.values()
                .stream()
                .map(aircraft -> aircraft.update(storms.values()))
                .flatMap(Set::stream)
                .sorted()
                .collect(joining(","));
    }

    private void incrementStorms(int offset) {
        storms.values().forEach(o -> o.incrementStrength(offset));
    }

    @Test
    public void testAirbus380() {
        //get initial report
        assertThat(updateStormReport(), is(
                "Storm [1/Weak] IGNORED [Airbus320/2]," +
                        "Storm [1/Weak] IGNORED [Airbus340/4]," +
                        "Storm [1/Weak] IGNORED [Airbus380/6]," +
                        "Storm [3/Medium] DANGEROUS [Airbus320/2]," +
                        "Storm [3/Medium] IGNORED [Airbus340/4]," +
                        "Storm [3/Medium] IGNORED [Airbus380/6]," +
                        "Storm [5/Strong] DANGEROUS [Airbus320/2]," +
                        "Storm [5/Strong] DANGEROUS [Airbus340/4]," +
                        "Storm [5/Strong] IGNORED [Airbus380/6]"));
        assertTrue(aircrafts.get("Airbus320").getAllObservables().containsAll(asList("Strong", "Medium")));
        assertTrue(aircrafts.get("Airbus340").getAllObservables().containsAll(asList("Strong")));
        assertTrue(aircrafts.get("Airbus380").getAllObservables().isEmpty());


        //increment all storms by 2
        incrementStorms(2);
        assertThat(updateStormReport(), is(
                "Storm [3/Weak] DANGEROUS [Airbus320/2]," +
                        "Storm [3/Weak] IGNORED [Airbus340/4]," +
                        "Storm [3/Weak] IGNORED [Airbus380/6]," +
                        "Storm [5/Medium] DANGEROUS [Airbus340/4]," +
                        "Storm [5/Medium] IGNORED [Airbus380/6]," +
                        "Storm [5/Medium] WATCHING [Airbus320/2]," +
                        "Storm [7/Strong] DANGEROUS [Airbus380/6]," +
                        "Storm [7/Strong] WATCHING [Airbus320/2]," +
                        "Storm [7/Strong] WATCHING [Airbus340/4]"));
        assertTrue(aircrafts.get("Airbus320").getAllObservables().containsAll(asList("Strong", "Medium", "Weak")));
        assertTrue(aircrafts.get("Airbus340").getAllObservables().containsAll(asList("Strong", "Medium")));
        assertTrue(aircrafts.get("Airbus380").getAllObservables().containsAll(asList("Strong")));

        //decrement all storms by 8
        incrementStorms(-8);
        assertThat(updateStormReport(), is(
                "Storm [-1/Strong] NOT DANGEROUS [Airbus320/2]," +
                        "Storm [-1/Strong] NOT DANGEROUS [Airbus340/4]," +
                        "Storm [-1/Strong] NOT DANGEROUS [Airbus380/6]," +
                        "Storm [-3/Medium] IGNORED [Airbus380/6]," +
                        "Storm [-3/Medium] NOT DANGEROUS [Airbus320/2]," +
                        "Storm [-3/Medium] NOT DANGEROUS [Airbus340/4]," +
                        "Storm [-5/Weak] IGNORED [Airbus340/4]," +
                        "Storm [-5/Weak] IGNORED [Airbus380/6]," +
                        "Storm [-5/Weak] NOT DANGEROUS [Airbus320/2]"));
        assertTrue(aircrafts.get("Airbus320").getAllObservables().isEmpty());
        assertTrue(aircrafts.get("Airbus340").getAllObservables().isEmpty());
        assertTrue(aircrafts.get("Airbus380").getAllObservables().isEmpty());

    }
}
