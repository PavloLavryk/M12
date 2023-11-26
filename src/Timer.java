import java.util.concurrent.*;

public class Timer {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        long startTime = System.currentTimeMillis();

        Runnable displayTimeTask = () -> {
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("Час, що минув: " + elapsedTime / 1000 + " секунд");
        };

        Runnable displayMessageTask = () -> System.out.println("Минуло 5 секунд");

        executor.scheduleAtFixedRate(displayTimeTask, 0, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(displayMessageTask, 5, 5, TimeUnit.SECONDS);
    }
}