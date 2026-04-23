package com.football.currency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyDemo {
    public static void run() throws Exception {

        // -------- THREADS --------
        MyThread t1 = new MyThread("Thread-EXTENDS");
        Thread t2 = new Thread(new MyRunnable(), "Thread-RUNNABLE");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // -------- CONNECTION POOL (Executor) --------
        ExecutorService executor = Executors.newFixedThreadPool(7);
        ConnectionPool pool = ConnectionPool.getInstance();

        for (int i = 0; i < 7; i++) {
            executor.submit(() -> {
                try {
                    Integer conn = pool.getConnection();
                    System.out.println(Thread.currentThread().getName() +
                            " got connection " + conn);

                    Thread.sleep(500);

                    pool.releaseConnection(conn);
                    System.out.println(Thread.currentThread().getName() +
                            " released connection " + conn);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        // -------- COMPLETABLE FUTURE --------
        CompletableFuture<?>[] futures = new CompletableFuture[7];

        for (int i = 0; i < 7; i++) {
            futures[i] = CompletableFuture
                    .supplyAsync(() -> {
                        try {
                            return pool.getConnection();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .thenAccept(conn -> {
                        System.out.println(Thread.currentThread().getName() +
                                " using connection " + conn);

                        pool.releaseConnection(conn);
                    });
        }
        CompletableFuture.allOf(futures).join();
    }
}
