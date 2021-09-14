import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Person{
    public Teacher(String username, String password, int ID, String firstName, String lastName, LocalDate birthDate) {
        super(username, password, ID, firstName, lastName, birthDate);
    }

    @Override
    public void ShowCommands() {
        System.out.println("S. Display Students  | T. Display Teachers  | A. Add Students  | R. Display Reports  | X. Exit  |");
    }

    @Override
    public String DisplayStudents() {
        return super.DisplayPerson();
    }

    public Person AddStudent(List<Person> persons) {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        boolean usernameTaken = true;
        do {
            System.out.print("Choose a username: ");
            username = scanner.next();
            if (super.checkUsernameExists(persons, username)) System.out.println("Username '" + username + "' is taken!");
            else usernameTaken = false;
        } while(usernameTaken);
        System.out.print("Choose a password: ");
        String password = scanner.next();
        int ID = persons.size() + 1;
        System.out.print("Enter a first name: ");
        String firstName = scanner.next();
        System.out.print("Enter a last name: ");
        String lastName = scanner.next();
        System.out.print("Please enter date of birth in MM/DD/YYYY: ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthDate = LocalDate.parse(scanner.next(), formatter);

        System.out.print("Enter group: ");
        String group = scanner.next();
        System.out.println("The data was successfully added!");
        return new Student(username, password, ID, firstName, lastName, birthDate, group, 0, 0, 0, 0);
    }

    @Override
    public String DisplayReports() {
        return null;
    }

    @Override
    void reportDetails(Person person) {

    }

    @Override
    void updateReport() {

    }
}
