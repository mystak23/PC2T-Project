package Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Administrator {

    private HashMap<Integer, Student> listOfStudents;

    public void addStudent(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth, boolean isTechnicalStudent, boolean isHumanitarianStudent, boolean isCombinedStudent) {
        Student student = new Student (firstName, lastName, new Date (dayOfBirth, monthOfBirth, yearOfBirth), isTechnicalStudent, isHumanitarianStudent, isCombinedStudent);
        listOfStudents.put(student.getStudentId(), student);
    }

    public void deleteStudent(int studentId) {
        listOfStudents.remove(listOfStudents.get(studentId));
    }

    public String findStudent(int studentId) {
        String info = listOfStudents.get(studentId).toString();
        return info;
    }

    public void markStudent(int studentId, int mark) {
       try {
           if (mark < 0 && mark > 5) {
               throw new Exception("Cannot give such a mark.");
           } else {
               listOfStudents.get(studentId).addMark(mark);
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }

    public String getStudentInfo(int studentId) {
        String info = "";
        Student student = listOfStudents.get(studentId);
        if (student.isHumanitarianStudent()) {
            info = student.getZodiacSign();
        } else if (student.isTechnicalStudent()) {
            if (student.wasBornOnLeapYear()) {
                info = "Student was born on leap year.";
            } else {
                info = "Student was not born on leap year.";
            }
        } else {
            if (student.wasBornOnLeapYear()) {
                info = "Student was born on leap year.";
            } else {
                info = "Student was not born on leap year.";
            }
            info += " " + student.getZodiacSign();
        }
        return info;
    }

    public String getAlphabetOrderOfStudents() {
        ArrayList<String> names = new ArrayList<String>();
        String info = "";
        for (HashMap.Entry<Integer, Student> entry : listOfStudents.entrySet()) {
            names.add(entry.getValue().getLastName());
        }
        Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
        info = names.toString();
        return info;
    }

    public String getAverageOfTechnicalStudents() {
        String info = "";
        for (HashMap.Entry<Integer, Student> entry : listOfStudents.entrySet()) {
            if (entry.getValue().isTechnicalStudent()) {
                info += entry.getValue().getAverage() + " , ";
            }
        }
        return info;
    }

    public String getAverageOfHumanitarianStudents() {
        String info = "";
        for (HashMap.Entry<Integer, Student> entry : listOfStudents.entrySet()) {
            if (entry.getValue().isHumanitarianStudent()) {
                info += entry.getValue().getAverage() + " , ";
            }
        }
        return info;
    }

    public String getAverageOfAllStudents() {
        String info = "";
        for (HashMap.Entry<Integer, Student> entry : listOfStudents.entrySet()) {
            info += entry.getValue().getAverage() + " , ";
        }
        return info;
    }

    public int getNumberOfTechnicalStudents() {
        int sum = 0;
        for (HashMap.Entry<Integer, Student> entry : listOfStudents.entrySet()) {
            if (entry.getValue().isTechnicalStudent()) {
                sum++;
            }
        }
        return sum;
    }

    public int getNumberOfHumanitarianStudents() {
        int sum = 0;
        for (HashMap.Entry<Integer, Student> entry : listOfStudents.entrySet()) {
            if (entry.getValue().isHumanitarianStudent()) {
                sum++;
            }
        }
        return sum;
    }

    public Administrator() {
        listOfStudents = new HashMap<>();
    }

}