package co.jp.practise.domian.design.u39.reporter;


import co.jp.practise.domian.design.u39.Aggregator;
import co.jp.practise.domian.design.u39.RequestInfo;
import co.jp.practise.domian.design.u39.RequestStat;
import co.jp.practise.domian.design.u39.storage.MetricsStorage;
import co.jp.practise.domian.design.u39.viewer.StatViewer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ConsoleReporter {

    private final MetricsStorage metricsStorage;
    private final ScheduledExecutorService executor;
    private final StatViewer viewer;
    private final Aggregator aggregator;

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * 第4个代码逻辑：定时触发第1、2、3代码逻辑的执行；
     *
     * @param periodInSeconds   间隔时间（秒）
     * @param durationInSeconds 查看当前时间之前的多长时间范围内的数据（秒）
     */
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // 第1个代码逻辑：根据给定的时间区间，从数据库中拉取数据；
                long durationInMillis = durationInSeconds * 1000;
                // 当前时间即结束时间
                long endTimeInMillis = System.currentTimeMillis();
                // 开始时间
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                // key:apiName value:当前时间范围内所有针对该接口的请求信息，按照 apiName 分组
                Map<String, List<RequestInfo>> requestInfos =
                        metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                // 各种接口统计数据的计算
                Map<String, RequestStat> stats = aggregator
                        .aggregate(requestInfos, durationInMillis);
                // 输出到console
                viewer.output(stats, startTimeInMillis, endTimeInMillis);
            }
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}