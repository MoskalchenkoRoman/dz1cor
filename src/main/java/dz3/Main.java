package dz3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Director("Леха",  "Director", "2222222", 50000, 32);
        Employee employee2 = new Employee("Саня",  "Manager", "3333333", 40000, 46);
        Employee employee3 = new Employee("Серега",  "Manager", "5555555", 40000, 52);
        Employee employee4 = new Employee("Вася",  "Manager", "4444444", 40000, 30);
        Employee employee5 = new Employee("Инокентий", "Secretary", "8888888", 30000, 35);

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        Director.salaryUp(employees);

        EmployeeComparator myEmployeeComporator = new EmployeeComparator();
        employees.sort(myEmployeeComporator);

        for (Employee employee : employees) {
            employee.printInfo();
        }
    }
}
