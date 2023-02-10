package co.jp.practise.domian.design.u40.factory;


import co.jp.practise.domian.design.u40.Aggregator;
import co.jp.practise.domian.design.u40.reporter.ConsoleReporter;
import co.jp.practise.domian.design.u40.storage.MetricsStorage;
import co.jp.practise.domian.design.u40.viewer.ConsoleViewer;

public class ReporterFactory {

    public static ConsoleReporter createConsoleReporter(MetricsStorage storage) {
        Aggregator aggregator = new Aggregator();
        return new ConsoleReporter(new ConsoleViewer(), aggregator, storage);
    }

}
