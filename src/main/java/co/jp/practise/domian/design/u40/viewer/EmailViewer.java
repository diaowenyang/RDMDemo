package co.jp.practise.domian.design.u40.viewer;

import co.jp.practise.domian.design.u40.EmailSender;
import co.jp.practise.domian.design.u40.RequestStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class EmailViewer implements StatViewer {

    private final EmailSender emailSender;
    private final List<String> toAddresses = new ArrayList<>();

    public EmailViewer() {
        emailSender = new EmailSender();
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis,
                       long endTimeInMills) {
        // TODO: 格式化为html格式，并且发送邮件
    }
}
