package co.jp.practise.domian.design.u39.viewer;

import co.jp.practise.domian.design.u39.RequestStat;
import com.google.gson.Gson;

import java.util.Map;

public class ConsoleViewer implements StatViewer {

    /**
     * 输出到控制台
     *
     * @param requestStats
     * @param startTimeInMillis
     * @param endTimeInMillis
     */
    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis,
                       long endTimeInMillis) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}
