package co.jp.practise.domian.design.u56.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * 观察者类
 */
public class Observer {
    private final String name;

    public Observer(String name) {
        this.name = name;
    }

    /**
     * 这就是 guava EventBus 的注解
     * 当数据发生变化时，EventBus 会自动调用这个方法
     *
     * @param event
     */
    @Subscribe
    public void update(DataEvent event) {
        System.out.println(name + " received data: " + event.getData());
    }
}
