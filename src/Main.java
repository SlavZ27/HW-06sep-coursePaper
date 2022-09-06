public class Main {

    public static void main(String[] args){

        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Ivan","Petrovich","Petrov",1,20001);
        employees[1] = new Employee("Oleg","Ivanovich","Krot",2,10002);
        employees[2] = new Employee("Mariya","Olegovna","Kostrov",1,10003);
        employees[3] = new Employee("Nikolai","Sidorovich","Harlamov",2,10004);
        employees[4] = new Employee("Sergei","Nikolaevich","Melden",1,10005);

        System.out.println("Сумма затрат на зарплаты в месяц: " + getSumSalaryPerMonth(employees));
        System.out.println("Сотрудник с минимальной зарплатой: " + getMinSalaryEmployee(employees));
        System.out.println("Сотрудник с максимальной зарплатой: " + getMaxSalaryEmployee(employees));
        System.out.println("Средняя зарплата всех сотрудников: " + getMidSalaryPerMonth(employees));
        printAllFullName(employees);

        printAllEmployees(employees);
        indexSalary(employees,10);
        System.out.println("===============");
        printAllEmployees(employees);

        int department = 2;
        System.out.println("Сотрудник отдела " + department + " с минимальной зарплатой: "
                + getMinSalaryEmployeeInDepartment(employees,department));
        System.out.println("Сотрудник отдела " + department + " с максимальной зарплатой: "
                + getMaxSalaryEmployeeInDepartment(employees,department));

        System.out.println("Сумма затрат на зарплаты отдела " + department + " в месяц: "
                + getSumSalaryPerMonthInDepartment(employees,department));

        System.out.println("Средняя зарплата всех сотрудников отдела: " + department + " в месяц: "
                + getMidSalaryPerMonthInDepartment(employees,department));

        System.out.println("===============");
        printAllEmployeesInDepartment(employees, department);
        indexSalaryInDepartment(employees,2,10);
        printAllEmployeesInDepartment(employees, department);


        System.out.println("===============");
        printAllEmployeesSalaryLessNumber(employees,15000);
        System.out.println("===============");
        printAllEmployeesSalaryMoreNumber(employees,15000);

    }

    public static void indexSalaryInDepartment(Employee[] employees, int department, int precent){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if(employees[i].department == department) {
                    employees[i].setSalary(employees[i].getSalary()/100*(100+precent));
                }
            } else {
                if (i == 0){
                    throw new IllegalArgumentException("Список сотрудников пуст.");
                }
                break;
            }
        }
    }

    public static void indexSalary(Employee[] employees, int precent){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary()/100*(100+precent));
            } else {
                if (i == 0){
                    throw new IllegalArgumentException("Список сотрудников пуст.");
                }
                break;
            }
        }
    }

    public static Employee getMaxSalaryEmployee(Employee[] employees){
        if (employees[0] == null){
            throw new IllegalArgumentException("Список сотрудников пуст.");
        } else {
            int indexEmployeeWithMaxSalary = 0;
            for (int i = 1; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (employees[i].getSalary() > employees[indexEmployeeWithMaxSalary].getSalary()) {
                        indexEmployeeWithMaxSalary = i;
                    }
                } else {
                    break;
                }
            }
            return employees[indexEmployeeWithMaxSalary];
        }
    }

    public static Employee getMinSalaryEmployee(Employee[] employees){
        if (employees[0] == null){
            throw new IllegalArgumentException("Список сотрудников пуст.");
        } else {
            int indexEmployeeWithMinSalary = 0;
            for (int i = 1; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (employees[i].getSalary() < employees[indexEmployeeWithMinSalary].getSalary()) {
                        indexEmployeeWithMinSalary = i;
                    }
                } else {
                    break;
                }
            }
            return employees[indexEmployeeWithMinSalary];
        }
    }

    public static Employee getMaxSalaryEmployeeInDepartment(Employee[] employees,int department){
        if (employees[0] == null){
            throw new IllegalArgumentException("Список сотрудников пуст.");
        } else {
            int indexEmployeeWithMinSalary = -1;    //поиск первого работника в отделе
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null){
                    if (employees[i].getDepartment() == department){
                        indexEmployeeWithMinSalary = i;
                        break;
                    }
                }
            }
            if (indexEmployeeWithMinSalary == -1){
                throw new IllegalArgumentException("Список сотрудников указанного отдела пуст.");
            } else {
                if (employees[indexEmployeeWithMinSalary+1] == null){
                    return employees[indexEmployeeWithMinSalary];
                } else {
                    for (int i = indexEmployeeWithMinSalary+1; i < employees.length; i++) {
                        if (employees[i] != null) {
                            if (employees[i].getDepartment() == department &&
                                    employees[i].getSalary() > employees[indexEmployeeWithMinSalary].getSalary()) {
                                indexEmployeeWithMinSalary = i;
                            }
                        } else {
                            break;
                        }
                    }
                    return employees[indexEmployeeWithMinSalary];
                }
            }
        }
    }

    public static Employee getMinSalaryEmployeeInDepartment(Employee[] employees,int department){
        if (employees[0] == null){
            throw new IllegalArgumentException("Список сотрудников пуст.");
        } else {
            int indexEmployeeWithMinSalary = -1;    //поиск первого работника в отделе
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null){
                    if (employees[i].getDepartment() == department){
                        indexEmployeeWithMinSalary = i;
                        break;
                    }
                }
            }
            if (indexEmployeeWithMinSalary == -1){
                throw new IllegalArgumentException("Список сотрудников указанного отдела пуст.");
            } else {
                if (employees[indexEmployeeWithMinSalary+1] == null){
                    return employees[indexEmployeeWithMinSalary];
                } else {
                    for (int i = indexEmployeeWithMinSalary+1; i < employees.length; i++) {
                        if (employees[i] != null) {
                            if (employees[i].getDepartment() == department &&
                                    employees[i].getSalary() < employees[indexEmployeeWithMinSalary].getSalary()) {
                                indexEmployeeWithMinSalary = i;
                            }
                        } else {
                            break;
                        }
                    }
                    return employees[indexEmployeeWithMinSalary];
                }
            }
        }
    }

    public static float getMidSalaryPerMonth(Employee[] employees){
        float sumSalary = 0;
        int i = 0;
        for (; i < employees.length; i++) {
            if (employees[i] != null){
                sumSalary = sumSalary + employees[i].getSalary();
            }else {
                if (i == 0){
                    throw new IllegalArgumentException("Список сотрудников пуст.");
                }
                break;
            }
        }
        return sumSalary / i;
    }

    public static float getSumSalaryPerMonth(Employee[] employees){
            float sumSalary = 0;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null){
                    sumSalary = sumSalary + employees[i].getSalary();
                }else {
                    break;
                }
            }
            return sumSalary;
    }

    public static float getMidSalaryPerMonthInDepartment(Employee[] employees,int department){
        float sumSalary = 0;
        int sumEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department){
                    sumSalary = sumSalary + employees[i].getSalary();
                    sumEmployees++;
                }
            }else {
                break;
            }
        }
        return sumSalary / sumEmployees;
    }


    public static float getSumSalaryPerMonthInDepartment(Employee[] employees,int department){
        float sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department){
                sumSalary = sumSalary + employees[i].getSalary();
                }
            }else {
                break;
            }
        }
        return sumSalary;
    }

    public static void printAllFullName(Employee[] employees){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFirstName() + " " +
                                    employees[i].getMidName() + " " +
                                    employees[i].getLastName());
            } else {
                if (i == 0){
                    throw new IllegalArgumentException("Список сотрудников пуст.");
                }
                break;
            }
        }
    }

    public static void printAllEmployees(Employee[] employees){
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    System.out.println(employees[i].toString());
                } else {
                    if (i == 0){
                        throw new IllegalArgumentException("Список сотрудников пуст.");
                    }
                    break;
                }
            }
    }

    public static void printAllEmployeesInDepartment(Employee[] employees, int department){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department) {
                    System.out.println("Employee{" +
                            "firstName='" + employees[i].firstName + '\'' +
                            ", midName='" + employees[i].midName + '\'' +
                            ", lastName='" + employees[i].lastName + '\'' +
                            ", salary=" + employees[i].salary +
                            "}");
                }
            } else {
                if (i == 0){
                    throw new IllegalArgumentException("Список сотрудников пуст.");
                }
                break;
            }
        }
    }

    public static void printAllEmployeesSalaryMoreNumber(Employee[] employees, int number){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() >= number) {
                    System.out.println("Employee{" +
                            "firstName='" + employees[i].firstName + '\'' +
                            ", midName='" + employees[i].midName + '\'' +
                            ", lastName='" + employees[i].lastName + '\'' +
                            ", salary=" + employees[i].salary +
                            "}");
                }
            } else {
                if (i == 0){
                    throw new IllegalArgumentException("Список сотрудников пуст.");
                }
                break;
            }
        }
    }

    public static void printAllEmployeesSalaryLessNumber(Employee[] employees, int number){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < number) {
                    System.out.println("Employee{" +
                            "ID='" + Employee.getId() + '\'' +
                            ", firstName='" + employees[i].firstName + '\'' +
                            ", midName='" + employees[i].midName + '\'' +
                            ", lastName='" + employees[i].lastName + '\'' +
                            ", salary=" + employees[i].salary +
                            "}");
                }
            } else {
                if (i == 0){
                    throw new IllegalArgumentException("Список сотрудников пуст.");
                }
                break;
            }
        }
    }

}
