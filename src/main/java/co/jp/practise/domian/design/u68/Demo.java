package co.jp.practise.domian.design.u68;


public class Demo {
    public static void main(String[] args) {
        Element[] items = new Element[]{
                new Book("Effective Java", 29.99, "Joshua Bloch", 416),
                new Fruit("Banana", 1.99, "Cavendish", 0.5),
                new Fruit("Apple", 0.99, "Fuji", 0.25),
                new Book("Design Patterns", 35.99, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 395)
        };

        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        double total = 0;
        for (Element item : items) {
            total += item.accept(visitor);
        }
        System.out.println("Total Cost = " + visitor.getTotal());
    }
}
