import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Student extends Person {
    private String group;
    private int java;
    private int cSharp;
    private int python;
    private int php;
    public Student(String username, String password, int ID, String firstName, String lastName, LocalDate birthDate, String group, int java, int cSharp, int python, int php) {
        super(username, password, ID, firstName, lastName, birthDate);
        this.group = group;
        this.java = java;
        this.cSharp = cSharp;
        this.python = python;
        this. php = php;
    }

    @Override
    String DisplayStudents() {
        return String.format("%5s, %10s", super.DisplayPerson(), group);
    }
    Person AddStudent(List<Person> persons) {
        return null;
    }

    @Override
    String DisplayReports() {
        return String.format("%1s, %7s, %7s, %7s, %7s", DisplayStudents(), java, cSharp, python, php);
    }

    @Override
    void reportDetails(Person person) {
        System.out.println();
        person.reportInfo(person);
        System.out.println();
        System.out.printf("%20s%n", "COURSES");
        System.out.println();
        System.out.printf("%10s %20s%n", "Java", java);
        System.out.printf("%10s %20s%n", "CSharp", cSharp);
        System.out.printf("%10s %20s%n", "Python", python);
        System.out.printf("%10s %20s%n", "PHP", php);
        System.out.println();
        System.out.printf("%20s%n", "RESULTS");
        System.out.println();
        String result = "";
        int retakes = 0;
        if ((java + cSharp + python + php) / 4 < 55) result = "Not Passed";
        else result = "Passed";
        if (java < 55) retakes++;
        if (cSharp < 55) retakes++;
        if (python < 55) retakes++;
        if (php < 55) retakes++;
        System.out.printf("%10s %20s%n", "Result", result);
        System.out.printf("%10s %20s%n", "Retakes", retakes);
    }

    @Override
    void updateReport() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Current grade Java is: " + java + " Enter (new) grade: ");
        java = scanner.nextInt();
        System.out.print("Current grade CSharp is: " + cSharp + " Enter (new) grade: ");
        cSharp = scanner.nextInt();
        System.out.print("Current grade Python is: " + python + " Enter (new) grade: ");
        python = scanner.nextInt();
        System.out.print("Current grade PHP is: " + php + " Enter (new) grade: ");
        php = scanner.nextInt();
        System.out.println();
    }
}
