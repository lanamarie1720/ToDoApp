package se.lexicon;

import se.lexicon.model.Person;
import se.lexicon.model.ToDoItem;
import se.lexicon.model.ToDoItemTask;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Lana", "Brokaw", "lana.marie@live.com");
        Person person2 = new Person("Ahmed", "Elshobaki", "ahmed@shobaki.net");

        ToDoItem task1 = new ToDoItem("Laundry", "Wash clothes", LocalDate.parse("2025-04-18"), false, person1);
        ToDoItem task2 = new ToDoItem("Groceries", "Buy milk", LocalDate.now().plusDays(1), false, person1);

        System.out.println(person1);
        System.out.println(person2);

        System.out.println(task1);
        System.out.println(task2);

        ToDoItemTask toDoItemTaskForPerson2 = new ToDoItemTask(task1, person2);
        System.out.println(toDoItemTaskForPerson2);

        ToDoItemTask toDoItemTask = new ToDoItemTask(task2);
        toDoItemTask.setAssignee(person2);
        System.out.println(toDoItemTask);


    }
}