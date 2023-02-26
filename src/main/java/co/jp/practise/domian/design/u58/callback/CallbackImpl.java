package co.jp.practise.domian.design.u58.callback;

/**
 * 2.回调函数具体实现类
 */
public class CallbackImpl implements Callback {
    @Override
    public void onCallback() {
        System.out.println("Callback is called.");
    }
}
