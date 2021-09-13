import java.time.LocalDate;

public class Teacher extends Person{
    public Teacher(String username, String password, int ID, String firstName, String lastName, LocalDate birthDate) {
        super(username, password, ID, firstName, lastName, birthDate);
    }

    @Override
    public void ShowCommands() {
        System.out.println("S. Display Students  | T. Display Teachers  | A. Add Students  | R. Display Reports  | X. Exit  |");
    }

    @Override
    public String DisplayStudents(Person person) {
        return super.DisplayPerson();
    }
}
