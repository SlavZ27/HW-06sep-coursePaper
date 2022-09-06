public class Employee {

    public static int count = 0;       //счетчик
    private final int ID;
    private String firstName;               //имя
    private String midName;                 //отчество
    private String lastName;                //фамилия
    private int department;                 //принимает значения от 1 до 5
    private float salary;                     //зарплата

    public Employee(String firstName, String midName, String lastName, int department, int salary) {
        this.ID = count;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        count++;
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

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getId() {
        return ID;
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

    public float getSalary() {
        return salary;
    }
}
