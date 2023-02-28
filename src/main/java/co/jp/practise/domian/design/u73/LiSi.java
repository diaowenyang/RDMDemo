package co.jp.practise.domian.design.u73;

/**
 * 4.具体同事类
 */
public class LiSi extends Colleague {
    public LiSi(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("ConcreteColleague2 received: " + message);
    }

    @Override
    public void send(String message) {
        mediator.send(message, this);
    }
}
