package co.jp.practise.domian.design.u53;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.树枝节点
 */
public class Composite extends Component {
    private final List<Component> mLists = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void otherMethod() {
        System.out.println("name: " + name);
        if (mLists != null && mLists.size() > 0) {
            for (Component component : mLists) {
                component.otherMethod();
            }
        }
    }

    @Override
    public void addChild(Component component) {
        mLists.add(component);
    }

    @Override
    public void removeChild(Component component) {
        mLists.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return mLists.get(index);
    }
}
