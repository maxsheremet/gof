package com.sheremet.foxminded.gof.decorator;

import com.sheremet.foxminded.gof.dto.PersonDTO;

public interface Decorator {
    /**
     * The contract.
     */
    PersonDTO decorate(PersonDTO personDTO);

    /**
     * Impl to dynamically reverse fields in the entity.
     */
    final class ReverseDecorator implements Decorator {

        private final Decorator decorator;

        public ReverseDecorator(Decorator decorator) {
            this.decorator = decorator;
        }

        @Override
        public PersonDTO decorate(PersonDTO personDTO) {
            //previous step if any
            PersonDTO person = (decorator == null)
                    ? personDTO
                    : decorator.decorate(personDTO);
            //apply transformation for this decorator
            return new PersonDTO(
                    reverse(person.getName()),
                    reverse(person.getSurname()),
                    reverse(person.getAddress())
            );
        }

        private static String reverse(String value) {
            return new StringBuilder(value).reverse().toString();
        }
    }

    /**
     * Impl to dynamically uppercase fields in the entity.
     */
    final class UppercaseDecorator implements Decorator {
        private final Decorator decorator;

        public UppercaseDecorator(Decorator decorator) {
            this.decorator = decorator;
        }

        @Override
        public PersonDTO decorate(PersonDTO personDTO) {
            //previous step if any
            PersonDTO person = (decorator == null)
                    ? personDTO
                    : decorator.decorate(personDTO);
            //apply transformation for this decorator
            return new PersonDTO(
                    person.getName().toUpperCase(),
                    person.getSurname().toUpperCase(),
                    person.getAddress().toUpperCase()
            );
        }
    }

    /**
     * Impl to wrap fields in html tags.
     */
    final class HtmlDecorator implements Decorator {
        private static final String tag = "p";
        private final Decorator decorator;

        public HtmlDecorator(Decorator decorator) {
            this.decorator = decorator;
        }

        @Override
        public PersonDTO decorate(PersonDTO personDTO) {
            //previous step if any
            PersonDTO person = (decorator == null)
                    ? personDTO
                    : decorator.decorate(personDTO);
            //apply transformation for this decorator
            return new PersonDTO(
                    toHtml(person.getName()),
                    toHtml(person.getSurname()),
                    toHtml(person.getAddress())
            );
        }

        private static String toHtml(String value) {
            return String.format("<%s>%s</%s>", tag, value, tag);
        }
    }
}
