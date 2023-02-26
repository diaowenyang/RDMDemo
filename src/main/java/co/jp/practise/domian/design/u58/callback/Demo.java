package co.jp.practise.domian.design.u58.callback;

public class Demo {
    public static void main(String[] args) {
        Caller caller = new Caller();
        Callback callback = new CallbackImpl();
        caller.doSomething(callback);
    }
}
