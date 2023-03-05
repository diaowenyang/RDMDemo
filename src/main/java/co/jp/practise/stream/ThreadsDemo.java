package co.jp.practise.stream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsDemo {

    public static void main(String[] args) throws Exception {
        oldHandle();
        newHandle();
    }

    public static void oldHandle() throws InterruptedException {
        for (int request = 0; request <= 100; request++) {
            new Thread(() -> {
                System.out.println("start");
                try {
                    // 模拟异步处理的内容
                    Thread.sleep(1000L * 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
            }).start();
        }
        // 为了避免主线程退出，需要主线程等待
        Thread.sleep(1000L * 1000);
    }

    public static void newHandle() throws InterruptedException {
        // 启动一个固定线程数量的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int request = 0; request <= 100; request++) {
            threadPool.execute(() -> {
                System.out.println("start");
                try {
                    // 模拟异步处理的内容
                    Thread.sleep(1000L * 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
            });
        }
        // 为了避免主线程退出，需要主线程等待
        Thread.sleep(1000L * 1000);
    }
}
