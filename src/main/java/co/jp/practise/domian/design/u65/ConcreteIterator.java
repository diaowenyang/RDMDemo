package co.jp.practise.domian.design.u65;


import java.util.List;

public class ConcreteIterator implements Iterator {
    private final List<String> items;
    private int position = 0;

    public ConcreteIterator(List<String> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return items.get(position++);
        }
        return null;
    }
}
