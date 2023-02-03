package co.jp.practise.bo;


import lombok.Data;

@Data
public class RequestInfo {
    private String apiName;

    private double responseTime;

    private long timestamp;
}
