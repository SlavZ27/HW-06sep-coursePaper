import java.util.Objects;

public class Employee {

    public static int count = 0;       //счетчик
    private final int ID;
    private String firstName;               //имя
    private String midName;                 //отчество
    private String lastName;                //фамилия
    private int department;                 //принимает значения от 1 до 5

    public final static int COUNT_DEPARTMENT = 5;
    private float salary;                     //зарплата

    public Employee(String firstName, String midName, String lastName, int department, float salary) {
        this.ID = count;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ID == employee.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
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
        if ((department > 0) && (department < COUNT_DEPARTMENT)) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Отделы могут быть в диапазоне от 1 до 5");
        }
    }

    public void setSalary(float salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
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
