package co.jp.practise.domian.design.u39.reporter;

import co.jp.practise.domian.design.u39.Aggregator;
import co.jp.practise.domian.design.u39.RequestInfo;
import co.jp.practise.domian.design.u39.RequestStat;
import co.jp.practise.domian.design.u39.storage.MetricsStorage;
import co.jp.practise.domian.design.u39.viewer.StatViewer;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

public class EmailReporter {

    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private final MetricsStorage metricsStorage;
    private final StatViewer viewer;
    private final Aggregator aggregator;
    private ScheduledExecutorService executor;


    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }


    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos =
                        metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);
                // TODO: 格式化为html格式，并且发送邮件
                viewer.output(stats, startTimeInMillis, endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }
}