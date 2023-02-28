package co.jp.practise.domian.design.u73;

/**
 * 具体的中介者
 */
public class ConcreteMediator implements Mediator {
    private ZhangSan zhangSan;
    private LiSi liSi;

    public void setZhangSan(ZhangSan zhangSan) {
        this.zhangSan = zhangSan;
    }

    public void setLiSi(LiSi liSi) {
        this.liSi = liSi;
    }

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague == zhangSan) {
            liSi.receive(message);
        } else if (colleague == liSi) {
            zhangSan.receive(message);
        }
    }
}
