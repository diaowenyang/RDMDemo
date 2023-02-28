package co.jp.practise.domian.design.u73;

/**
 * 2.抽象同事类
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive(String message);

    public abstract void send(String message);
}
