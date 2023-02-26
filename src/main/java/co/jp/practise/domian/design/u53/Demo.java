package co.jp.practise.domian.design.u53;

public class Demo {
    private static Component constructTree() {
        //构造一个根节点
        Component root = new Composite("根节点 Root");

        //构造树枝节点
        Component branchA = new Composite("树枝节点 branchA");
        Component branchB = new Composite("树枝节点 branchB");

        //构造叶子节点
        Component leafA = new Leaf("叶子节点 leafA");
        Component leafB = new Leaf("叶子节点 LeafB");

        //将叶子节点添加至树枝节点中
        branchA.addChild(leafA);
        branchB.addChild(leafB);

        //将树枝节点添加进根节点
        root.addChild(branchA);
        root.addChild(branchB);

        return root;
    }

    public static void main(String[] args) {
        Component component = constructTree();
        component.otherMethod();
    }
}
