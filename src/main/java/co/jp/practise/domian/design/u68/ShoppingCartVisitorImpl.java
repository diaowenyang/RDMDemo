package co.jp.practise.domian.design.u68;

/**
 * 5.访问者实现类
 */
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    private double total;

    @Override
    public double visit(Book book) {
        double price = book.getPrice();
        System.out.println("Book::Name = " + book.getName() + ", Author = " + book.getAuthor() + ", Pages = " + book.getPages() + ", Price = " + price);
        total += price;
        return price;
    }

    @Override
    public double visit(Fruit fruit) {
        double price = fruit.getPrice() * fruit.getWeight();
        System.out.println("Fruit::Name = " + fruit.getName() + ", Type = " + fruit.getType() + ", Weight = " + fruit.getWeight() + ", Price = " + price);
        total += price;
        return price;
    }

    @Override
    public double getTotal() {
        return total;
    }
}
