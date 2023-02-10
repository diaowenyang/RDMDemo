package co.jp.practise.domian.design.u39.factory;


import co.jp.practise.domian.design.u39.Aggregator;
import co.jp.practise.domian.design.u39.reporter.ConsoleReporter;
import co.jp.practise.domian.design.u39.storage.MetricsStorage;
import co.jp.practise.domian.design.u39.viewer.ConsoleViewer;

public class ReporterFactory {

    /**
     * 定时根据给定的时间区间、从数据库中取出数据，借助Aggregator类完成统计工作，并把统计结果输出到命令行终端
     *
     * @param storage
     * @return
     */
    public static ConsoleReporter createConsoleReporter(MetricsStorage storage) {
        Aggregator aggregator = new Aggregator();
        return new ConsoleReporter(storage, aggregator, new ConsoleViewer());
    }

}
