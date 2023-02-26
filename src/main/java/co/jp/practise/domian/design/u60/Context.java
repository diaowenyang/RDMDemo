package co.jp.practise.domian.design.u60;

/**
 * 使用策略的类
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.executeStrategy();
    }
}
