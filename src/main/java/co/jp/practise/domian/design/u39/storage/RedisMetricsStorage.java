package co.jp.practise.domian.design.u39.storage;

import co.jp.practise.domian.design.u39.RequestInfo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RedisMetricsStorage implements MetricsStorage {

    //...省略属性和构造函数等...
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        //...
        System.out.println("saveRequestInfo");
    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimestamp, long endTimestamp) {
        //...
        System.out.println("getRequestInfos");
        return Collections.emptyList();
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimestamp, long endTimestamp) {
        //...
        System.out.println("getRequestInfos");
        return null;
    }
}