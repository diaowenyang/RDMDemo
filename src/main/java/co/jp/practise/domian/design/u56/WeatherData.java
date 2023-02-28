package co.jp.practise.domian.design.u56;

import java.util.ArrayList;

/**
 * 具体主题类
 */
public class WeatherData implements Subject {
    // 观察者集合
    private final ArrayList<Observer> observers;
    // 温度
    private float temperature;
    // 气压
    private float pressure;
    // 湿度
    private float humidity;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    // 当数据更新时，就调用 setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }

    public void dataChange() {
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        // 增加观察者
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        // 移除观察者
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {

        observers.forEach(e -> {
            e.update(this.temperature, this.pressure, this.humidity);
        });
    }
}
