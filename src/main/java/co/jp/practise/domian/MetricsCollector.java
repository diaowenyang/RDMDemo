package co.jp.practise.domian;


import co.jp.practise.bo.RequestInfo;
import co.jp.practise.domian.abs.MetricsStorage;
import org.apache.commons.lang3.StringUtils;

/**
 * 负责提供API，来采集接口请求的原始数据
 */
public class MetricsCollector {
    /**
     * 基于接口实现
     */
    private MetricsStorage metricsStorage;

    /**
     * 依赖注入
     *
     * @param metricsStorage
     */
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    /**
     * 用一个函数代替最小原型中的两个函数
     *
     * @param requestInfo
     */
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
