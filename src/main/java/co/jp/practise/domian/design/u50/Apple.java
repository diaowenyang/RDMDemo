package co.jp.practise.domian.design.u50;

/**
 * 2.具体的被装饰对象
 * 苹果类
 */
public class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}
