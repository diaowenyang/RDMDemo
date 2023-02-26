package co.jp.practise.domian.design.u56;

/**
 * 具体的观察者 百度
 */
public class BaiduSite implements Observer {
    // 温度，气压，湿度
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float hunidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    //显示
    public void display() {
        System.out.println("*****百度 mTemperature: " + temperature + "*****");
        System.out.println("*****百度 mPressure: " + pressure + "*****");
        System.out.println("*****百度 mHumidity: " + humidity + "*****");
    }
}
