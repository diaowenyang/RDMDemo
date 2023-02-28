package co.jp.practise.domian.design.u65;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体聚合类
 */
public class ConcreteAggregate implements Aggregate {
    private final List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(items);
    }
}
