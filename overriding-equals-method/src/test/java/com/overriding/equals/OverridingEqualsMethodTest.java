package com.overriding.equals;

import com.overriding.equals.model.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

public class OverridingEqualsMethodTest {

    @Test
    public void testEquals_sameId_shouldBeEqual() {
        Person p1 = new Person(1, "Alice", "alice@example.com");
        Person p2 = new Person(1, "Alicia", "different@example.com");

        assertEquals(p1, p2, "Persons with same ID should be equal");
    }

    @Test
    public void testEquals_differentId_shouldNotBeEqual() {
        Person p1 = new Person(1, "Alice", "alice@example.com");
        Person p2 = new Person(2, "Alice", "alice@example.com");

        assertNotEquals(p1, p2, "Persons with different IDs should not be equal");
    }

    @Test
    public void testHashCode_sameId_shouldBeEqual() {
        Person p1 = new Person(1, "Alice", "alice@example.com");
        Person p2 = new Person(1, "Alicia", "different@example.com");

        assertEquals(p1.hashCode(), p2.hashCode(), "Hash codes should match for equal persons");
    }

    @Test
    public void testHashSet_noDuplicatesWithSameId() {
        Person p1 = new Person(1, "Alice", "alice@example.com");
        Person p2 = new Person(1, "Alicia", "different@example.com");

        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2); // Should not be added due to equality

        assertEquals(1, set.size(), "HashSet should contain only one unique Person");
    }

    @Test
    public void testEquals_nullAndDifferentType() {
        Person p1 = new Person(1, "Alice", "alice@example.com");

        assertNotEquals(p1, null, "Person should not be equal to null");
        assertNotEquals(p1, "some string", "Person should not be equal to an object of another type");
    }

    @Test
    public void testEquals_reflexivity() {
        Person p1 = new Person(1, "Alice", "alice@example.com");

        assertEquals(p1, p1, "Person should be equal to itself");
    }

    @Test
    public void testEquals_symmetry() {
        Person p1 = new Person(1, "Alice", "alice@example.com");
        Person p2 = new Person(1, "Alicia", "different@example.com");

        assertTrue(p1.equals(p2) && p2.equals(p1), "Equality should be symmetric");
    }

    @Test
    public void testEquals_transitivity() {
        Person p1 = new Person(1, "Alice", "alice@example.com");
        Person p2 = new Person(1, "Alicia", "different@example.com");
        Person p3 = new Person(1, "Another", "another@example.com");

        assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3), "Equality should be transitive");
    }
}
