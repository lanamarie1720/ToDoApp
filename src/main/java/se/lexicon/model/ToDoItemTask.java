package se.lexicon.model;

public class ToDoItemTask {

    // ========== Fields ==========

    // Unique ID for this task wrapper
    private int id;

    // Indicates whether the task is assigned to someone
    private boolean assigned;

    // The actual to-do item being assigned
    private ToDoItem toDoItem;

    // The person to whom the task is assigned
    private Person assignee;

    // ========== Constructors ==========

    /**
     * Creates a task assignment with a to-do item and an assignee.
     * Sets the task and marks it as assigned if the assignee is not null.
     *
     * @param toDoItem The to-do item to assign
     * @param assignee The person to assign the task to
     */
    public ToDoItemTask(ToDoItem toDoItem, Person assignee) {
        setToDoItem(toDoItem);
        setAssignee(assignee); // Automatically sets 'assigned' based on whether assignee is null
    }

    /**
     * Creates a task wrapper with only a to-do item (no assignee).
     * Can be assigned later using setAssignee().
     *
     * @param toDoItem The to-do item to wrap
     */
    public ToDoItemTask(ToDoItem toDoItem) {
        setToDoItem(toDoItem);
    }

    /**
     * Creates a task assignment with an ID, to-do item, and assignee.
     * Useful when creating objects with pre-known IDs (e.g., from a database).
     *
     * @param id       The unique ID of this task assignment
     * @param toDoItem The to-do item to assign
     * @param assignee The person to assign the task to
     */
    public ToDoItemTask(int id, ToDoItem toDoItem, Person assignee) {
        this(toDoItem, assignee); // Reuse constructor logic
        this.id = id;
    }

    // ========== Getters and Setters ==========

    /**
     * Gets the ID of this task assignment.
     *
     * @return the task ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID for this task assignment.
     *
     * @param id the new ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Checks if the task is assigned to someone.
     *
     * @return true if assigned, false otherwise
     */
    public boolean isAssigned() {
        return assigned;
    }

    /**
     * Gets the wrapped ToDoItem.
     *
     * @return the to-do item
     */
    public ToDoItem getToDoItem() {
        return toDoItem;
    }

    /**
     * Sets the ToDoItem for this task.
     * Throws an exception if null.
     *
     * @param toDoItem the to-do item to assign
     */
    public void setToDoItem(ToDoItem toDoItem) {
        if (toDoItem == null)
            throw new IllegalArgumentException("toDoItem is null.");
        this.toDoItem = toDoItem;
    }

    /**
     * Gets the person assigned to this task.
     *
     * @return the assignee
     */
    public Person getAssignee() {
        return assignee;
    }

    /**
     * Sets the assignee for this task.
     * Also updates the 'assigned' flag based on whether assignee is null.
     *
     * @param assignee the person to assign the task to
     */
    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        this.assigned = (this.assignee != null); // Automatically updates the assigned flag
    }

    // ========== toString Override ==========

    /**
     * Returns a string representation of the task assignment.
     * Includes ID, assignment status, the to-do item, and the assignee.
     *
     * @return a formatted string of task assignment details
     */
    @Override
    public String toString() {
        return "ToDoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", toDoItem=" + toDoItem +
                ", assignee=" + assignee +
                '}';
    }
}
