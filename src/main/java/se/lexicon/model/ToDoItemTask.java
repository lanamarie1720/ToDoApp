package se.lexicon.model;

public class ToDoItemTask {

    private int id;
    private boolean assigned;
    private ToDoItem toDoItem;
    private Person assignee;

    public ToDoItemTask(ToDoItem toDoItem, Person assignee) {
        setToDoItem(toDoItem);
        setAssignee(assignee);
    }

    public ToDoItemTask(ToDoItem toDoItem) {
        setToDoItem(toDoItem);
    }

    public ToDoItemTask(int id, ToDoItem toDoItem, Person assignee) {
        this(toDoItem, assignee);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public ToDoItem getToDoItem() {
        return toDoItem;
    }

    public void setToDoItem(ToDoItem toDoItem) {
        if (toDoItem == null)
            throw new IllegalArgumentException("toDoItem is null.");
        this.toDoItem = toDoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee() {
        this.assignee = assignee;
        this.assigned = (this.assignee != null);
    }
}
