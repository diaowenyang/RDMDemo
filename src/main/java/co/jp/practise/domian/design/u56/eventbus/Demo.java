package co.jp.practise.domian.design.u56.eventbus;

public class Demo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer baidu = new Observer("baidu");
        Observer sina = new Observer("sina");
        subject.register(baidu);
        subject.register(sina);
        subject.notifyObservers("Data 1");
        subject.unregister(sina);
        subject.notifyObservers("Data 2");
    }
}
