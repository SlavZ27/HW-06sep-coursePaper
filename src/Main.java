public class Main {

    public static void main(String[] args){

        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Ivan","Petrovich","Petrov",1,10001);
        employees[1] = new Employee("Oleg","Ivanovich","Krot",1,10002);
        employees[2] = new Employee("Mariya","Olegovna","Kostrov",1,10003);
        employees[3] = new Employee("Nikolai","Sidorovich","Harlamov",1,10004);
        employees[4] = new Employee("Sergei","Nikolaevich","Melden",1,10005);

        printAllEmployees(employees);
        System.out.println(getSumSalaryPerMonth(employees));
        System.out.println("Сотрудник с минимальной зарплатой: " + getMinSalaryEmployee(employees));
        System.out.println("Сотрудник с максимальной зарплатой: " + getMaxSalaryEmployee(employees));
        System.out.println("Средняя зарплата всех сотрудников: " + getMidSalaryPerMonth(employees));
        printAllFullName(employees);




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

    public static float getMidSalaryPerMonth(Employee[] employees){
        int sumSalary = 0;
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
        return (float)sumSalary / i;
    }

    public static int getSumSalaryPerMonth(Employee[] employees){
            int sumSalary = 0;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null){
                    sumSalary = sumSalary + employees[i].getSalary();
                }else {
                    if (i == 0){
                        throw new IllegalArgumentException("Список сотрудников пуст.");
                    }
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

}
