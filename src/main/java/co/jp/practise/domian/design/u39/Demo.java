package co.jp.practise.domian.design.u39;


import co.jp.practise.domian.design.u39.factory.ReporterFactory;
import co.jp.practise.domian.design.u39.reporter.ConsoleReporter;
import co.jp.practise.domian.design.u39.storage.MetricsStorage;
import co.jp.practise.domian.design.u39.storage.MockRedisMetricsStorage;
import co.jp.practise.domian.design.u39.viewer.ConsoleViewer;


public class Demo {

    public static void main(String[] args) {
        MetricsStorage storage = new MockRedisMetricsStorage();
        ConsoleReporter consoleReporter = ReporterFactory.createConsoleReporter(storage);
        consoleReporter.startRepeatedReport(2, 2);

//    EmailReporter emailReporter = new EmailReporter(storage);
//    emailReporter.addToAddress("wangzheng@xzg.com");
//    emailReporter.startDailyReport();

        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    }

    //  @Test
    public void testConsoleReporter() {
        MetricsStorage storage = new MockRedisMetricsStorage();
        Aggregator aggregator = new Aggregator();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage, aggregator, new ConsoleViewer());
        consoleReporter.startRepeatedReport(2, 2);
        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));
    }

    //  @Test
    public void testEmailReporter() {
        MetricsStorage storage = new MockRedisMetricsStorage();
        Aggregator aggregator = new Aggregator();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage, aggregator, new ConsoleViewer());
        consoleReporter.startRepeatedReport(2, 2);
        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));
    }
}