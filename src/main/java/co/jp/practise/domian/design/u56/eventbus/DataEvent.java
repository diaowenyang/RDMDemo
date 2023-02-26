package co.jp.practise.domian.design.u56.eventbus;

/**
 * 事件类DataEvent，它用于传递数据
 */
public class DataEvent {
    private final Object data;

    public DataEvent(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
