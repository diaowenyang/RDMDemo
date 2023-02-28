package co.jp.practise.domian.design.u60;

/**
 * 2.策略的具体实现A
 */
public class ConcreteStrategyA implements Strategy {
    @Override
    public void executeStrategy() {
        System.out.println("Strategy A is executed.");
    }
}
