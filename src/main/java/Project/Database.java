package Project;

import java.util.Scanner;

public class Database {

    private Scanner scanner;
    private Administrator administrator;

    public void addStudent() {
        System.out.println("First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Day of birth: ");
        int dayOfBirth = scanner.nextInt();
        System.out.println("Month of birth: ");
        int monthOfBirth = scanner.nextInt();
        System.out.println("Year of birth: ");
        int yearOfBirth = scanner.nextInt();
        System.out.println("Select char. T - technical student, H - humanitarian student, C - combined student.");
        boolean isTechnical = false;
        boolean isHumanitarian = false;
        boolean isCombined = false;
        if (scanner.next().charAt(0) == 'T') {
            isTechnical = true;
        } else if (scanner.next().charAt(0) == 'H') {
            isHumanitarian = true;
        } else if (scanner.next().charAt(0) == 'C') {
            isCombined = true;
        }
        if (isTechnical || isHumanitarian || isCombined) {
            administrator.addStudent(firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, isTechnical, isHumanitarian, isCombined);
            System.out.println("Student successfully added.");
        } else {
            System.out.println("Error occured, try it again.");
        }
    }

    public void markStudent() {
        System.out.println("Enter ID: ");
        int studentId = scanner.nextInt();
        System.out.println("Enter mark: ");
        int mark = scanner.nextInt();
        administrator.markStudent(studentId, mark);
        System.out.println("Student successfully marked.");
    }

    public void deleteStudent() {
        System.out.println("Enter ID: ");
        int studentId = scanner.nextInt();
        administrator.deleteStudent(studentId);
        System.out.println("Student successfully deleted.");
    }

    public void findStudent() {
        System.out.println("Enter ID: ");
        int studentId = scanner.nextInt();
        administrator.findStudent(studentId);
        System.out.println("Student successfully found. Info: \n");
    }

    public void getStudentInfo() {
        System.out.println("Enter ID: ");
        int studentId = scanner.nextInt();
        System.out.println("Student successfully found. Info: \n");
        administrator.getStudentInfo(studentId);
    }

    public void getAllStudents() {
        System.out.println("All students: \n");
        administrator.getAlphabetOrderOfStudents();
    }

    public void getAverageOfTechnicalStudents() {
        System.out.println("Average of technical students: \n");
        administrator.getAverageOfTechnicalStudents();
    }

    public void getAverageOfHumanitarianStudents() {
        System.out.println("Average of humanitarian students: \n");
        administrator.getAverageOfHumanitarianStudents();
    }

    public void getAverageOfAllStudents() {
        System.out.println("Average of all students: \n");
        administrator.getAverageOfAllStudents();
    }

    public void getCountOfTechnicalStudents() {
        System.out.println("There are " + administrator.getNumberOfTechnicalStudents() + " technical students.");
    }

    public void getCountOfHumanitarianStudents() {
        System.out.println("There are " + administrator.getNumberOfHumanitarianStudents() + " humanitarian students.");
    }

    public Database() {
        administrator = new Administrator();
        scanner = new Scanner(System.in);
    }
}
