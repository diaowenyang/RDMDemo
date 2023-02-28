package co.jp.practise.domian.design.u68;

/**
 * 1 商品抽象类
 */
public abstract class Element {
    private final String name;
    private final double price;

    public Element(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract double accept(ShoppingCartVisitor visitor);

}
