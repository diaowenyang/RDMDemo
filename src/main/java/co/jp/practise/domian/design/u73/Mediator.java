package co.jp.practise.domian.design.u73;

/**
 * 1.中介接口
 */
public interface Mediator {
    void send(String message, Colleague colleague);
}
