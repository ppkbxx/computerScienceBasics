package student;

public class Student {
    //ФИО, факультет, группа, id
    private String firstName;
    private String surName;
    private String middleName;
    private String faculty;
    private Group group;
    private int id;


    public Group getGroup() {return group;}
    public void setGroup(Group group) {
        if (this.group != null) {
            this.group.getStudents();
        }
    }
}
