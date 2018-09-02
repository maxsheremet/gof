package com.sheremet.foxminded.gof.dto;

import com.google.common.base.MoreObjects;

public final class PersonDTO {
    private final String name;
    private final String surname;
    private final String address;

    public PersonDTO(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("surname", surname)
                .add("address", address)
                .toString();
    }
}
