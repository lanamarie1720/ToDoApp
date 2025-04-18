package se.lexicon.model;

import java.util.Objects;

public class Person {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public Person() {
    }

    public Person(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName() {
        if (firstName == null || firstName.trim().isEmpty())
            throw new IllegalArgumentException("firstName is null or empty.")
            this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty())
            throw new IllegalArgumentException("lastName is null or empty.");
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty())
            throw new IllegalArgumentException("email is null or empty.");
        this.email = email;
    }


}
