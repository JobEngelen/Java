import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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
        return ID + " " + firstName + " " + lastName + " " + birthDate.format(formatter) + " " + age;
    }

    abstract String DisplayStudents(Person person);
}
