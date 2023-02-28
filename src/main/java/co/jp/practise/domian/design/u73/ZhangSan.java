package co.jp.practise.domian.design.u73;

/**
 * 3.具体同事类
 */
public class ZhangSan extends Colleague {
    public ZhangSan(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("ZhangSan received: " + message);
    }

    @Override
    public void send(String message) {
        mediator.send(message, this);
    }
}
