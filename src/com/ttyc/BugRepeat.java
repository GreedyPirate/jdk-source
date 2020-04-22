package com.ttyc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BugRepeat {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        for (int i = 0; i < 300; i++) {
            executor.execute(new ParentTask("parent task"));
        }
    }

    static class ParentTask implements Runnable {

        private List<SubTask> subTasks = new ArrayList<>();
        private String name;

        public ParentTask(String name) {
            this.name = name;
            for (int i = 0; i < 5; i++) {
                subTasks.add(new SubTask());
            }
        }

        @Override
        public void run() {
            CountDownLatch latch = new CountDownLatch(subTasks.size());
            for (SubTask task: subTasks) {
                task.process();
                latch.countDown();
            }
            try {
                latch.await();
                System.out.println(name + " finished ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class SubTask {
        public void process() {
            try {
                // 模拟慢查
                TimeUnit.SECONDS.sleep(5L);
                System.out.println("sub task executing ... at " + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
