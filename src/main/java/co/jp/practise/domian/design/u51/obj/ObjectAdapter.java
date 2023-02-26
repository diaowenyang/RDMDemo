package co.jp.practise.domian.design.u51.obj;

/**
 * 3.定义一个 对象适配器，它实现了目标接口，并将客户端希望使用的接口转换为现有接口
 */
public class ObjectAdapter implements Target {
    private final Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
