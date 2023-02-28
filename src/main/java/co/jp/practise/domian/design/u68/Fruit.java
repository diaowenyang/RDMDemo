package co.jp.practise.domian.design.u68;

/**
 * 3.商品具体实现类
 */
public class Fruit extends Element {
    private final String type;
    private final double weight;

    public Fruit(String name, double price, String type, double weight) {
        super(name, price);
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
