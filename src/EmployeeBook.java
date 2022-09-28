import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {

    private Map<String, Employee> employees = new HashMap<>(Map.of());

    public EmployeeBook() {
    }

    private String getContainsKey(String firstName, String midName, String lastName) {
        return firstName + midName + lastName;
    }

    public void addEmployee(String firstName, String midName, String lastName, int department, float salary) {
        Employee tempEmployee = new Employee(firstName, midName, lastName, department, salary);
        if (employees.containsKey(getContainsKey(firstName, midName, lastName))) {
            System.out.println("Сотрудник " + tempEmployee.getLastName() + " уже есть");
            return;
        }
        employees.put(firstName + midName + lastName, tempEmployee);
        System.out.println("Сотрудник " + tempEmployee.getLastName() + " добавлен");
    }

    private Employee findEmployee(String firstName, String midName, String lastName) {
        return employees.get(getContainsKey(firstName, midName, lastName));
    }

    public void changeDepartment(String firstName, String midName, String lastName, int needDepartment) {
        Employee tempEmployee = findEmployee(firstName, midName, lastName);
        if (tempEmployee == null) {
            System.out.println("Сотрудник " + lastName + " не найден");
            return;
        }
        tempEmployee.setDepartment(needDepartment);
        System.out.println("Отдел сотрудника " + tempEmployee.getLastName() + " изменен");
    }

    public void changeSalary(String firstName, String midName, String lastName, float needSalary) {
        Employee tempEmployee = findEmployee(firstName, midName, lastName);
        if (tempEmployee == null) {
            System.out.println("Сотрудник " + lastName + " не найден");
            return;
        }
        tempEmployee.setSalary(needSalary);
        System.out.println("Зарплата сотрудника " + tempEmployee.getLastName() + " изменена");
    }

    public void delEmployee(String firstName, String midName, String lastName) {
        Employee tempEmployee = findEmployee(firstName, midName, lastName);
        if (tempEmployee == null) {
            System.out.println("Сотрудник " + lastName + " не найден");
            return;
        }
        employees.remove(getContainsKey(firstName, midName, lastName));
        System.out.println("Сотрудник " + lastName + " удалён");
    }


    public void indexSalary(int percent) {
        System.out.println("Индексирование ЗП всем" + " на " + percent + "%");
        for (Employee employee : employees.values()) {
            employee.setSalary(employee.getSalary() / 100 * 110);
        }
    }

    public void indexSalaryInDepartment(int department, int percent) {
        System.out.println("Индексирование ЗП отделу " + department + " на " + percent + "%");
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() / 100 * 110);
            }
        }
    }

    public void printMaxSalaryEmployee() {
        Employee tempEmpl = getMaxSalaryEmployee();
        if (tempEmpl != null) {
            System.out.println("Сотрудник с максимальной ЗП " + tempEmpl.getSalary() + ": "
                    + tempEmpl.getLastName());
        }
    }

    private Employee getMaxSalaryEmployee() {
        if (employees.size() == 0) {
            return null;
        }

        Employee tempEmpl = new Employee("","","",0,0);
        for (Employee employee : employees.values()) {
            if (employee.getSalary() > tempEmpl.getSalary()) {
                tempEmpl = employee;
            }
        }
        return tempEmpl;
    }

    public void printMaxSalaryEmployeeInDepartment(int department) {
        Employee tempEmpl = getMaxSalaryEmployeeInDepartment(department);
        if (tempEmpl != null) {
            System.out.println("Сотрудник с максимальной ЗП " + tempEmpl.getSalary()
                    + ", в отделе " + tempEmpl.getDepartment() + ": "
                    + tempEmpl.getLastName());
        }
    }

    private Employee getMaxSalaryEmployeeInDepartment(int department) {
        if (employees.size() == 0) {
            return null;
        }
        Employee tempEmpl = null;                          //поиск работника в отделе
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                tempEmpl = employee;
                break;
            }
        }

        if (tempEmpl == null) {
            System.out.println("В отделе нет сотрудников");
            return null;
        }

        for (Employee employee : employees.values()) {
            if (employee.getSalary() > tempEmpl.getSalary()) {
                tempEmpl = employee;
            }
        }

        return tempEmpl;
    }

    public void printMinSalaryEmployeeInDepartment(int department) {
        Employee tempEmpl = getMinSalaryEmployeeInDepartment(department);
        if (tempEmpl != null) {
            System.out.println("Сотрудник с минимальной ЗП " + tempEmpl.getSalary()
                    + ", в отделе " + tempEmpl.getDepartment() + ": "
                    + tempEmpl.getLastName());
        }
    }

    private Employee getMinSalaryEmployeeInDepartment(int department) {
        if (employees.size() == 0) {
            return null;
        }
        Employee tempEmpl = null;                          //поиск работника в отделе
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                tempEmpl = employee;
                break;
            }
        }

        if (tempEmpl == null) {
            System.out.println("В отделе нет сотрудников");
            return null;
        }

        for (Employee employee : employees.values()) {
            if (employee.getSalary() < tempEmpl.getSalary()) {
                tempEmpl = employee;
            }
        }

        return tempEmpl;
    }

    public float getMidSalaryPerMonth() {
        if (employees.size() == 0) {
            return 0;
        }
        float sumSalary = 0;
        for (Employee employee : employees.values()) {
            sumSalary = sumSalary + employee.getSalary();
        }
        return sumSalary / employees.size();
    }

    public float getSumSalaryPerMonth() {
        if (employees.size() == 0) {
            return 0;
        }
        float sumSalary = 0;
        for (Employee employee : employees.values()) {
            sumSalary = sumSalary + employee.getSalary();
        }
        return sumSalary;
    }

    public float getMidSalaryPerMonthInDepartment(int department) {
        if (employees.size() == 0) {
            return 0;
        }
        float sumSalary = 0;
        int sumEmployees = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                sumSalary = sumSalary + employee.getSalary();
                sumEmployees++;
            }
        }
        return sumSalary / sumEmployees;
    }


    public float getSumSalaryPerMonthInDepartment(int department) {
        if (employees.size() == 0) {
            return 0;
        }
        float sumSalary = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        return sumSalary;
    }

    public void printAllFullName() {
        System.out.println("Печать ФИО сотрудников");
        for (Employee employee : employees.values()) {
            System.out.println(employee.getFirstName() + " "
                    + employee.getMidName() + " "
                    + employee.getLastName());
        }
    }

    public void printAllEmployees() {
        System.out.println("Печать всей информации сотрудников");
        for (Employee employee : employees.values()) {
            System.out.println(employee.toString());
        }
    }

    public void printAllEmployeesInDepartment(int department) {
        System.out.println("Печать всей информации сотрудников отдела " + department);
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                System.out.println("Employee{" + "firstName='" + employee.getFirstName() + '\''
                        + ", midName='" + employee.getMidName() + '\''
                        + ", lastName='" + employee.getLastName() + '\''
                        + ", salary=" + employee.getSalary() + "}");
            }
        }
    }

    public void printAllDepartment() {
        System.out.println("Печать ФИО сотрудников по отделам");
        for (int j = 1; j < Employee.COUNT_DEPARTMENT; j++) {
            System.out.println("Печать сотрудников отдела " + j);
            for (Employee employee : employees.values()) {
                if (employee.getDepartment() == j) {
                    System.out.println("Employee{" + "firstName='" + employee.getFirstName() + '\''
                            + ", midName='" + employee.getMidName() + '\''
                            + ", lastName='" + employee.getLastName());
                }
            }
        }
    }


    public void printAllEmployeesSalaryMoreNumber(int number) {
        System.out.println("Печать сотрудников с ЗП выше " + number);
        for (Employee employee : employees.values()) {
            if (employee.getSalary() >= number) {
                System.out.println("Employee{" + "ID='" + employee.getId() + '\''
                        + ", firstName='" + employee.getFirstName() + '\''
                        + ", midName='" + employee.getMidName() + '\''
                        + ", lastName='" + employee.getLastName() + '\''
                        + ", salary=" + employee.getSalary() + "}");

            }
        }
    }

    public void printAllEmployeesSalaryLessNumber(int number) {
        System.out.println("Печать сотрудников с ЗП меньше " + number);
        for (Employee employee : employees.values()) {
            if (employee.getSalary() < number) {
                System.out.println("Employee{" + "ID='" + employee.getId() + '\''
                        + ", firstName='" + employee.getFirstName() + '\''
                        + ", midName='" + employee.getMidName() + '\''
                        + ", lastName='" + employee.getLastName() + '\''
                        + ", salary=" + employee.getSalary() + "}");
            }
        }
    }
}
