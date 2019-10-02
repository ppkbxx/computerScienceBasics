package student;

import java.sql.Statement;
import java.util.*;

//Ведомость
public class ControlSpreadsheet {
    private String teacherFullName;
    private String descipline;
    private String year;
    private Date date;
    private int semecter;
    private List<String> groups;
    private Map<Student, Assessment> assessmentMap;


    public ControlSpreadsheet (String descipline, String teacherFullName, Date date, int semecter, String year, List<String> groups) {
        this.descipline = descipline;
        this.teacherFullName = teacherFullName;
        this.date = date;
        this.semecter = semecter;
        this.year = year;
        assessmentMap = new TreeMap<>();
        this.groups = groups;
    }

    public String getTeacherFullName() {
        return teacherFullName;
    }
    public void setTeacherFullName(String teacherFullName) {
        this.teacherFullName = teacherFullName;
    }
    public String getDescipline() {
        return descipline;
    }
    public void setDescipline(String descipline) {
        this.descipline = descipline;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getSemecter() {
        return semecter;
    }
    public void setSemecter(int semecter) {
        this.semecter = semecter;
    }
    public List<String> getGroups() {
        return groups;
    }
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public Map<Student, Assessment> getAssessment() {
        Map<Student, Assessment> resultMap = new TreeMap<>();
        for(Student student : assessmentMap.keySet()) {
            resultMap.put(new Student(student), assessmentMap.get(student));
        }
        return resultMap;
    }

    public Map<Student, Assessment> getRecords() {
        Map<Student, Assessment> resultMap = new TreeMap<>();
        for (Student student : assessmentMap.keySet()) {
            resultMap.put(new Student(student), assessmentMap.get(student));
        }
        return resultMap;
    }

    public void addRecord (Student student, Assessment assessment) throws ControlSpreadsheetException {
        if (!groups.isEmpty() && !groups.contains(student.getGroup()))
            throw new ControlSpreadsheetException(EnumControlSheetException.WRONG_GROUP);
        assessmentMap.put(student, assessment);
    }

    public void removeRecord (Student student) {
        assessmentMap.remove(student);
    }

    public void changeRating (Student student, Assessment newAssessment) throws ControlSpreadsheetException {
        if (!assessmentMap.containsKey(student)) throw new ControlSpreadsheetException(EnumControlSheetException.NO_SUCH_STUDENT);
        assessmentMap.put(student, newAssessment);
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Ведомость по дисциплине" + descipline + "\n");
        s.append("Дата:" + date + "\n");
        s.append("Семестр:" + semecter + "\n");
        s.append("Учебный год:" + year + "\n");
        s.append("Преподаватель:" + teacherFullName + "\n");
        s.append("____________________________________________________________________________________________");
        for (Student student : assessmentMap.keySet()){
            s.append("\n" + student + " - ");
            s.append(assessmentMap.get(student));
        }
        s.append("____________________________________________________________________________________________");

        return s.toString();
    }

    public void add(ControlSpreadsheet controlSpreadsheets) {
    }

    private char[] teacherFullName() { return teacherFullName();
    }

    /*
    @Override
    public int compareTo(Statement o) {
        int result = getDescipline().compareTo(o.getDescipline());
        if (result == 0){
            return getDate().compareTo(o.getDate());
        }
        else {
            return result;
        }
    }

     */
}
