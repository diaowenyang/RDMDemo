package co.jp.practise.domian.design.u40.viewer;

import co.jp.practise.domian.design.u40.RequestStat;

import java.util.Map;


public interface StatViewer {

    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills);
}
