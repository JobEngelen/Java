import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class mainApp {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        // Add students
        persons.add(new Student("emma", "emma12", 1, "Emma", "Smith", LocalDate.of(1997, 12, 4), "IT-02-A", 54, 50, 66, 54));
        persons.add(new Student("jack", "jack12", 2, "Jack", "Brown", LocalDate.of(1993, 8, 7), "IT-02-A", 72, 68, 43, 95));
        persons.add(new Student("michael", "michael12", 3, "Michael", "Garcia", LocalDate.of(1999, 11, 1), "IT-02-A", 45, 71, 55, 84));
        persons.add(new Student("lisa", "lisa12", 4, "Lisa", "Jones", LocalDate.of(2000, 4, 29), "IT-02-A", 98, 64, 81, 72));
        persons.add(new Student("john", "john12", 5, "John", "Miller", LocalDate.of(2001, 10, 27), "IT-02-A", 100, 94, 99, 93));
        persons.add(new Student("linda", "linda12", 6, "Linda", "Martinez", LocalDate.of(2002, 1, 17), "IT-02-A", 55, 79, 81, 55));
        persons.add(new Student("richard", "richard12", 7, "Richard", "Davis", LocalDate.of(1997, 9, 22), "IT-02-A", 51, 64, 39, 59));
        persons.add(new Student("mark", "mark12", 8, "Mark", "Lopez", LocalDate.of(1996, 12, 9), "IT-02-A", 78, 98, 89, 99));
        persons.add(new Student("debora", "debora12", 9, "Debora", "Hernandez", LocalDate.of(1995, 2, 25), "IT-02-A", 59, 55, 67, 99));
        persons.add(new Student("rick", "rick12", 10, "Rick", "Moore", LocalDate.of(2000, 3, 16), "IT-02-A", 96, 87, 55, 82));
        // Add teachers
        persons.add(new Teacher("david", "david12", 11, "David", "Taylor", LocalDate.of(1965, 6, 15)));
        persons.add(new Teacher("sophy", "sophy12", 12, "Sophy", "Anderson", LocalDate.of(1987, 1, 6)));
        persons.add(new Teacher("james", "james12", 13, "James", "Jordon", LocalDate.of(1956, 3, 19)));
        persons.add(new Teacher("susan", "susan12", 14, "Susan", "Jackson", LocalDate.of(1978, 12, 25)));
        persons.add(new Teacher("mary", "mary12", 15, "Mary", "Lee", LocalDate.of(1971, 9, 4)));
        // Add manager
        persons.add(new Manager("manny", "manny12", 16, "Manny", "Gerr", LocalDate.of(1973, 9, 2)));

        Person user = null;
        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false;
        do {
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            for (Person person : persons) {
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
                        System.out.printf("%2s %10s %10s %10s %5s, %8s%n", "Id", "Firstname", "Lastname", "Birthdate", "Age", "Group");
                        System.out.printf("%2s %10s %10s %10s %5s, %8s%n", "**", "*********", "********", "*********", "***", "*****");
                        for (Person person : persons) {
                            if (person.getClass().equals(Student.class)) System.out.println(person.DisplayStudents());
                        }
                        break;
                    case "t":
                        System.out.println(" LIST OF TEACHERS");
                        System.out.printf("%2s %10s %10s %10s %5s%n", "Id", "Firstname", "Lastname", "Birthdate", "Age");
                        System.out.printf("%2s %10s %10s %10s %5s%n", "**", "*********", "********", "*********", "***");
                        for (Person person : persons) {
                            if (person.getClass().equals(Teacher.class)) System.out.println(person.DisplayPerson());
                        }
                        break;
                    case "a":
                        if (user.getClass().equals(Teacher.class)) {
                            System.out.println();
                            System.out.println();
                            System.out.println(" ADD STUDENT");
                            System.out.println();
                            Person student = user.AddStudent(persons);
                            persons.add(student);
                        }
                        break;
                    case "r":
                        if (!user.getClass().equals(Student.class)) {
                            result:
                            do {
                                System.out.println(" STUDENT RESULTS");
                                System.out.printf("%2s %10s %10s %10s %5s, %8s, %8s, %8s, %8s, %8s%n", "Id", "Firstname", "Lastname", "Birthdate", "Age", "Group", "Java", "CSharp", "Python", "PHP");
                                System.out.printf("%2s %10s %10s %10s %5s, %8s, %8s, %8s, %8s, %8s%n", "**", "*********", "********", "*********", "***", "*****", "****", "******", "******", "***");
                                for (Person person : persons) {
                                    if (person.getClass().equals(Student.class)) System.out.println(person.DisplayReports());
                                }
                                System.out.println();
                                int inputID;
                                do {
                                    if (user.getClass().equals(Manager.class)) System.out.println(" Enter student id (Report Details)  | V. Save Reports  | Or 0 to go back to main menu: ");
                                    else System.out.println(" Enter student id (Report Details) | Or 0 to go back to main menu: ");
                                    String input = scanner.next();
                                    if (input.toLowerCase().equals("v")) {
                                        System.out.println("Dus uhh, nu horen die studenten-rapporten gesaved moeten worden in word-bestanden...");
                                    } else {
                                        inputID = Integer.parseInt(input);
                                        break;
                                    }

                                } while (true);
                                if (inputID == 0) {
                                    break;
                                } else {
                                    Person selectedStudent = user.checkID(persons, inputID);
                                    if (persons.contains(selectedStudent)) {
                                        selectedStudent.reportDetails(selectedStudent);
                                        updateResult:
                                        do {

                                            if (user.getClass().equals(Manager.class)) System.out.println("A. Add (Update) Report  | R. Display Reports  | V. Save reports  | B. Back to Main  | X. Exit  |");
                                            else System.out.println("A. Add (Update) Report  | R. Display Reports  | B. Back to Main  | X. Exit  |");
                                            System.out.println();
                                            System.out.print(" Select a menu: ");
                                            command = scanner.next();
                                            switch (command.toLowerCase()) {
                                                case "a":
                                                    selectedStudent.updateReport();
                                                    break;
                                                case "r":
                                                    break updateResult;
                                                case "v":
                                                    if (user.getClass().equals(Manager.class)) System.out.println("Dus uhh, nu horen die studenten-rapporten gesaved moeten worden in word-bestanden...");
                                                    break;
                                                case "b":
                                                    break result;
                                                case "x":
                                                    System.exit(0);
                                            }
                                        } while (true);
                                    } else System.out.println("Student with ID: '" + inputID + "' does not exist");
                                }
                            } while (true);
                            break;
                        }
                }
                System.out.println();
            }
        } while (true);
    }
}
