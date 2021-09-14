import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Person {
    private final String username;
    private final String password;
    private int ID;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int age;

    public Person(String username, String password, int ID, String firstName, String lastName, LocalDate birthDate) {
        this.username = username;
        this.password = password;
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = Period.between(birthDate, LocalDate.from(LocalDate.now())).getYears();
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void ShowCommands() {
        System.out.println("S. Display Students  | T. Display Teachers  | X. Exit  |");
    }

    public String DisplayPerson() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return String.format("%2s %10s %10s %10s %5s", ID, firstName, lastName, birthDate.format(formatter), age);
        //return ID + " " + firstName + " " + lastName + " " + birthDate.format(formatter) + " " + age;
    }

    public boolean checkUsernameExists(List<Person> persons, String input) {
        for (Person person : persons) {
            if (person.username.equals(input)) return true;
        }
        return false;
    }

    public Person checkID(List<Person> persons, int personID) {
        for (Person person : persons) {
            if (person.ID == personID && person.getClass().equals(Student.class)) return person;
        }
        return null;
    }

    public void reportInfo(Person person) {
        System.out.println("Report of student " + firstName + " " + lastName);
        System.out.println();
        System.out.printf("%10s %20s%n", "Student Id", ID);
        System.out.printf("%10s %20s%n", "First name", firstName);
        System.out.printf("%10s %20s%n", "Last name", lastName);
        System.out.printf("%10s %20s%n", "Age", age);
    }

    abstract String DisplayStudents();
    abstract Person AddStudent(List<Person> persons);
    abstract String DisplayReports();
    abstract void reportDetails(Person person);
    abstract void updateReport();
}
