package co.jp.practise.domian.design.u50;


/**
 * 5.装饰器来增加对象的行为
 */
public class Demo {

    public static void main(String[] args) {
        Apple apple = new Apple();
        DealFruit dealFruit = new CocaColaDealFruit(apple);
        dealFruit.eat();
    }

}
