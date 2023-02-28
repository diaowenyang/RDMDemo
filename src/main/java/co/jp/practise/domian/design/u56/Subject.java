package co.jp.practise.domian.design.u56;

/**
 * 3.主题接口
 */
public interface Subject {
    // 增加观察者
    void registerObserver(Observer observer);

    // 移除观察者
    void removeObserver(Observer observer);

    // 通知观察者
    void notifyObserver();
}
