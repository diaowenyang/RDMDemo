package co.jp.practise.domian.design.u51.clz;

/**
 * 3.类适配器
 */
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}
