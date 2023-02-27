package co.jp.practise.domian.design.u50;

/**
 * 3.定义装饰器对象的抽象类
 * 水果加工厂
 */
public abstract class DealFruit implements Fruit {
    protected Fruit fruit;

    public DealFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public void eat() {
        fruit.eat();
    }
}
