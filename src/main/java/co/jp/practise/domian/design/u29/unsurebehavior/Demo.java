package co.jp.practise.domian.design.u29.unsurebehavior;

import java.util.Date;


public class Demo {

    public long calculateDelayDays(Date dueTime) {
        long currentTimestamp = getCurrentTimestamp();
        if (dueTime.getTime() >= currentTimestamp) {
            return 0;
        }
        long delayTime = currentTimestamp - dueTime.getTime();
        long delayDays = delayTime / (24 * 3600 * 1000L);
        return delayDays;
    }

    public long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }
}