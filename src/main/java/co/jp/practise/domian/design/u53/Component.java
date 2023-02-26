package co.jp.practise.domian.design.u53;

/**
 * 1.抽象根节点
 */
public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void otherMethod();

    public abstract void addChild(Component component);

    public abstract void removeChild(Component component);

    public abstract Component getChild(int index);

}
