package Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Consumer;

public class Administrator {

    private HashMap<Integer, Student> listOfStudents;

    public void addStudent(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth, boolean isTechnicalStudent, boolean isHumanitarianStudent, boolean isCombinedStudent) {
        Student student = new Student (firstName, lastName, new Date (dayOfBirth, monthOfBirth, yearOfBirth), isTechnicalStudent, isHumanitarianStudent, isCombinedStudent);
        listOfStudents.put(student.getStudentId(), student);
    }

    public void deleteStudent(int studentId) {
        try {
            if (listOfStudents.containsKey(studentId)) {
                listOfStudents.remove(listOfStudents.get(studentId));
            } else {
                throw new Exception("No such student.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String findStudent(int studentId) {
        String info = "";
        try {
            if (listOfStudents.containsKey(studentId)) {
                info = listOfStudents.get(studentId).toString();
            } else {
                throw new Exception("No such student.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return info;
    }

    public void markStudent(int studentId, int mark) {
       try {
           if (mark < 0 || mark > 5) {
               throw new Exception("Cannot give such a mark.");
           } else {
               if (listOfStudents.containsKey(studentId)) {
                   listOfStudents.get(studentId).addMark(mark);
               } else {
                   throw new Exception("No such student.");
               }
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }

    public String getStudentInfo(int studentId) {
        String info = "";
        try {
            Student student = listOfStudents.get(studentId);
            if (!listOfStudents.containsKey(studentId)) {
                throw new Exception("No such student.");
            }
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return info;
    }

    public String getAlphabetOrderOfStudents() {
        ArrayList<String> names = new ArrayList<>();
        for (HashMap.Entry<Integer, Student> entry : listOfStudents.entrySet()) {
            names.add(entry.getValue().getLastName());
        }
        Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
        String info = names.toString();
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