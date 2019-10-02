package test;

import static org.junit.jupiter.api.Assertions.*;

import student.*;
import student.exceptions.StatementException;
import student.controlSpreadsheet.Assessment;
import student.controlSpreadsheet.ControlSpreadsheet;
import student.controlSpreadsheet.summaryControlSpreadsheet;
import org.junit.Before;
import org.junit.Test;

import java.beans.Statement;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class summaryControlSpreadsheetTest {

    private summaryControlSpreadsheet summaryControlSpreadsheetMMS;
    private summaryControlSpreadsheet summaryControlSpreadsheetMPB;

    @Before
    public void beforeTest(){
        List<summaryControlSpreadsheet> summaryControlSpreadsheets = createSummaryControlSpreadsheet();
        summaryControlSpreadsheetMMS = summaryControlSpreadsheet.get(0);
        summaryControlSpreadsheetMMS = summaryControlSpreadsheet.get(1);
    }


    private static final String YEAR = "2019-2020";
    private static final int SEMECTER = 8;
    private static final String MMS = "ММС-601-0";
    private static final String MPB = "МПБ-601-0";

    private static final String FACULTY = "ИМИТ";
    private static Student student11 = new Student("Адельшин",FACULTY,MMS);
    private static  Student student12 = new Student("Таймре",FACULTY,MMS);
    private static  Student student13 = new Student("Садуллаева",FACULTY,MMS);
    private static  Student student14 = new Student("Шипицин",FACULTY,MMS);

    private Student student21 = new Student("Ющенко",FACULTY,MPB);
    private static  Student student22 = new Student("Козлова",FACULTY,MPB);
    private static  Student student23 = new Student("Козуев",FACULTY,MPB);
    private static  Student student24 = new Student("Ибрагимова",FACULTY,MPB);
    private static  Student student25 = new Student("Максутов",FACULTY,MPB);

    private static  String subjectBaseCompScience = "Основы компьютерных наук";
    private static  String subjectMathAnalZachet= "Математический анализ, зачет";
    private static  String subjectFuncAnalExam = "Функциональный анализ, экзамен";
    private static  String subjectDataBase = "Базы данных";

    private static  String ASHAEV = "Ашаев Игорь Викторович";
    private static  String MELNIKOV = "Мельников Евгений Владимирович";

    private static ControlSpreadsheet statementBaseCompScience =
            new ControlSpreadsheet(subjectBaseCompScience,ASHAEV,new Date(2019,9,18),SEMECTER,YEAR,MMS);

    private static ControlSpreadsheet statementDataBase =
            new ControlSpreadsheet(subjectDataBase,ASHAEV,new Date(2019,9,18),SEMECTER,YEAR,MPB);

    private static ControlSpreadsheet statementMathAnalZachet1 =
            new ControlSpreadsheet(subjectMathAnalZachet,MELNIKOV,new Date(2019,9,19),SEMECTER,YEAR);

    private static ControlSpreadsheet statementMathAnalZachet2 =
            new ControlSpreadsheet(subjectMathAnalZachet,MELNIKOV,new Date(2019,10,1),SEMECTER,YEAR);

    private static ControlSpreadsheet statementFuncAnalExam1 =
            new ControlSpreadsheet(subjectFuncAnalExam,MELNIKOV,new Date(2019,9,20),SEMECTER,YEAR);

    private static ControlSpreadsheet statementFuncAnalExam2 =
            new ControlSpreadsheet(subjectFuncAnalExam,MELNIKOV,new Date(2019,10,10),SEMECTER,YEAR);

    private static ControlSpreadsheet statementFuncAnalExam3 =
            new ControlSpreadsheet(subjectFuncAnalExam,MELNIKOV,new Date(2019,10,15),SEMECTER,YEAR);


    public List<summaryControlSpreadsheet> createSummaryControlSpreadsheet(){
        List<summaryControlSpreadsheet> summaryStatements = new ArrayList<>();
        try {
            ControlSpreadsheet controlSpreadsheetBaseCompScience;
            controlSpreadsheetBaseCompScience.addRecord(student11, Assessment.A);
            controlSpreadsheetBaseCompScience.addRecord(student12, Assessment.B);
            controlSpreadsheetBaseCompScience.addRecord(student13, Assessment.A);
            controlSpreadsheetBaseCompScience.addRecord(student14, Assessment.B);

            ControlSpreadsheet controlSpreadsheetDataBase;
            controlSpreadsheetDataBase.addRecord(student21, Assessment.A);
            controlSpreadsheetDataBase.addRecord(student22, Assessment.A);
            controlSpreadsheetDataBase.addRecord(student23, Assessment.A);
            controlSpreadsheetDataBase.addRecord(student24, Assessment.B);
            controlSpreadsheetDataBase.addRecord(student25, Assessment.C);

            ControlSpreadsheet controlSpreadsheetMathAnalZachet1;
            controlSpreadsheetMathAnalZachet1.addRecord(student11, Assessment.PASS);
            controlSpreadsheetMathAnalZachet1.addRecord(student12, Assessment.PASS);
            controlSpreadsheetMathAnalZachet1.addRecord(student13, Assessment.PASS);
            controlSpreadsheetMathAnalZachet1.addRecord(student14, Assessment.ABSENCE);
            controlSpreadsheetMathAnalZachet1.addRecord(student21, Assessment.PASS);
            controlSpreadsheetMathAnalZachet1.addRecord(student22, Assessment.PASS);
            controlSpreadsheetMathAnalZachet1.addRecord(student23, Assessment.PASS);
            controlSpreadsheetMathAnalZachet1.addRecord(student24, Assessment.FAIL);
            controlSpreadsheetMathAnalZachet1.addRecord(student25, Assessment.PASS);

            ControlSpreadsheet controlSpreadsheetFuncAnalExam1;
            controlSpreadsheetFuncAnalExam1.addRecord(student11, Assessment.A);
            controlSpreadsheetFuncAnalExam1.addRecord(student12, Assessment.A);
            controlSpreadsheetFuncAnalExam1.addRecord(student13, Assessment.A);
            controlSpreadsheetFuncAnalExam1.addRecord(student14, Assessment.ABSENCE);
            controlSpreadsheetFuncAnalExam1.addRecord(student21, Assessment.C);
            controlSpreadsheetFuncAnalExam1.addRecord(student22, Assessment.A);
            controlSpreadsheetFuncAnalExam1.addRecord(student23, Assessment.B);
            controlSpreadsheetFuncAnalExam1.addRecord(student24, Assessment.D);
            controlSpreadsheetFuncAnalExam1.addRecord(student25, Assessment.B);

            ControlSpreadsheet controlSpreadsheetMathAnalZachet2;
            controlSpreadsheetMathAnalZachet2.addRecord(student14, Assessment.PASS);
            controlSpreadsheetMathAnalZachet2.addRecord(student24, Assessment.PASS);

            ControlSpreadsheet controlSpreadsheetFuncAnalExam2;
            controlSpreadsheetFuncAnalExam2.addRecord(student24, Assessment.D);
            controlSpreadsheetFuncAnalExam2.addRecord(student14, Assessment.B);

            ControlSpreadsheet controlSpreadsheetFuncAnalExam3;
            controlSpreadsheetFuncAnalExam3.addRecord(student24, Assessment.C);

            TreeSet<Statement> statements = new TreeSet<>();
            statements.add(controlSpreadsheetBaseCompScience);
            statements.add(controlSpreadsheetDataBase);
            statements.add(controlSpreadsheetFuncAnalExam1);
            statements.add(controlSpreadsheetFuncAnalExam2);
            statements.add(controlSpreadsheetFuncAnalExam3);
            statements.add(controlSpreadsheetMathAnalZachet1);
            statements.add(controlSpreadsheetMathAnalZachet2);

            TreeSet<ControlSpreadsheet> controlSpreadsheet;
            summaryControlSpreadsheet summaryControlSpreadsheetMMS =
                    new summaryControlSpreadsheet(YEAR,SEMECTER,MMS,controlSpreadsheet);

            summaryControlSpreadsheetMMS.build();

            summaryControlSpreadsheet summaryControlSpreadsheetMPB =
                    new summaryControlSpreadsheet(YEAR,SEMECTER,MPB,controlSpreadsheet);

            summaryControlSpreadsheetMPB.build();

            summaryControlSpreadsheet.add(summaryControlSpreadsheetMMS);
            summaryControlSpreadsheet.add(summaryControlSpreadsheetMPB);

        } catch (ControlSpreadsheetException e) {
            e.printStackTrace();
        }
        return summaryStatements;
    }

    @Test
    public void testShow(){
        System.out.println(summaryControlSpreadsheetMMS);
        System.out.println(summaryControlSpreadsheetMPB);
    }

    @Test
    public void testGetRating(){
        List<Assessment> assessmentsList = summaryControlSpreadsheetMPB.getAssessment(student24,subjectFuncAnalExam);
        assertEquals(3, assessmentsList.size());
        assertEquals(Assessment.D, assessmentsList.get(0));
        assertEquals(Assessment.D, assessmentsList.get(1));
        assertEquals(Assessment.C, assessmentsList.get(2));
    }

    @Test
    public void testAddStatement(){
        String subject = "Физкультура";
        String nameLecture = "Физрук";
        Statement newStatement = new Statement(subject,nameLecture,new Date(2019,1,11),SEMECTER,YEAR);
        try {
            newStatement.addAssessment(student12, Assessment.A);
            newStatement.addAssessment(student13,Assessment.A);
            summaryControlSpreadsheetMMS.addControlSpreadsheet(newControlSpreadsheet);
            System.out.println(summaryControlSpreadsheetMMS);
        } catch (ControlSpreadsheetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetSubjects(){
        Set<String> subjectSet = summaryControlSpreadsheetMMS.getSubejcts();
        assertEquals(3,subjectSet.size());
        assertTrue(subjectSet.contains(subjectBaseCompScience));
        assertTrue(subjectSet.contains(subjectFuncAnalExam));
        assertTrue(subjectSet.contains(subjectMathAnalZachet));
    }

    @Test
    public void testGetStudents(){
        Set<Student> students = summaryControlSpreadsheetMMS.getStudents();
        assertEquals(4, students.size());
        assertTrue(students.contains(student11));
        assertTrue(students.contains(student12));
        assertTrue(students.contains(student13));
        assertTrue(students.contains(student14));
    }

    @Test
    public void testBuild(){
        System.out.println(summaryControlSpreadsheetMMS);
        summaryControlSpreadsheetMMS.build();
        System.out.println(summaryControlSpreadsheetMMS);
    }


}