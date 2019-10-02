package test;

import org.junit.jupiter.api.Test;
import student.Assessment;
import student.ControlSpreadsheet;
import student.ControlSpreadsheetException;
import student.Student;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ControlSpreadsheetTest {
    private String descipline = "BCS";
    private String teacherFullName = "Ashaev I.V.";
    private int semecter = 8;
    private String year = "2019 - 2020";
    private Set<String> groups = new HashSet<>();
    private Date date = new Date();



    private Student student1 = new Student("Иван","IMIT","MMS");
    private Student student2 = new Student("Алиса","FKN","MAS");
    private Student student3 = new Student("Дмитрий","IMIT","MMS");
    private Student student4 = new Student("Анастасия","FilFak","MPB");



    public ControlSpreadsheet createStatement(){
        return new ControlSpreadsheet(descipline, teacherFullName, date, semecter, year, groups);
    }

    @Test
    public void testGet(){
        ControlSpreadsheet controlSpreadsheet = createControlSpreadsheet();

        assertEquals(descipline, controlSpreadsheet.getDescipline());
        assertEquals(teacherFullName, controlSpreadsheet.getTeacherFullName());
        assertEquals(semecter, controlSpreadsheet.getSemecter());
        assertEquals(date, controlSpreadsheet.getDate());
        assertEquals(year, controlSpreadsheet.getYear());

        Set<String> getGroups = controlSpreadsheet.getGroups();
        Map<Student, Assessment> assessments = controlSpreadsheet.getRecords();

        assertNotNull(getGroups);
        assertNotNull(assessments);
        assertTrue(getGroups.isEmpty());
        assertTrue(assessments.isEmpty());

    }

    @Test
    public void testShow() throws ControlSpreadsheetException {
        ControlSpreadsheet controlSpreadsheet = createControlSpreadsheet();
        controlSpreadsheet.addRecord(student1, Assessment.A);
        controlSpreadsheet.addRecord(student2, Assessment.FAIL);
        controlSpreadsheet.addRecord(student3, Assessment.ABSENCE);
        System.out.println(controlSpreadsheet);
    }

    @Test
    public void testAddCorectWithoutGroups() throws ControlSpreadsheetException {
        ControlSpreadsheet controlSpreadsheet = createControlSpreadsheet();

        controlSpreadsheet.addRecord(student1, Assessment.A);
        controlSpreadsheet.addRecord(student2, Assessment.FAIL);
        controlSpreadsheet.addRecord(student3, Assessment.ABSENCE);

        testCheckRecords(controlSpreadsheet);

    }

    @Test
    public void testAddCorrectWithGroups() throws ControlSpreadsheetException {
        ControlSpreadsheet controlSpreadsheet = createControlSpreadsheet();
        Set<String> groups = new HashSet<>();
        groups.add("MMS");
        groups.add("MAS");
        groups.add("MPB");
        controlSpreadsheet.setGroups((List<String>) groups);

        controlSpreadsheet.addRecord(student1, Assessment.A);
        controlSpreadsheet.addRecord(student2, Assessment.FAIL);
        controlSpreadsheet.addRecord(student3, Assessment.ABSENCE);

        testCheckRecords(controlSpreadsheet);

    }

    @Test(expected = ControlSpreadsheetException.class)
    public void testAddWrong() throws ControlSpreadsheetException {
        ControlSpreadsheet controlSpreadsheet = createControlSpreadsheet();
        Set<String> groups = new HashSet<>();
        groups.add("MMS");
        groups.add("MAS");
        groups.add("MBP");
        controlSpreadsheet.setGroups((List<String>) groups);

        controlSpreadsheet.addRecord(student1, Assessment.A);
        controlSpreadsheet.addRecord(student2, Assessment.FAIL);
        controlSpreadsheet.addRecord(student3, Assessment.ABSENCE);
        controlSpreadsheet.addRecord(student4, Assessment.NOTASSESSMENT);

        testCheckRecords(controlSpreadsheet);
    }

    public void testCheckRecords(ControlSpreadsheet controlSpreadsheet){
        Map<Student, Assessment> resultMap = controlSpreadsheet.getRecords();
        assertEquals(3,resultMap.size());

        assertTrue(resultMap.containsKey(student1));
        assertTrue(resultMap.containsKey(student2));
        assertTrue(resultMap.containsKey(student3));

        assertEquals(Assessment.A, resultMap.get(student1));
        assertEquals(Assessment.FAIL, resultMap.get(student2));
        assertEquals(Assessment.ABSENCE,resultMap.get(student3));
    }

    @Test
    public void testDelete() throws ControlSpreadsheetException {
        ControlSpreadsheet controlSpreadsheet = createControlSpreadsheet();

        controlSpreadsheet.addRecord(student1, Assessment.A);
        controlSpreadsheet.addRecord(student2, Assessment.FAIL);
        controlSpreadsheet.addRecord(student3, Assessment.ABSENCE);
        controlSpreadsheet.addRecord(student4, Assessment.ABSENCE);

        assertEquals(4, controlSpreadsheet.getRecords().size());

        controlSpreadsheet.deleteRecord(student4);

        testCheckRecords(controlSpreadsheet);
    }

    @Test
    public void testChangeCorrect() throws ControlSpreadsheetException {
        ControlSpreadsheet controlSpreadsheet = createControlSpreadsheet();

        controlSpreadsheet.addRecord(student1, Assessment.A);
        controlSpreadsheet.addRecord(student2, Assessment.NOTASSESSMENT);
        controlSpreadsheet.addRecord(student3, Assessment.ABSENCE);

        controlSpreadsheet.changeRating(student2, Assessment.FAIL);

        testCheckRecords(controlSpreadsheet);

    }

    @Test(expected = ControlSpreadsheetException.class)
    public void testChangeWrong() throws ControlSpreadsheetException {
        ControlSpreadsheet controlSpreadsheet = createControlSpreadsheet();

        controlSpreadsheet.addRecord(student1, Assessment.A);
        controlSpreadsheet.addRecord(student2, Assessment.NOTASSESSMENT);
        controlSpreadsheet.addRecord(student3, Assessment.ABSENCE);

        controlSpreadsheet.changeRating(student4, Assessment.FAIL);
    }

    @Test
    public void addStudentTwo() throws ControlSpreadsheetException {
        ControlSpreadsheet controlSpreadsheet = createControlSpreadsheet();

        controlSpreadsheet.addRecord(student1, Assessment.A);
        controlSpreadsheet.addRecord(student1, Assessment.FAIL);

        assertEquals(1, controlSpreadsheet.getRecords().size());
    }

    @Test
    public void testCorrectGetRecords() throws ControlSpreadsheetException {
        ControlSpreadsheet controlSpreadsheet = createControlSpreadsheet();

        controlSpreadsheet.addRecord(student1, Assessment.A);

        Map<Student,Assessment> resultMap = controlSpreadsheet.getRecords();

        resultMap.remove(student1);

        assertEquals(0, resultMap.size());
        assertEquals(1, controlSpreadsheet.getRecords().size());

        Student resultStudent = controlSpreadsheet.getRecords().keySet().iterator().next();

        assertEquals(resultStudent, student1);

        resultStudent.setName("Another");

        assertEquals("Another", resultStudent.getName());
        assertEquals("Иван", student1.getName());

    }

    @Test
    public void testCheckAlphabetOrder() throws ControlSpreadsheetException {
        ControlSpreadsheet controlSpreadsheet = createControlSpreadsheet();

        controlSpreadsheet.addRecord(student1, Assessment.A);
        controlSpreadsheet.addRecord(student2, Assessment.A);
        controlSpreadsheet.addRecord(student3, Assessment.A);
        controlSpreadsheet.addRecord(student4, Assessment.A);

        Map<Student, Assessment> resultRecords = controlSpreadsheet.getRecords();

        Iterator<Student> iter = resultRecords.keySet().iterator();
        assertEquals("Иван", iter.next().getName());
        assertEquals("Алиса", iter.next().getName());
        assertEquals("Дмитрий", iter.next().getName());
        assertEquals("Анастасия", iter.next().getName());

    }
}