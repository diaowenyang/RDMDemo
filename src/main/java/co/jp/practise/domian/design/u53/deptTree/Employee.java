package co.jp.practise.domian.design.u53.deptTree;

/**
 * 2.具体组件类：雇员
 */
public class Employee extends Department {
    public Employee(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println("Employee: " + name);
    }
}
