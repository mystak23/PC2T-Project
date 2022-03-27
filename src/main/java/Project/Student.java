package Project;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Student {

    private int studentId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private boolean isTechnicalStudent;
    private boolean isHumanitarianStudent;
    private boolean isCombinedStudent;
    private ArrayList<Integer> marks;

    private static int ID_COUNT = 1;

    private enum ZODIAC {
        ARIES,
        TAURUS,
        GEMINI,
        CANCER,
        LEO,
        VIRGO,
        LIBRA,
        SCORPIO,
        SAGITTARIUS,
        CAPRICORN,
        AQUARIUS,
        PISCES
    }

    public int getAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        int average = sum / marks.size();
        return average;
    }

    public boolean wasBornOnLeapYear() {
        try {
            if (this.isHumanitarianStudent) {
                throw new Exception("Cannot find out.");
            } else {
                GregorianCalendar cal = new GregorianCalendar();
                if(cal.isLeapYear(this.dateOfBirth.getYear())) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void addMark(int mark) {
        marks.add(mark);
    }

    public String getZodiacSign() {
        String zodiacSign = "";
        try {
            if (!this.isTechnicalStudent) {
                if((this.dateOfBirth.getMonth() == 1) && (this.dateOfBirth.getDay() <= 20) || (this.dateOfBirth.getMonth() == 12) && (this.dateOfBirth.getDay() >= 22)) {
                    zodiacSign = ZODIAC.CAPRICORN.toString();
                } else if((this.dateOfBirth.getMonth() == 1) || (this.dateOfBirth.getMonth() == 2) && (this.dateOfBirth.getDay() <= 19)) {
                    zodiacSign = ZODIAC.AQUARIUS.toString();
                } else if((this.dateOfBirth.getMonth() == 2) || (this.dateOfBirth.getMonth() == 3) && (this.dateOfBirth.getDay() <= 20)) {
                    zodiacSign = ZODIAC.PISCES.toString();
                } else if((this.dateOfBirth.getMonth() == 3) || (this.dateOfBirth.getMonth() == 4) && (this.dateOfBirth.getDay() <= 19)) {
                    zodiacSign = ZODIAC.ARIES.toString();
                } else if((this.dateOfBirth.getMonth() == 4) || (this.dateOfBirth.getMonth() == 5) && (this.dateOfBirth.getDay() <= 21)) {
                    zodiacSign = ZODIAC.TAURUS.toString();
                } else if((this.dateOfBirth.getMonth() == 5) || (this.dateOfBirth.getMonth() == 6) && (this.dateOfBirth.getDay() <= 21)) {
                    zodiacSign = ZODIAC.GEMINI.toString();
                } else if((this.dateOfBirth.getMonth() == 6) || (this.dateOfBirth.getMonth() == 7) && (this.dateOfBirth.getDay() <= 23)) {
                    zodiacSign = ZODIAC.CANCER.toString();
                } else if((this.dateOfBirth.getMonth() == 7) || (this.dateOfBirth.getMonth() == 8) && (this.dateOfBirth.getDay() <= 23)) {
                    zodiacSign = ZODIAC.LEO.toString();
                } else if((this.dateOfBirth.getMonth() == 8) || (this.dateOfBirth.getMonth() == 9) && (this.dateOfBirth.getDay() <= 23)) {
                    zodiacSign = ZODIAC.VIRGO.toString();
                } else if((this.dateOfBirth.getMonth() == 9) || (this.dateOfBirth.getMonth() == 10) && (this.dateOfBirth.getDay() <= 23)) {
                    zodiacSign = ZODIAC.LIBRA.toString();
                } else if((this.dateOfBirth.getMonth() == 10) || (this.dateOfBirth.getMonth() == 11) && (this.dateOfBirth.getDay() <= 22)) {
                    zodiacSign = ZODIAC.SCORPIO.toString();
                } else if(this.dateOfBirth.getMonth() == 12) {
                    zodiacSign = ZODIAC.SAGITTARIUS.toString();
                }
            } else {
                throw new Exception("Cannot find out.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return zodiacSign;
    }

    public int getStudentId() {
        return studentId;
    }

    public boolean isTechnicalStudent() {
        return isTechnicalStudent;
    }

    public boolean isHumanitarianStudent() {
        return isHumanitarianStudent;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        final int prime = 596569;
        return (prime * studentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }
        Student student = (Student) obj;
        if (this.hashCode() == student.hashCode()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String info = studentId + "-" + firstName + "-" + lastName + "-" + dateOfBirth.toString();
        if (!marks.isEmpty()) {
            info += "-" + this.getAverage();
        }
        return info;
    }

    public Student(String firstName, String lastName, Date dateOfBirth, boolean isTechnicalStudent, boolean isHumanitarianStudent, boolean isCombinedStudent) {
        try {
            if ((isTechnicalStudent && isHumanitarianStudent) || (isTechnicalStudent && isCombinedStudent) || (isHumanitarianStudent && isCombinedStudent)) {
                throw new Exception("Cannot create such a student.");
            }
            this.studentId = ID_COUNT;
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.isTechnicalStudent = isTechnicalStudent;
            this.isHumanitarianStudent = isHumanitarianStudent;
            this.isCombinedStudent = isCombinedStudent;
            this.marks = new ArrayList<>();
            ID_COUNT++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
