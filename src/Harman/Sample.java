package Harman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Azret Magometov
 */

public class Sample {

    private volatile static int mCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int etaji = Integer.parseInt(reader.readLine());
        ExecutorService executorService = Executors.newFixedThreadPool(etaji);
        for (int i = 0; i < etaji; i++) {
            executorService.submit(() -> {
                try {
                    readPeople();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    private static void readPeople() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int ludi = Integer.parseInt(reader.readLine());
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            mCount += ludi;
            System.out.println(mCount);
        } finally {
            lock.unlock();
        }

    }
}
