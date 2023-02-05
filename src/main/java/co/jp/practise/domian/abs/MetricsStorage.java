package co.jp.practise.domian.abs;

import co.jp.practise.bo.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * 负责原始数据存储，ReisMetricsStorage 类实现 MetricsStorage 接口
 * 可以扩展 MysqlMetricsStorage HBaseMetricsStorage等
 */
public interface MetricsStorage {

    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfosByDuration(String apiName, long startTimeInMillis, long endTimeInMillis);

    Map<String, List<RequestInfo>> getAllRequestInfosByDuration(long startTimeInMillis, long endTimeInMillis);

}
