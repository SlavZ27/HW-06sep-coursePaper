public class Main {

    public static void main(String[] args){

        EmployeeBook employeeBook = new EmployeeBook(10);

        int dep = 1;

        employeeBook.addEmployee("Ivan","Petrovich","Petrov",1,20001);
        employeeBook.addEmployee("Ivan","Petrovich","Petrov",1,20001);
        employeeBook.addEmployee("Oleg","Ivanovich","Krot",2,10002);
        employeeBook.addEmployee("Mariya","Olegovna","Kostrova",1,10003);
        employeeBook.addEmployee("Nikolai","Sidorovich","Harlamov",2,10004);
        employeeBook.addEmployee("Sergei","Nikolaevich","Melden",1,10005);

        employeeBook.printAllEmployees();
        System.out.println("+".repeat(100));

        employeeBook.delEmployee("Nikolai","Sidorovich","Harlamov");

        employeeBook.printAllEmployees();
        System.out.println("+".repeat(100));

        employeeBook.changeDepartment("Oleg","Ivanovich","Krot",3);

        employeeBook.printAllEmployees();
        System.out.println("+".repeat(100));

        employeeBook.changeSalary("Sergei","Nikolaevich","Melden", 20009);

        employeeBook.printAllEmployees();
        System.out.println("+".repeat(100));

        employeeBook.printAllDepartment();
        System.out.println("+".repeat(100));

        employeeBook.indexSalaryInDepartment(1, 10);

        employeeBook.printAllEmployees();
        System.out.println("+".repeat(100));

        employeeBook.indexSalary(10);

        employeeBook.printAllEmployees();
        System.out.println("+".repeat(100));

        employeeBook.printMaxSalaryEmployee();

        System.out.println("+".repeat(100));

        employeeBook.printMaxSalaryEmployeeInDepartment(3);

        System.out.println("+".repeat(100));

        employeeBook.printMinSalaryEmployeeInDepartment(3);

        System.out.println("+".repeat(100));

        System.out.println("Средняя ЗП за месяц по всем: " + employeeBook.getMidSalaryPerMonth());

        System.out.println("+".repeat(100));

        System.out.println("Сумма ЗП за месяц по всем: " + employeeBook.getSumSalaryPerMonth());

        System.out.println("+".repeat(100));

        System.out.println("Средняя ЗП за месяц по отделу " + dep + ": " + employeeBook.getMidSalaryPerMonthInDepartment(dep));

        System.out.println("+".repeat(100));

        System.out.println("Сумма ЗП за месяц по отделу " + dep + ": " + employeeBook.getSumSalaryPerMonthInDepartment(dep));

        System.out.println("+".repeat(100));

        employeeBook.printAllFullName();

        System.out.println("+".repeat(100));

        employeeBook.printAllEmployeesInDepartment(1);

        System.out.println("+".repeat(100));

        employeeBook.printAllEmployeesSalaryMoreNumber(15000);

        System.out.println("+".repeat(100));

        employeeBook.printAllEmployeesSalaryLessNumber(15000);

    }
}
