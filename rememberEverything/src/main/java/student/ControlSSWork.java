package student;

import student.summaryControlSpreadsheet.Assessment;
import student.summaryControlSpreadsheet.summaryControlSpreadsheet;

import java.util.*;

public class ControlSpreadsheetWork {

    public static Map<Student, Set<String>> getDebtors(SummaryControlSpreadsheet summaryControlSpreadsheet;){
        Map<Student, Set<String>> debtors = new TreeMap<>();
        for(Student student : summaryControlSpreadsheet.getStudents()){
            for(String subject : summaryControlSpreadsheet.getSubejcts()){

                List<Assessment> assessments = summaryControlSpreadsheet.getAssessment(student,subject);
                int size = assessments.size();
                Assessment assessment = assessments.get(size - 1);
                if(assessment == Assessment.ABSENCE || assessment == Assessment.D || assessment == Assessment.FAIL){
                    if(!debtors.containsKey(student)){
                        debtors.put(student, new HashSet<>());
                    }
                    debtors.get(student).add(subject);
                }
            }
        }

        return debtors;
    }

}