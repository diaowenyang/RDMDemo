package co.jp.practise.domian.design.u70;

/**
 * 1.定义备忘录类
 * 记录要恢复对象的状态
 */
public class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
