import javax.crypto.spec.PSource;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Random random = new Random();
    private static String[] names = {"Оксана", "Олег", "Кирилл", "Владислав", "Илья" };
    private static String[] surnames = {"Михайлова", "Носовой", "Вилковой", "Постоянный", "Неимзенный"};
    private static String[] middlenames = {"Михайловна ", "Владиславовоич ", "Гешдальдович ", "Аримфмеев ", "Зарубинский "};

    public static Employee[] employees = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < employees.length; i++) {
            String fullName = surnames[random.nextInt(0, surnames.length)] + " " +
                    names[random.nextInt(0, names.length)] + " " +
                    middlenames[random.nextInt(0, middlenames.length)];
            employees[i] = new Employee(fullName, random.nextInt(1, 6), random.nextInt(50_000, 250_000));
        }
    }

    public static void main(String[] args) {
        initEmployees();
        printInformation();
        System.out.println("Сумма затрат на ЗП в месяц состовляет: " + countSumOfSalaries());;
        System.out.println("Сотрудник с минимальной ЗП - " + minEmployeeSalary());
        System.out.println("Сотрудник с максимальной ЗП - " + maxEmployeeSalary());
        System.out.println("Среднее значение зарплат - " + middleValueOfSalary());
        outFullNamesOfEmployees();

    }

    private static void printInformation() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    private static int countSumOfSalaries() {
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            count += employees[i].getSalary();
        }
        return count;
    }

    private static String minEmployeeSalary() {
        int min = 299_000;
        String employeeWirhMinSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                employeeWirhMinSalary = employees[i].getFullName();
            }
        }
        return employeeWirhMinSalary;
    }

    private static String maxEmployeeSalary() {
        int max = 0;
        String employeeWithMaxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                employeeWithMaxSalary = employees[i].getFullName();
            }
        }
        return employeeWithMaxSalary;
    }

    private static int middleValueOfSalary() {
        return countSumOfSalaries()/employees.length;
    }

    private static void outFullNamesOfEmployees() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getFullName());
        }
    }
}