package co.jp.practise.domian.design.u68;

/**
 * 4.访问者接口
 */
public interface ShoppingCartVisitor {

    double visit(Book book);

    double visit(Fruit fruit);

    double getTotal();
}
