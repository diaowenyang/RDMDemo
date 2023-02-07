package co.jp.practise.business.design.u29;

import co.jp.practise.domian.design.u29.unsurebehavior.Demo;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static junit.framework.Assert.assertEquals;


public class TestDemo {

    @Test
    public void test() {

        Demo d = new Demo() {
            @Override
            public long getCurrentTimestamp() {
                Calendar c = Calendar.getInstance();
                c.set(2020, 1, 14);
                System.out.println(System.currentTimeMillis());
                System.out.println(c.getTimeInMillis());
                return c.getTimeInMillis();
            }
        };
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 1, 1);
        Date dueTime = calendar.getTime();
        long days = d.calculateDelayDays(dueTime);
        assertEquals(days, 13L);
    }
}
