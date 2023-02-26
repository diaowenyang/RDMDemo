package co.jp.practise.domian.design.u58.callback;

/**
 * 3.
 */
public class Caller {
    public void doSomething(Callback callback) {
        System.out.println("Caller is doing something.");
        // 调用回调方法
        callback.onCallback();
    }
}
