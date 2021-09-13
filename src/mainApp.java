import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class mainApp {
    public static void main(String[] args) {

        List<Person> Persons = new ArrayList<>();
        Persons.add(new Student("emma", "emma12", 1, "Emma", "Smith", LocalDate.of(1997, 12, 4), "IT-02-A"));
        Persons.add(new Student("jack", "jack12", 2, "Jack", "Brown", LocalDate.of(1993, 8, 7), "IT-02-A"));
        Persons.add(new Student("michael", "michael12", 3, "Michael", "Garcia", LocalDate.of(1999, 11, 1), "IT-02-A"));
        Persons.add(new Student("lisa", "lisa12", 4, "Lisa", "Jones", LocalDate.of(2000, 4, 29), "IT-02-A"));
        Persons.add(new Student("john", "john12", 5, "John", "Miller", LocalDate.of(2001, 10, 27), "IT-02-A"));
        Persons.add(new Student("linda", "linda12", 6, "Linda", "Martinez", LocalDate.of(2002, 1, 17), "IT-02-A"));
        Persons.add(new Student("richard", "richard12", 7, "Richard", "Davis", LocalDate.of(1997, 9, 22), "IT-02-A"));
        Persons.add(new Student("mark", "mark12", 8, "Mark", "Lopez", LocalDate.of(1996, 12, 9), "IT-02-A"));
        Persons.add(new Student("debora", "debora12", 9, "Debora", "Hernandez", LocalDate.of(1995, 2, 25), "IT-02-A"));
        Persons.add(new Student("rick", "rick12", 10, "Rick", "Moore", LocalDate.of(2000, 3, 16), "IT-02-A"));

        Persons.add(new Teacher("david", "david12", 11, "David", "Taylor", LocalDate.of(1965, 6, 15)));
        Persons.add(new Teacher("sophy", "sophy12", 12, "Sophy", "Taylor", LocalDate.of(1965, 6, 15)));
        Persons.add(new Teacher("james", "james12", 13, "James", "Taylor", LocalDate.of(1965, 6, 15)));

        Person user = null;
        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false;
        do {
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            for (Person person : Persons) {
                if (person.login(username, password)) {
                    user = person;
                    loggedIn = true;
                    break;
                }
            }
            if (!loggedIn) System.out.println(" ERROR: Wrong username or password");
        } while (!loggedIn);

        do {
            user.ShowCommands();
            System.out.println();
            System.out.print(" Please, enter a choice: ");
            String command = scanner.next();

            if (command.equalsIgnoreCase("x")) {
                System.out.println();
                System.out.println();
                System.out.println(" Leaving the program now...");
                break;
            }
            else {
                switch (command.toLowerCase()){
                    case "s":
                        System.out.println(" LIST OF STUDENTS");
                        for (Person person : Persons) {
                            if (person.getClass().equals(Student.class)) System.out.println(person.DisplayStudents(person));
                        }
                        break;
                    case "t":
                        System.out.println(" LIST OF TEACHERS");
                        for (Person person : Persons) {
                            if (person.getClass().equals(Teacher.class)) System.out.println(person.DisplayPerson());
                        }
                        break;
                }
                System.out.println();
            }

        } while (true);
    }
}
