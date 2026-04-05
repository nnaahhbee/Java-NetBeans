import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DeadlockGame {
    private static Map<String, Resource> resourceMap;
    private static List<Task> tasks;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        resourceMap = getResources();
        tasks = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter two resources for Task " + i + ": ");
            String resource1 = scanner.next();
            String resource2 = scanner.next();
            tasks.add(new Task("Task " + i, resourceMap.get(resource1), resourceMap.get(resource2)));
        }

        for (Task task : tasks) {
            task.start();
        }

        for (Task task : tasks) {
            try {
                task.getThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        checkForDeadlock();
    }

    public static Map<String, Resource> getResources() {
        Map<String, Resource> resources = new HashMap<>();
        resources.put("A", new Resource("A"));
        resources.put("B", new Resource("B"));
        resources.put("C", new Resource("C"));
        return resources;
    }

    public static void checkForDeadlock() {
        boolean allBlocked = true;
        for (Task task : tasks) {
            if (!task.isBlocked()) {
                allBlocked = false;
                break;
            }
        }
        if (allBlocked) {
            System.out.println("Deadlock detected!");
        } else {
            System.out.println("No deadlock detected.");
        }
    }
}


