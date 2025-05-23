// Task.java
// This class models a Task with a priority and description.
// It also assigns a unique creation order for tie-breaking.
public class Task implements Comparable<Task> {
    private static long counter = 0; // Used to assign creation order
    private final int priority;      // Priority level of the task
    private final String description;// Task description
    private final long creationOrder;// Unique creation order of the task

    // Constructor for creating a new task
    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
        this.creationOrder = counter++; // Ensure unique order for each task
    }

    // Getter for priority
    public int getPriority() {
        return priority;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Getter for creation order
    public long getCreationOrder() {
        return creationOrder;
    }

    // Override toString to display task
    @Override
    public String toString() {
        return "[Priority: " + priority + ", Description: " + description + "]";
    }

    // TO IMPLEMENT: compareTo method for sorting by priority, and by creationOrder if extra credit
    @Override
    public int compareTo(Task o) {
        int priorityCompare = Integer.compare(this.priority, o.priority);
        if (priorityCompare != 0) return priorityCompare;
        return Long.compare(this.creationOrder, o.creationOrder);
    }
}
