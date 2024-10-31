package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testPersonConstructor() {
        // Prepare
        long id = 12345;
        String firstName = "John";
        String lastName = "Doe";

        // Act
        Person person = new Person(id, firstName, lastName);

        // Assert
        assertEquals(id, person.getId());
        assertEquals(firstName, person.getFirstName());
        assertEquals(lastName, person.getLastName());
    }

    @Test
    public void testPersonEqualsTrue() {
        // Prepare
        long idP1 = 12345;
        String firstNameP1 = "John";
        String lastNameP1 = "Doe";
        Person person1 = new Person(idP1, firstNameP1, lastNameP1);

        long idP2 = 12345;
        String firstNameP2 = "John";
        String lastNameP2 = "Doe";
        Person person2 = new Person(idP2, firstNameP2, lastNameP2);

        // Act
        boolean result = person1.equals(person2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testPersonEqualsFalse() {
        // Prepare
        long idP1 = 12345;
        String firstNameP1 = "John";
        String lastNameP1 = "Doe";
        Person person1 = new Person(idP1, firstNameP1, lastNameP1);

        long idP2 = 41256;
        String firstNameP2 = "Jane";
        String lastNameP2 = "Doese";
        Person person2 = new Person(idP2, firstNameP2, lastNameP2);

        // Act
        boolean result = person1.equals(person2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testEqualsVerifier() {
        EqualsVerifier.simple().forClass(Person.class).verify();
    }


    @Test
    public void testCompareToEqual() {
        // Prepare
        Person person1 = new Person(12345, "John", "Doe");
        Person person2 = new Person(12345, "John", "Doe");

        // Act
        int result = person1.compareTo(person2);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testCompareToGreater() {
        // Prepare
        Person person1 = new Person(12345, "John", "Doe");
        Person person2 = new Person(12344, "John", "Doe");

        // Act
        int result = person1.compareTo(person2);

        // Assert
        assertEquals(1, result);
    }


    @Test
    public void testCompareToSmaller() {
        // Prepare
        Person person1 = new Person(12345, "John", "Doe");
        Person person2 = new Person(12346, "John", "Doe");

        // Act
        int result = person1.compareTo(person2);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    public void testComparePeopleEqual() {
        // Prepare
        Person person1 = new Person(12345, "John", "Doe");
        Person person2 = new Person(12346, "John", "Doe");

        // Act
        int result = person1.compare(person1, person2);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testComparePeopleLessLastName() {
        // Prepare
        Person person1 = new Person(12345, "John", "Coe");
        Person person2 = new Person(12346, "John", "Doe");

        // Act
        int result = person1.compare(person1, person2);

        // Assert
        assertTrue(result < 0);    }

    @Test
    public void testComparePeopleMoreLastName() {
        // Prepare
        Person person1 = new Person(12345, "John", "Foe");
        Person person2 = new Person(12346, "John", "Doe");

        // Act
        int result = person1.compare(person1, person2);

        // Assert
        assertTrue(result > 0);
    }

    @Test
    public void testComparePeopleLessFirstName() {
        // Prepare
        Person person1 = new Person(12345, "Aohn", "Doe");
        Person person2 = new Person(12346, "John", "Doe");

        // Act
        int result = person1.compare(person1, person2);

        // Assert
        assertTrue(result < 0);    }

    @Test
    public void testComparePeopleMoreFirstName() {
        // Prepare
        Person person1 = new Person(12345, "Kohn", "Doe");
        Person person2 = new Person(12346, "John", "Doe");

        // Act
        int result = person1.compare(person1, person2);

        // Assert
        assertTrue(result > 0);
    }
}