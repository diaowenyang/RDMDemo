package co.jp.practise.domian.design.u48;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理对象,动态代理
 */
public class DynamicProxyHandler implements InvocationHandler {

    /**
     * 维护一个目标对象
     */
    private final Object proxyObject;

    /**
     * 构造器 ， 对target 进行初始化
     *
     * @param proxyObject
     */
    public DynamicProxyHandler(Object proxyObject) {
        this.proxyObject = proxyObject;
    }

    /**
     * 给目标对象 生成一个代理对象
     * 功能增强，这里用的jdk的动态代理
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("in proxy 调用制定方法之前实现");
        //反射机制调用目标对象的方法
        Object result = method.invoke(proxyObject, args);
        System.out.println("out proxy 调用制定方法之后实现 apiName:" + (proxyObject.getClass().getName() + ":" + method.getName()));
        return result;
    }
}
