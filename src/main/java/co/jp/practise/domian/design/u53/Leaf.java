package co.jp.practise.domian.design.u53;

/**
 * 3.叶子节点
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void otherMethod() {
        System.out.println("name: " + name);

    }

    @Override
    public void addChild(Component component) {
        throw new UnsupportedOperationException("叶子节点没有子节点");
    }

    @Override
    public void removeChild(Component component) {
        throw new UnsupportedOperationException("叶子节点没有子节点");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("叶子节点没有子节点");
    }
}
