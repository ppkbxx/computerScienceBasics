package student;

import java.util.List;

//данные о студенте: ФИО, факультет, группа, id
public class Student {
    private String firstName;
    private String lastName;
    private String middleName;
    private String department;
    private List<String> groups;
    private int id;

    public Student(String firstName, String lastName, String middleName, String department, String group, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.department = department;
        this.groups = groups;
        this.id = id;
    }

    public Student(Student student) {

    }

    public String getStudent() {
        return lastName + " " + firstName + " " + middleName;}

    public String getDepartment() {
        return department;
    }

    public List<String> getGroup() {
        return groups;
    }

    public int getId() {
        return id;
    }


}
