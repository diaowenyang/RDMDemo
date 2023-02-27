package co.jp.practise.domian.design.u62;


public class HandlerB extends Handler {

    @Override
    public void handle() {
        boolean handled = false;
        if (!handled && successor != null) {
            System.out.println("---- HandlerB ");
            successor.handle();
        }
    }
}
