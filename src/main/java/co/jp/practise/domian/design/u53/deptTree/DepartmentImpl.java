package co.jp.practise.domian.design.u53.deptTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 3.具体组件类：部门
 */
public class DepartmentImpl extends Department {
    private final List<Department> children;
    private final List<Employee> employees;

    public DepartmentImpl(String name) {
        super(name);
        children = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public void add(Department department) {
        children.add(department);
    }

    public void remove(Department department) {
        children.remove(department);
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void print() {
        System.out.println("Department:" + name);
        for (Department department : children) {
            department.print();
        }
        for (Employee employee : employees) {
            employee.print();
        }
    }


}
