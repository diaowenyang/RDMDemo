package co.jp.practise.controller;

import co.jp.practise.domian.Metrics;
import co.jp.practise.vo.UserVo;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class UserController {

    private Metrics metrics = new Metrics();

    public UserController() {
        metrics.startRepeatedReport(60, TimeUnit.SECONDS);
    }

    public void register(UserVo user) {
        long start = System.currentTimeMillis();
        metrics.recordTimestamp("register", start);
        // 这里调用service服务
        long spendTims = System.currentTimeMillis() - start;
        metrics.recordResponseTimes("register", spendTims);
    }

    public void login(String telephone, String password) {
        long start = System.currentTimeMillis();
        metrics.recordTimestamp("login", start);
        // 这里调用login服务
        long spendTims = System.currentTimeMillis() - start;
        metrics.recordResponseTimes("login", spendTims);
    }
}
