import java.util.concurrent.*;

public class ThreadsWithExecutors {


    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        int n = 10;
        CountDownLatch[] latches = new CountDownLatch[n];

        // Initialize latches for each task
        for (int i = 0; i < n; i++) {
            latches[i] = new CountDownLatch(1);
        }

        for (int i = 0; i < n; i++) {
            int finalI = i;
            pool.execute(() -> {
                try {
                    // Wait for the previous task to complete
                    if (finalI > 0) {
                        latches[finalI - 1].await();
                    }

                    // Execute the task
                    int data = add(finalI, finalI + 5);
                    System.out.println("Result: " + data);
                    System.out.println("Thread Name: " + Thread.currentThread().getName());

                    // Signal that this task is done
                    latches[finalI].countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Shutdown the executor after all tasks are done
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int add(int i, int j) {
        return i + j;
    }
    }


