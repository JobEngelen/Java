import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student extends Person {
    private String group;
    public Student(String username, String password, int ID, String firstName, String lastName, LocalDate birthDate, String group) {
        super(username, password, ID, firstName, lastName, birthDate);
        this.group = group;
    }

    public String DisplayStudents(Person person) {
        return super.DisplayPerson() + " " + group;
    }
}
