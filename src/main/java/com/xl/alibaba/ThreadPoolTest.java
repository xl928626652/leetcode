package com.xl.alibaba;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName : ThreadPoolTest
 * @Author : Xulian
 * @Date : 2021/3/7 14:30
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + ": " + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
