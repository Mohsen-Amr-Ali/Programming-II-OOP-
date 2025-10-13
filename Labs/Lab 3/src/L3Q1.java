import java.util.Scanner;
import static java.lang.System.out;

class Person{
    private String name;
    private double salary;
    private Boolean is_working;
    private double monthly_expenses;
    private static final double default_salary = 1000;

    //----- constructors ------//

    public Person(String name){
        this.name = name;
        this.salary = 0;
        this.is_working = false;
        this.monthly_expenses = 0;
    }

    public Person(String name, double salary, Boolean is_working, double monthly_expenses){
        this.name = name;
        this.salary = salary;
        setIs_working(is_working);
        this.monthly_expenses = monthly_expenses;
    }

    //------- setters & getters --------//


    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Boolean getIs_working() {
        return is_working;
    }

    public double getMonthly_expenses() {
        return monthly_expenses;
    }

    public double getDefault_salary() {
        return default_salary;
    }
    //-----
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
        if(salary == 0 && this.is_working) this.salary = default_salary;
        else if(salary > 0 && !this.is_working) this.salary = 0;
    }

    public void setIs_working(Boolean is_working) {
        this.is_working = is_working;
        if(!is_working && this.salary !=0) this.salary = 0;
        else if(is_working && this.salary <= 0) this.salary = default_salary;
    }

    public void setMonthly_expenses(double monthly_expenses) {
        this.monthly_expenses = monthly_expenses;
    }


    //---------- methods ---------//
    public void printPerson(){
        out.printf("Person:\n-Name: %s\n-Salary: %.2f$\n-Is working: %B\n-Monthy expenses: %.2f$\n Net income: %.2f$",
                this.name, this.salary, this.is_working, this.monthly_expenses, this.netIncome());
    }

    public double netIncome(){
        return this.salary -
                this.monthly_expenses;
    }
}


public class L3Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // ===== Demonstration 1 =====
        out.println("Demonstration 1: Normal 4-parameter constructor (no conflicts)");
        out.println("Constructor: new Person(\"Alice\", 2500, true, 1200)");
        Person p1 = new Person("Alice", 2500, true, 1200);
        p1.printPerson();
        out.println("\n\nPress Enter to continue...");
        in.nextLine();


        // ===== Demonstration 2 =====
        out.println("Demonstration 2: Conflict in constructor — person not working but salary given");
        out.println("Constructor: new Person(\"Bob\", 2000, false, 800)");
        Person p2 = new Person("Bob", 2000, false, 800);
        p2.printPerson();
        out.println("\n\nPress Enter to continue...");
        in.nextLine();


        // ===== Demonstration 3 =====
        out.println("Demonstration 3: Using 1-parameter constructor and setters");
        out.print("Enter a name for the person: ");
        String name = in.nextLine();
        Person p3 = new Person(name);
        out.println("\nConstructor: new Person(\"" + name + "\")");
        p3.printPerson();

        out.println("\n\nNow setting is_working = true using setter...");
        p3.setIs_working(true);

        out.println("After setIs_working(true):");
        p3.printPerson();

        out.println("\nProgram finished.");
        in.close();
    }
}