public class Main {

    public static void main(String[] args){

        EmployeeBook employeeBook = new EmployeeBook();

        int dep = 1;

        employeeBook.addEmployee("ivan","Petrovich","Petrov",1,20001);
        employeeBook.addEmployee("Ivan","Petrovich","Petrov",1,20001);
        employeeBook.addEmployee("OLEG","Ivanovich","Krot",2,10002);
        employeeBook.addEmployee("Mariya","Olegovna","Kostrova",1,10003);
        employeeBook.addEmployee("Nikolai","Sidorovich","Harlamov",2,10004);
        employeeBook.addEmployee("Sergei","Nikolaevich","Melden",1,10005);

        employeeBook.printAllEmployees();

        employeeBook.delEmployee("Nikolai","Sidorovich","Harlamov");

        employeeBook.changeDepartment("Oleg","Ivanovich","Krot",3);

        employeeBook.changeSalary("Sergei","Nikolaevich","Melden", 20009);

        employeeBook.printAllDepartment();

        employeeBook.indexSalaryInDepartment(1, 10);

        employeeBook.indexSalary(10);

        employeeBook.printMaxSalaryEmployee();

        employeeBook.printMaxSalaryEmployeeInDepartment(3);

        employeeBook.printMinSalaryEmployeeInDepartment(3);

        employeeBook.printAllEmployees();

        System.out.println("Средняя ЗП за месяц по всем: " + employeeBook.getMidSalaryPerMonth());

        System.out.println("Сумма ЗП за месяц по всем: " + employeeBook.getSumSalaryPerMonth());

        System.out.println("Средняя ЗП за месяц по отделу " + dep + ": " + employeeBook.getMidSalaryPerMonthInDepartment(dep));

        System.out.println("Сумма ЗП за месяц по отделу " + dep + ": " + employeeBook.getSumSalaryPerMonthInDepartment(dep));

        employeeBook.printAllFullName();

        employeeBook.printAllEmployeesInDepartment(1);

        employeeBook.printAllEmployeesSalaryMoreNumber(15000);

        employeeBook.printAllEmployeesSalaryLessNumber(15000);

    }
}
