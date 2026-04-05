import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    private String name;
    private ReentrantLock lock;

    public Resource(String name) {
        this.name = name;
        this.lock = new ReentrantLock();
    }

    public String getName() {
        return name;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return name;
    }
}

