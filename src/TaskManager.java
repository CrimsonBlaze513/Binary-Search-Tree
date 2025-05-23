import java.util.PriorityQueue;
import java.util.Iterator;
// TaskManager.java
// This class will manage a collection of tasks using a BST<Task>.
// It should provide methods to add, delete, search, and print tasks by priority.
public class TaskManager {
    private final PriorityQueue<Task> taskQueue;

    public TaskManager() {
        taskQueue = new PriorityQueue<>();
    }

    public void addTask(int priority, String description) {
        taskQueue.add(new Task(priority, description));
    }

    public void deleteTask(int priority) {
        // This will delete the first task that matches the given priority
        taskQueue.removeIf(task -> task.getPriority() == priority);
    }

    public boolean findTask(int priority) {
        for (Task task : taskQueue) {
            if (task.getPriority() == priority) {
                return true;
            }
        }
        return false;
    }

    public void printTasks() {
        PriorityQueue<Task> copy = new PriorityQueue<>(taskQueue);
        while (!copy.isEmpty()) {
            System.out.println(copy.poll());
        }
    }

    public void getDescription(int priority) {
        boolean found = false;
        for (Task task : taskQueue) {
            if (task.getPriority() == priority) {
                System.out.println("Tasks with Priority " + priority + ", " + task.getDescription());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }


    public static void main(String[] args) {
        // TO IMPLEMENT: Create a TaskManager object
        // Use the TaskManager to insert tasks, search, delete, and print in priority order
        // This serves as your main test harness

        TaskManager tm = new TaskManager();

        tm.addTask(4, "Task 1");
        tm.addTask(2, "Task 2");
        tm.addTask(3, "Task 3");
        tm.addTask(1, "Task 4");
        tm.addTask(2, "Task 5");

        tm.printTasks();
        System.out.println();

        tm.getDescription(2);

        System.out.println("Task with priority 1 found? " + tm.findTask(1));
        tm.deleteTask(1);
        System.out.println("Task with priority 1 found? " + tm.findTask(1));
        tm.printTasks();
    }
}
