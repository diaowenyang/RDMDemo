package co.jp.practise.domian.design.u56;

public class Demo {
    public static void main(String[] args) {
        //创建一个WeatherData
        WeatherData weatherData = new WeatherData();

        //创建观察者
        BaiduSite baiduSite = new BaiduSite();
        SinaSite sinaSite = new SinaSite();

        //注册到weatherData
        weatherData.registerObserver(baiduSite);
        weatherData.registerObserver(sinaSite);
        //测试
        System.out.println("通知各个注册的观察者，看看信息");
        weatherData.setData(10f, 20f, 30f);
    }
}
