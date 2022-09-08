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

        employeeBook.delEmployee("Nikolai","Sidorovich","Harlamov");

        employeeBook.printAllEmployees();

        employeeBook.changeDepartment("Oleg","Ivanovich","Krot",3);

        employeeBook.printAllEmployees();

        employeeBook.changeSalary("Sergei","Nikolaevich","Melden", 20009);

        employeeBook.printAllEmployees();

        employeeBook.printAllDepartment();

        employeeBook.indexSalaryInDepartment(1, 10);

        employeeBook.printAllEmployees();

        employeeBook.indexSalary(10);

        employeeBook.printAllEmployees();

        employeeBook.printMaxSalaryEmployee();


        employeeBook.printMaxSalaryEmployeeInDepartment(3);


        employeeBook.printMinSalaryEmployeeInDepartment(3);


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
