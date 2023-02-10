package co.jp.practise.domian.design.u40.reporter;


import co.jp.practise.domian.design.u40.Aggregator;
import co.jp.practise.domian.design.u40.RequestInfo;
import co.jp.practise.domian.design.u40.RequestStat;
import co.jp.practise.domian.design.u40.storage.MetricsStorage;
import co.jp.practise.domian.design.u40.viewer.StatViewer;

import java.util.List;
import java.util.Map;

public abstract class Reporter {

    protected StatViewer viewer;
    protected Aggregator aggregator;
    protected MetricsStorage metricsStorage;


    public Reporter(StatViewer viewer, Aggregator aggregator,
                    MetricsStorage metricsStorage) {
        this.viewer = viewer;
        this.aggregator = aggregator;
        this.metricsStorage = metricsStorage;
    }

    public void doReport(long startTimeInMillis, long endTimeInMillis) {
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos =
                metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> stats = aggregator
                .aggregate(requestInfos, durationInMillis);
        // console output
        viewer.output(stats, startTimeInMillis, endTimeInMillis);
    }
}
