package dz3;

public class Employee implements Comparable<Employee> {
    String name;
    String position;
    String phone;
    int salary;
    int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, String position, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println(
                "Имя: " + name + "\n" +
                        "Должность: " + position + "\n" +
                        "Телефон: " + phone + "\n" +
                        "Зарплата: " + salary + "\n" +
                        "Возраст: " + age + "\n"); ;
    }

    @Override
    public int compareTo(Employee o) {
        return this.getSalary() - o.getSalary();
    }
}
