package fizzbuzz;

import java.util.concurrent.*;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private Semaphore semFizz, semBuzz, semFizzBuzz, semNumber;

    public FizzBuzz(int n) {
        this.n = n;
        semFizz = new Semaphore(0);
        semBuzz = new Semaphore(0);
        semFizzBuzz = new Semaphore(0);
        semNumber = new Semaphore(1);
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                semFizz.acquire();
                printFizz.run();
                semNumber.release();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                semBuzz.acquire();
                printBuzz.run();
                semNumber.release();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            semFizzBuzz.acquire();
            printFizzBuzz.run();
            semNumber.release();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semNumber.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                semFizzBuzz.release();
            } else if (i % 3 == 0) {
                semFizz.release();
            } else if (i % 5 == 0) {
                semBuzz.release();
            } else {
                printNumber.accept(i);
                semNumber.release();
            }
        }
    }
}
