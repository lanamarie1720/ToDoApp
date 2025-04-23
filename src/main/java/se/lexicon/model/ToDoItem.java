package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class ToDoItem {

    // ========== Fields ==========

    // Unique ID for this task
    private int id;

    // Short title or name of the task (e.g., "Laundry")
    private String title;

    // Detailed description of what needs to be done
    private String description;

    // Deadline for when the task should be completed
    private LocalDate deadline;

    // Flag to indicate whether the task is completed
    private boolean done;

    // Person who created this task
    private Person creator;

    // ========== Constructors ==========

    /**
     * Constructor with all fields including ID.
     * Calls the other constructor to set common fields, then sets ID.
     */
    public ToDoItem(int id, String title, String description, LocalDate deadline, boolean done, Person creator) {
        this(title, description, deadline, done, creator);
        this.id = id;
    }

    /**
     * Constructor without ID (for auto-generated IDs).
     * Validates required fields using setters.
     */
    public ToDoItem(String title, String description, LocalDate deadline, boolean done, Person creator) {
        setTitle(title);
        setDescription(description);
        setDeadline(deadline);
        setDone(done);
        setCreator(creator);
    }

    // ========== Getters and Setters ==========

    /**
     * Gets the ID of the task.
     * @return task ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the task ID.
     * @param id the new ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the task title.
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the task title.
     * Validates that it is not null or empty.
     * @param title the new title
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("title is null or empty.");
        this.title = title;
    }

    /**
     * Gets the task description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the task description (can be empty or null).
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the deadline date.
     * @return deadline
     */
    public LocalDate getDeadline() {
        return deadline;
    }

    /**
     * Sets the deadline. Throws exception if null.
     * @param deadline the new deadline date
     */
    public void setDeadline(LocalDate deadline) {
        if (deadline == null)
            throw new IllegalArgumentException("deadline is null.");
        this.deadline = deadline;
    }

    /**
     * Checks if the task is marked as done.
     * @return true if done, false otherwise
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Marks the task as done or not.
     * @param done true if done, false otherwise
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    /**
     * Gets the creator of the task.
     * @return creator (a Person object)
     */
    public Person getCreator() {
        return creator;
    }

    /**
     * Sets the creator of the task.
     * Throws exception if null.
     * @param creator the person who created this task
     */
    public void setCreator(Person creator) {
        if (creator == null)
            throw new IllegalArgumentException("creator is null.");
        this.creator = creator;
    }

    // ========== Custom Methods ==========

    /**
     * Checks if the task is overdue.
     * Compares the current date with the deadline.
     * @return true if the current date is after the deadline
     */
    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadline);
    }

    // ========== Object Overrides ==========

    /**
     * Returns a string summary of the ToDoItem object.
     * Useful for logging, printing, and debugging.
     */
    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", creator=" + creator +
                '}';
    }

    /**
     * Computes a hash code based on task fields.
     * Used when storing in hash-based collections (e.g., HashMap, HashSet).
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, deadline, done, creator);
    }

    /**
     * Compares two ToDoItem objects for equality based on field values.
     * @param o the object to compare with
     * @return true if all relevant fields match
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return id == toDoItem.id &&
                done == toDoItem.done &&
                Objects.equals(title, toDoItem.title) &&
                Objects.equals(description, toDoItem.description) &&
                Objects.equals(deadline, toDoItem.deadline) &&
                Objects.equals(creator, toDoItem.creator);
    }
}
