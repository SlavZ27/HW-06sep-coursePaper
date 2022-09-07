public class EmployeeBook {

    private Employee[] employees;

    public EmployeeBook(int count) {
        if (count < 2) {
            throw new IllegalArgumentException("Нельзя сделать книгу объемом меньше двух");
        } else{
            this.employees = new Employee[count];
        }
    }

    public void addEmployee(String firstName, String midName, String lastName, int department, float salary) {
        int tempID = findEmployeeID(firstName, midName, lastName);
        if (tempID == -1) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (i + 1 == employees.length) {
                        throw new RuntimeException("Книга переполненна");
                    }
                } else {
                    employees[i] = new Employee(firstName, midName, lastName, department, salary);
                    System.out.println("Сотрудник " + employees[i].getLastName() + " добавлен");
                    break;
                }
            }
        } else {
            System.out.println("Сотрудник " + employees[tempID].getLastName() + " уже есть");
        }
    }

    private int findEmployeeID(String firstName, String midName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if ((employees[i].getFirstName().equals(firstName))
                        && (employees[i].getMidName().equals(midName))
                        && (employees[i].getLastName().equals(lastName))) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void changeDepartment(String firstName, String midName, String lastName, int needDepartment) {
        int tempID = findEmployeeID(firstName, midName, lastName);
        if (tempID != -1) {
            employees[tempID].setDepartment(needDepartment);
            System.out.println("Отдел сотрудника " + employees[tempID].getLastName() + " изменен");
        } else {
            System.out.println("Сотрудник " + lastName + " не найден");
        }
    }

    public void changeSalary(String firstName, String midName, String lastName, float needSalary) {
        int tempID = findEmployeeID(firstName, midName, lastName);
        if (tempID != -1) {
            employees[tempID].setSalary(needSalary);
            System.out.println("Зарплата сотрудника " + employees[tempID].getLastName() + " изменена");
        } else {
            System.out.println("Сотрудник " + lastName + " не найден");
        }
    }

    public void delEmployee(String firstName, String midName, String lastName) {
        int tempID = findEmployeeID(firstName, midName, lastName);
        if (tempID != -1) {
            String tempStr = employees[tempID].getLastName();
            employees[tempID] = null;
            System.out.println("Сотрудник " + tempStr + " удалён");
        } else {
            System.out.println("Сотрудник " + lastName + " не найден");
        }
    }


    public void indexSalaryInDepartment(int department, int precent) {
        System.out.println("Индексирование ЗП отделу " + department + " на " + precent + "%");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department) {
                    employees[i].setSalary(employees[i].getSalary() / 100 * (100 + precent));
                }
            }
        }
    }

    public void indexSalary(int precent) {
        System.out.println("Индексирование ЗП всем" + " на " + precent + "%");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() / 100 * (100 + precent));
            }
        }
    }

    public void printMaxSalaryEmployee(){
        Employee tempEmpl = getMaxSalaryEmployee();
        if (tempEmpl != null) {
            System.out.println("Сотрудник с максимальной ЗП " + tempEmpl.getSalary() + ": "
                    + tempEmpl.getLastName());
        }
    }

    private Employee getMaxSalaryEmployee() {
        int indexEmployeeWithMaxSalary = 0;
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > employees[indexEmployeeWithMaxSalary].getSalary()) {
                    indexEmployeeWithMaxSalary = i;
                }
            }
        }
        return employees[indexEmployeeWithMaxSalary];
    }

    public void printMaxSalaryEmployeeInDepartment(int department){
        Employee tempEmpl = getMaxSalaryEmployeeInDepartment(department);
        if (tempEmpl != null) {
            System.out.println("Сотрудник с максимальной ЗП " + tempEmpl.getSalary()
                    + ", в отделе " + tempEmpl.getDepartment() + ": "
                    + tempEmpl.getLastName());
        }
    }

    private Employee getMaxSalaryEmployeeInDepartment(int department) {
        int indexEmployeeWithMaxSalary = -1;    //поиск первого работника в отделе
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department) {
                    indexEmployeeWithMaxSalary = i;
                    break;
                }
            }
        }
        if (indexEmployeeWithMaxSalary == -1) {
            System.out.println("В отделе нет сотрудников");
        } else {
            for (int i = indexEmployeeWithMaxSalary + 1; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (employees[i].getDepartment() == department && employees[i].getSalary() >= employees[indexEmployeeWithMaxSalary].getSalary()) {
                        indexEmployeeWithMaxSalary = i;
                    }
                }
            }
            return employees[indexEmployeeWithMaxSalary];
        }
        return null;
    }

    public void printMinSalaryEmployeeInDepartment(int department){
        Employee tempEmpl = getMinSalaryEmployeeInDepartment(department);
        if (tempEmpl != null) {
            System.out.println("Сотрудник с минимальной ЗП " + tempEmpl.getSalary()
                    + ", в отделе " + tempEmpl.getDepartment() + ": "
                    + tempEmpl.getLastName());
        }
    }

    private Employee getMinSalaryEmployeeInDepartment(int department) {
        int indexEmployeeWithMinSalary = -1;    //поиск первого работника в отделе
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department) {
                    indexEmployeeWithMinSalary = i;
                    break;
                }
            }
        }
        if (indexEmployeeWithMinSalary == -1) {
            System.out.println("В отделе нет сотрудников");
        } else {
            for (int i = indexEmployeeWithMinSalary + 1; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (employees[i].getDepartment() == department && employees[i].getSalary() < employees[indexEmployeeWithMinSalary].getSalary()) {
                        indexEmployeeWithMinSalary = i;
                    }
                }
            }
            return employees[indexEmployeeWithMinSalary];
        }
        return null;
    }

    public float getMidSalaryPerMonth() {
        float sumSalary = 0;
        int count = 0;
        int i = 0;
        for (; i < employees.length; i++) {
            if (employees[i] != null) {
                sumSalary = sumSalary + employees[i].getSalary();
                count ++;
            }
        }
        return sumSalary / count;
    }

    public float getSumSalaryPerMonth() {
        float sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sumSalary = sumSalary + employees[i].getSalary();
            }
        }
        return sumSalary;
    }

    public float getMidSalaryPerMonthInDepartment(int department) {
        float sumSalary = 0;
        int sumEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department) {
                    sumSalary = sumSalary + employees[i].getSalary();
                    sumEmployees++;
                }
            }
        }
        return sumSalary / sumEmployees;
    }


    public float getSumSalaryPerMonthInDepartment(int department) {
        float sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department) {
                    sumSalary = sumSalary + employees[i].getSalary();
                }
            }
        }
        return sumSalary;
    }

    public void printAllFullName() {
        System.out.println("Печать ФИО сотрудников");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFirstName() + " " + employees[i].getMidName() + " " + employees[i].getLastName());
            }
        }
    }

    public void printAllEmployees() {
        System.out.println("Печать всей информации сотрудников");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public void printAllEmployeesInDepartment(int department) {
        System.out.println("Печать всей информации сотрудников отдела " + department);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department) {
                    System.out.println("Employee{" + "firstName='" + employees[i].getFirstName() + '\'' + ", midName='" + employees[i].getMidName() + '\'' + ", lastName='" + employees[i].getLastName() + '\'' + ", salary=" + employees[i].getSalary() + "}");
                }
            }
        }
    }

    public void printAllDepartment() {
        System.out.println("Печать ФИО сотрудников по отделам");
        for (int j = 1; j < Employee.COUNT_DEPARTMENT; j++) {
            System.out.println("Печать сотрудников отдела " + j);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (j == employees[i].getDepartment()) {
                        System.out.println("Employee{" + "firstName='" + employees[i].getFirstName() + '\''
                                + ", midName='" + employees[i].getMidName() + '\'' + ", lastName='" + employees[i].getLastName());
                    }
                }
            }
        }
    }

    public void printAllEmployeesSalaryMoreNumber(int number) {
        System.out.println("Печать сотрудников с ЗП выше " + number);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() >= number) {
                    System.out.println("Employee{" + "ID='" + employees[i].getId() + '\'' + ", firstName='" + employees[i].getFirstName() + '\'' + ", midName='" + employees[i].getMidName() + '\'' + ", lastName='" + employees[i].getLastName() + '\'' + ", salary=" + employees[i].getSalary() + "}");
                }
            }
        }
    }

    public void printAllEmployeesSalaryLessNumber(int number) {
        System.out.println("Печать сотрудников с ЗП меньше " + number);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < number) {
                    System.out.println("Employee{" + "ID='" + employees[i].getId() + '\'' + ", firstName='" + employees[i].getFirstName() + '\'' + ", midName='" + employees[i].getMidName() + '\'' + ", lastName='" + employees[i].getLastName() + '\'' + ", salary=" + employees[i].getSalary() + "}");
                }
            }
        }
    }



}
