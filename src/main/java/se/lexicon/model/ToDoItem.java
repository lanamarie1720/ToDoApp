package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class ToDoItem {

    private int id;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
    private Person creator;

    public ToDoItem(int id, String title, String description, LocalDate deadline, boolean done, Person creator) {
    this(title, description, deadline, done, creator);
    this.id = id;
    }

    public ToDoItem(String title, String description, LocalDate deadline, boolean done, Person creator) {
        setTitle(title);
        setDescription(description);
        setDeadline(deadline);
        setDone(done);
        setCreator(creator);
    }

    public int getId() {
     return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("title is null or empty.");
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        if (deadline == null)
            throw new IllegalArgumentException("deadline is null.");
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        if (creator == null)
            throw new IllegalArgumentException("creator is null.");
        this.creator = creator;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadline);
    }
}
