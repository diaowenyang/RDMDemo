package co.jp.practise.domian.design.u53.deptTree;

public class Demo {
    public static void main(String[] args) {
        DepartmentImpl root = new DepartmentImpl("CEO");

        DepartmentImpl salesDepartment = new DepartmentImpl("Sales Department");
        Employee employee1 = new Employee("Alice");
        Employee employee2 = new Employee("Bob");
        salesDepartment.add(employee1);
        salesDepartment.add(employee2);

        DepartmentImpl marketingDepartment = new DepartmentImpl("Marketing Department");
        Employee employee3 = new Employee("Charlie");
        Employee employee4 = new Employee("David");
        marketingDepartment.add(employee3);
        marketingDepartment.add(employee4);

        root.add(salesDepartment);
        root.add(marketingDepartment);

        root.print();
    }
}
