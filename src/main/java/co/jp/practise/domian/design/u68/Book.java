package co.jp.practise.domian.design.u68;

/**
 * 2.商品具体实现类
 */
public class Book extends Element {
    private final String author;
    private final int pages;

    public Book(String name, double price, String author, int pages) {
        super(name, price);
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public double accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
