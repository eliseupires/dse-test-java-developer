package com.overriding.equals.model;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Override equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // check reference equality
        if (o == null || getClass() != o.getClass()) return false; // check type

        Person person = (Person) o;

        return id == person.id; // compare business key
    }

    // Override hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(id); // ensure consistency with equals
    }

}

