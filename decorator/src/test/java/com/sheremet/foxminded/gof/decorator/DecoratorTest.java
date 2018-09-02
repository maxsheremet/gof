package com.sheremet.foxminded.gof.decorator;

import com.sheremet.foxminded.gof.dto.PersonDTO;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class DecoratorTest {

    private final Decorator httpUppercaseReverseDecorator = new Decorator.HtmlDecorator(
            new Decorator.UppercaseDecorator(
                    new Decorator.ReverseDecorator(null)));

    private final Decorator uppercaseReverseDecorator = new Decorator.UppercaseDecorator(
            new Decorator.ReverseDecorator(null));

    private final Decorator htmlUppercaseDecorator = new Decorator.UppercaseDecorator(
            new Decorator.HtmlDecorator(null));


    @Test
    public void testHttpUppercaseReverse() {
        PersonDTO personDTO = new PersonDTO("sEmAj", "dNoB", "NoDnOl");

        assertThat(httpUppercaseReverseDecorator.decorate(personDTO).toString(),
                is("PersonDTO{name=<p>JAMES</p>, surname=<p>BOND</p>, address=<p>LONDON</p>}"));
    }

    @Test
    public void testUppercaseReverseDecorator() {
        PersonDTO personDTO = new PersonDTO("sEmAj", "dNoB", "NoDnOl");

        assertThat(uppercaseReverseDecorator.decorate(personDTO).toString(),
                is("PersonDTO{name=JAMES, surname=BOND, address=LONDON}"));
    }

    @Test
    public void testDecorator() {
        PersonDTO personDTO = new PersonDTO("james", "bond", "london");

        assertThat(htmlUppercaseDecorator.decorate(personDTO).toString(),
                is("PersonDTO{name=<P>JAMES</P>, surname=<P>BOND</P>, address=<P>LONDON</P>}"));
    }
}
