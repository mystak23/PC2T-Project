package Project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    private static final String NAME_OF_APPLICATION = "STUDENT DATABASE";
    private static final String WELCOME_MESSAGE = "\nWelcome to the student database application!";
    private static final String MENU = "1 - Add Student.\n2 - Delete Student.\n3 - Mark student.\n4 - Find Student.\n5 - Get Student Info\n"
            + "6 - Get All Students.\n7 - Get Average Of All Students.\n8 - Get Average Of All Technical Students.\n9 - Get Average Of All Humanitarian Students.\n"
            + "10 - Get Count Of Technical Students.\n11 - Get Count Of Humanitarian Students.\n12 - End program.\n";
    private static Scanner scanner;

    public static void runProgram() {
        System.out.println(WELCOME_MESSAGE);
        scanner = new Scanner(System.in);
        Database database = new Database();
        try {
            do {
                System.out.println(MENU);
                System.out.print("Your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: database.addStudent(); break;
                    case 2: database.deleteStudent(); break;
                    case 3: database.markStudent(); break;
                    case 4: database.findStudent(); break;
                    case 5: database.getStudentInfo(); break;
                    case 6: database.getAllStudents(); break;
                    case 7: database.getAverageOfAllStudents(); break;
                    case 8: database.getAverageOfTechnicalStudents(); break;
                    case 9: database.getAverageOfHumanitarianStudents(); break;
                    case 10: database.getCountOfTechnicalStudents(); break;
                    case 11: database.getCountOfHumanitarianStudents(); break;
                    case 12: return;
                    default:
                        System.out.print("Bad choice, try again: "); break;
                }
                System.out.println();
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println("Try again: ");
        }
    }

    public static void main(String[] args) {
        runProgram();
    }
}
