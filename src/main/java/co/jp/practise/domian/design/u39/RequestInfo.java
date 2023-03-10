package co.jp.practise.domian.design.u39;


public class RequestInfo {

    /**
     * api名称
     */
    private String apiName;
    /**
     * 响应时间
     */
    private double responseTime;
    /**
     * 当时请求的时间戳
     */
    private long timestamp;
    //...省略constructor/getter/setter方法...


    public RequestInfo(String apiName, double responseTime, long timestamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timestamp = timestamp;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}