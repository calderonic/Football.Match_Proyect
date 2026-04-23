package com.football.currency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static ConnectionPool instance;
    private BlockingQueue<Integer> pool;

    private ConnectionPool() {
        pool = new ArrayBlockingQueue<>(5);

        for (int i = 1; i <= 5; i++) {
            pool.add(i); // just IDs, no extra class needed
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Integer getConnection() throws InterruptedException {
        return pool.take();
    }

    public void releaseConnection(Integer conn) {
        pool.offer(conn);
    }
}
