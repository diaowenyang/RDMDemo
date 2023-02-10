package co.jp.practise.domian.design.u39;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Aggregator {

    /**
     * 统计接口的计算
     *
     * @param requestInfo      待计算的原始数据
     * @param durationInMillis 这批数据的时间范围(用来计算tps，即每个接口指定时间的吞吐量)
     * @return
     */
    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfo,
                                              long durationInMillis) {
        Map<String, RequestStat> result = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfo.entrySet()) {
            String apiName = entry.getKey();
            // 第2个代码逻辑：根据原始数据，分别计算每个接口的统计数据；
            RequestStat requestStat = doAggregate(entry.getValue(), durationInMillis);
            result.put(apiName, requestStat);
        }
        return result;
    }

    public RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        // 最长耗时
        double maxRespTime = Double.MIN_VALUE;
        // 最短耗时
        double minRespTime = Double.MAX_VALUE;
        // 平均耗时
        double avgRespTime = -1;
        // 指单位时间内（5分钟/10分钟都可），统计该方法每次调用所消耗的时间，并将这些时间按照从小到大的顺序进行排序，再根据【总次数 * 指标数 = 对应指标的TP序号】，
        // 再根据TP序号取出排序后的对应位置的时间，即为TP指标。
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;
        for (RequestInfo requestInfo : requestInfos) {
            ++count;
            double respTime = requestInfo.getResponseTime();
            if (maxRespTime < respTime) {
                maxRespTime = respTime;
            }
            if (minRespTime > respTime) {
                minRespTime = respTime;
            }
            sumRespTime += respTime;
        }
        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }
        long tps = count / durationInMillis * 1000;
        // 对接口响应结果进行排序
        Collections.sort(requestInfos, new Comparator<RequestInfo>() {
            @Override
            public int compare(RequestInfo o1, RequestInfo o2) {
                double diff = o1.getResponseTime() - o2.getResponseTime();
                if (diff < 0.0) {
                    return -1;
                } else if (diff > 0.0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int idx999 = (int) (count * 0.999);
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setCount(count);
        requestStat.setTps(tps);
        return requestStat;
    }
}

