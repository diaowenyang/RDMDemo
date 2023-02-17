package co.jp.practise.domian.design.u48;


import java.lang.reflect.Proxy;

public class ProxyFactory {

    public Object createProxy(Object proxyObject) {
        Class<?>[] interfaces = proxyObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxyObject);
        // 给目标对象 生成一个代理对象
        // 1. ClassLoader loader ： 指定当前目标对象使用的类加载器, 获取加载器的方法固定
        // 2. Class<?>[] interfaces: 目标对象实现的接口类型，使用泛型方法确认类型
        // 3. InvocationHandler handler : 表示的是当动态代理对象调用方法的时候会关联到哪一个InvocationHandler对象上，并最终由其调用。
        return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(), interfaces, handler);
    }
}
