import java.time.LocalDate;
import java.util.List;

public class Manager extends Person{
    public Manager(String username, String password, int ID, String firstName, String lastName, LocalDate birthDate) {
        super(username, password, ID, firstName, lastName, birthDate);
    }

    @Override
    public void ShowCommands() {
        System.out.println("S. Display Students  | T. Display Teachers  | A. Add Students  | R. Display Reports  | X. Exit  |");
    }

    @Override
    String DisplayStudents() {
        return null;
    }

    @Override
    Person AddStudent(List<Person> persons) {
        return null;
    }

    @Override
    String DisplayReports() {
        return null;
    }

    @Override
    void reportDetails(Person person) {

    }

    @Override
    void updateReport() {

    }
}