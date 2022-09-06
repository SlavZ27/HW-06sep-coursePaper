public class Employee {

    public static int id = 0;       //счетчик
    String firstName;               //имя
    String midName;                 //отчество
    String lastName;                //фамилия
    int department;                 //принимает значения от 1 до 5
    int salary;                     //зарплата

    public Employee(String firstName, String midName, String lastName, int department, int salary) {
        id++;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", midName='" + midName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMidName() {
        return midName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}
