package se.lexicon.model;

import java.util.Objects;

public class Person {

    // ========== Fields ==========
    // These are private fields representing the person's properties.
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    private AppUser credentials;

    public Person() {

    }

    // ========== Constructor ==========

    /**
     * Constructor to create a new Person with required information.
     * Validates firstName, lastName, and email before assigning.
     */
    public Person(String firstName, String lastName, String email, AppUser credentials) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);

        setCredentials(credentials);
    }

    public Person(Integer id, String firstName, String lastName, String email, AppUser credentials) {
        this(firstName, lastName, email, credentials);
        if (id == null) throw new RuntimeException("id is null");
        this.id = id;
    }

    // ========== Getters and Setters ==========

    /**
     * Gets the ID of the person.
     * @return the person's ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the person.
     * @param id the new ID to assign
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the first name of the person.
     * @return the person's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name. Throws exception if input is null or empty.
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty())
            throw new IllegalArgumentException("firstName is null or empty.");
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the person.
     * @return the person's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name. Throws exception if input is null or empty.
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty())
            throw new IllegalArgumentException("lastName is null or empty.");
        this.lastName = lastName;
    }

    /**
     * Gets the email of the person.
     * @return the person's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email. Throws exception if input is null or empty.
     * @param email the email address to set
     */
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty())
            throw new IllegalArgumentException("email is null or empty.");

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex))
            throw new IllegalArgumentException("Invalid email format.");
        this.email = email;
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        if (credentials == null) throw new IllegalArgumentException("Credential is null.");
        this.credentials = credentials;
    }

    // ========== Object Overrides ==========

    /**
     * Checks if two Person objects are equal based on their content (id, name, and email).
     * Overrides Object's default reference-based equals.
     * @param o the object to compare with
     * @return true if all fields match, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id)
                && Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName)
                && Objects.equals(email, person.email);
    }

    /**
     * Generates a hash code based on the object's content.
     * Important for use in hash-based collections (HashMap, HashSet, etc.).
     * @return the hash code of this person
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    /**
     * Returns a string representation of the Person object.
     * Useful for debugging or printing.
     * @return string format of this person's details
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
