import java.util.concurrent.locks.ReentrantLock;

public class Task implements Runnable {
    private String name;
    private Resource resource1;
    private Resource resource2;
    private boolean blocked;
    private Thread thread;

    public Task(String name, Resource resource1, Resource resource2) {
        this.name = name;
        this.resource1 = resource1;
        this.resource2 = resource2;
        this.blocked = false;
        this.thread = new Thread(this);
    }

    public boolean isBlocked() {
        return blocked;
    }

    public Thread getThread() {
        return thread;
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        try {
            
            boolean acquiredResource1 = resource1.getLock().tryLock();
            if (acquiredResource1) {
                System.out.println(name + " acquired " + resource1);
            } else {
                System.out.println(name + " could not acquire " + resource1);
            }

            Thread.sleep(50);

            boolean acquiredResource2 = resource2.getLock().tryLock();
            if (acquiredResource2) {
                System.out.println(name + " acquired " + resource2);
            } else {
                System.out.println(name + " could not acquire " + resource2);
            }

            if (acquiredResource1 && acquiredResource2) {
                Thread.sleep(50);
            } else {
                blocked = true;
            }

            if (acquiredResource1) {
                resource1.getLock().unlock();
                System.out.println(name + " released " + resource1);
            }
            if (acquiredResource2) {
                resource2.getLock().unlock();
                System.out.println(name + " released " + resource2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



