package se.lexicon.model;

import java.util.Objects;

public class AppUser {

    // ========== Fields ==========

    // Username of the user (e.g., "admin123")
    private String username;

    // Password for authentication (should be securely handled in a real app!)
    private String password;

    // Role assigned to the user (e.g., ADMIN, USER)
    private AppRole role;

    // ========== Constructor ==========

    /**
     * Creates a new AppUser object with a username, password, and role.
     * Validates the input using setters.
     *
     * @param username The username to assign
     * @param password The user's password
     * @param role     The user's application role
     */
    public AppUser(String username, String password, AppRole role) {
        setUsername(username);
        setPassword(password);
        setRole(role);
    }

    // ========== Getters and Setters ==========

    /**
     * Gets the current username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username. Throws an exception if it's null or empty.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty())
            throw new IllegalArgumentException("Username is null or empty.");
        this.username = username;
    }

    /**
     * Gets the current password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password. Throws an exception if it's null or empty.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty())
            throw new IllegalArgumentException("Password is null or empty.");
        this.password = password;
    }

    /**
     * Gets the user's role (e.g., ADMIN, USER).
     *
     * @return the role
     */
    public AppRole getRole() {
        return role;
    }

    /**
     * Sets the user's role. Throws an exception if role is null.
     *
     * @param role the new role
     */
    public void setRole(AppRole role) {
        if (role == null)
            throw new IllegalArgumentException("Role is null.");
        this.role = role;
    }

    // ========== equals and hashCode ==========

    /**
     * Compares this AppUser with another for equality.
     * Two users are considered equal if their username and role are the same.
     *
     * @param o the object to compare with
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(username, appUser.username) && role == appUser.role;
    }

    /**
     * Generates a hash code based on the username and role.
     * Useful when storing users in hash-based collections.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }

    // ========== toString ==========

    /**
     * Returns a string representation of the AppUser (excluding password for security).
     *
     * @return a string with username and role
     */
    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", role=" + role +
                '}';
    }
}
