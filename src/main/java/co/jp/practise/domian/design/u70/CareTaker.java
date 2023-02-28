package co.jp.practise.domian.design.u70;

import java.util.ArrayList;
import java.util.List;

/**
 * 3.备忘录管理类
 * 对象负责从Memento中恢复对象的状态
 */
public class CareTaker {
    private final List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
