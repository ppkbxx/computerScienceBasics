package student;

import student.Student;
import java.util.*;

public class summaryControlSpreadsheet {
    private Set<ControlSpreadsheet> controlSpreadsheets;
    private String year;
    private int semecter;
    private String group;
    private Map<Student,Row> table;
    private Set<String> subejcts;

    public summaryControlSpreadsheet(String year, int semecter, String group, TreeSet<ControlSpreadsheet> controlSpreadsheets) {
        this.controlSpreadsheets = controlSpreadsheets;
        this.year = year;
        this.semecter = semecter;
        this.group = group;
        table = new TreeMap<>();
        subejcts = new TreeSet<>();
    }
    public Set<ControlSpreadsheet> getControlSpreadsheets() {
        return controlSpreadsheets;
    }


    public void addControlSpreadsheet(ControlSpreadsheet controlSpreadsheets){
        if(isCorrectControlSpreadsheet(controlSpreadsheets)){
            controlSpreadsheets.add(controlSpreadsheets);
            this.build();
        }
    }

    public void setStatements(Set<ControlSpreadsheet> controlSpreadsheets) {
        this.controlSpreadsheets = controlSpreadsheets;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getSemecter() {
        return semecter;
    }

    public void setSemecter(int semecter) {
        this.semecter = semecter;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isCorrectControlSpreadsheet(ControlSpreadsheet controlSpreadsheets){
        return controlSpreadsheets.getSemecter() == getSemecter()
                && controlSpreadsheets.getYear().equals(getYear())
                &&
                (controlSpreadsheets.getGroups().contains(getGroup()) || controlSpreadsheets.getGroups().isEmpty());
    }
    public boolean isCorrectStudent(Student student){
        return student.getGroup().equals(getGroup());
    }

    public List<Assessment> getAssessment(Student student,String subject){
        return table.get(student).getAssessment(subject);
    }

    public Set<String> getSubejcts(){
        return new TreeSet<>(subejcts) ;
    }
    public Set<Student> getStudents(){
        return new TreeSet<>(table.keySet());
    }

    public void build(){
        for(ControlSpreadsheet controlSpreadsheets : controlSpreadsheets){
            if(isCorrectControlSpreadsheet(controlSpreadsheets)){
                subejcts.add(controlSpreadsheets.getDescipline());
                for(Student student : controlSpreadsheets.getRecords().keySet()){
                    if(isCorrectStudent(student)){
                        if(!table.containsKey(student)){
                            table.put(student, new Row());
                        }
                        table.get(student)
                                .add(controlSpreadsheets.getDescipline(), controlSpreadsheets.getDate(), controlSpreadsheets.getRecords().get(student)
                                );
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Сводная ведомость группы:");
        s.append(group);
        s.append("  За учебный год:");
        s.append(year);
        s.append("  Семестр:");
        s.append(semecter);
        s.append("\n");
        s.append("______________________________________________________");
        s.append("\n");
        s.append("| № | ФИО | ");
        for(String subject : subejcts){
            s.append(subject);
            s.append(" | ");
        }
        int count = 0;

        for(Student student : table.keySet()){
            s.append("\n");
            s.append(" | ");
            s.append(++count);
            s.append(" | ");
            s.append(student.getTeacherFullName());
            s.append(table.get(student).toString());
            s.append(" | ");
        }
        s.append("\n");
        s.append("_____________________________________________________");
        return s.toString();
    }
}
