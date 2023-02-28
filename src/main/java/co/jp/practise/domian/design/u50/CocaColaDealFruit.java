package co.jp.practise.domian.design.u50;

/**
 * 4.具体的装饰器对象。在这里对装饰对象的功能进行增强。
 * 可口可乐水果加工厂
 */
public class CocaColaDealFruit extends DealFruit {

    public CocaColaDealFruit(Fruit fruit) {
        super(fruit);
    }

    @Override
    public void eat() {
        washFruilt();
        super.eat();
        clearUpRubbish();
    }

    public void washFruilt() {
        System.out.println("洗水果");
    }

    public void clearUpRubbish() {
        System.out.println("吃完要清理垃圾");
    }
}
