package co.jp.practise.domian.design.u70;

/**
 * 2.定义原始对象类
 * 创建并在Memento对象中存储状态
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
