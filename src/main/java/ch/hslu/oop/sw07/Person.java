package ch.hslu.oop.sw07;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person>, Comparator<Person> {

    private long id;
    private String firstName;
    private String lastName;

    public Person(final long id, final String firstName, final String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Person p) && (p.getId() == this.id) && Objects.equals(p.getFirstName(), (this.firstName)) && Objects.equals(p.getLastName(), (this.lastName));
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName);
    }

    @Override
    public final int compareTo(final Person p) {
        return Long.compare(this.id, p.getId());
    }

    @Override
    public int compare(Person p1, Person p2) {
        int result = (p1.getLastName().compareTo(p2.getLastName()));
        if (result == 0) {
            return (p1.getFirstName().compareTo(p2.getFirstName()));
        } else {
            return result;
        }
    }
}
