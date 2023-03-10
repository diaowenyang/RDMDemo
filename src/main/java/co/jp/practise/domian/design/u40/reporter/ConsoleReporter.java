package co.jp.practise.domian.design.u40.reporter;

import co.jp.practise.domian.design.u40.Aggregator;
import co.jp.practise.domian.design.u40.storage.MetricsStorage;
import co.jp.practise.domian.design.u40.viewer.StatViewer;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ConsoleReporter extends Reporter {

    private final ScheduledExecutorService executor;

    private Runnable runnable;
    private Future future;

    public ConsoleReporter(StatViewer viewer, Aggregator aggregator,
                           MetricsStorage metricsStorage) {
        super(viewer, aggregator, metricsStorage);
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }


    // 第4个代码逻辑：定时触发第1、2、3代码逻辑的执行；
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        if (runnable != null) {
            System.out.println("duplicate calls!");
            return;
        }
        runnable = () -> {
            long durationInMillis = durationInSeconds * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMillis = endTimeInMillis - durationInMillis;
            doReport(startTimeInMillis, endTimeInMillis);
        };
        executor.scheduleAtFixedRate(runnable, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}