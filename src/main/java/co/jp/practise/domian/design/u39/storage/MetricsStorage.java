package co.jp.practise.domian.design.u39.storage;

import co.jp.practise.domian.design.u39.RequestInfo;

import java.util.List;
import java.util.Map;

public interface MetricsStorage {

    /**
     * 存储请求的API响应信息
     * 1.apiName
     * 2.请求时长
     * 3.请求的时间戳
     *
     * @param requestInfo
     */
    void saveRequestInfo(RequestInfo requestInfo);

    /**
     * 获取指定时间范围内、指定接口的所有请求记录信息，直接返回LIST
     *
     * @param apiName
     * @param startTimeInMillis
     * @param endTimeInMillis
     * @return
     */
    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    /**
     * 获取指定时间范围内、指定接口的所有请求记录信息，按照接口名进行分组
     *
     * @param startTimeInMillis
     * @param endTimeInMillis
     * @return
     */
    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}


