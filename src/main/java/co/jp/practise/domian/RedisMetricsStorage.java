package co.jp.practise.domian;

import co.jp.practise.bo.RequestInfo;
import co.jp.practise.domian.abs.MetricsStorage;

import java.util.List;
import java.util.Map;

/**
 * redis实现
 */
public class RedisMetricsStorage implements MetricsStorage {
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {

    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
        return null;
    }
}
