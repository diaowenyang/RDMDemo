package co.jp.practise.domian.design.u56.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * 具体主题类
 */
public class ConcreteSubject {
    private final EventBus eventBus = new EventBus();

    public void register(Object observer) {
        eventBus.register(observer);
    }

    public void unregister(Object observer) {
        eventBus.unregister(observer);
    }

    public void notifyObservers(Object data) {
        eventBus.post(new DataEvent(data));
    }
}
