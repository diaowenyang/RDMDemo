package co.jp.practise.domian.design.u53.deptTree;

/**
 * 1.抽象组件类 部门
 */
public abstract class Department {
    protected String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void print();
}
