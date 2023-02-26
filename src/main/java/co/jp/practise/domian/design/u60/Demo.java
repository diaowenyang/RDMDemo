package co.jp.practise.domian.design.u60;

public class Demo {
    public static void main(String[] args) {
        Strategy a = new ConcreteStrategyA();
        Strategy b = new ConcreteStrategyB();
        Context context = new Context(a);
        context.execute();
        context = new Context(b);
        context.execute();
    }
}
