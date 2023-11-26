package fizzbuzz;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread A = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread B = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread C = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread D = new Thread(() -> {
            try {
                fizzBuzz.number((x) -> System.out.print(x + ", "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Запускаємо потоки
        A.start();
        B.start();
        C.start();
        D.start();

        // Чекаємо, поки всі потоки завершаться
        A.join();
        B.join();
        C.join();
        D.join();
    }
}

