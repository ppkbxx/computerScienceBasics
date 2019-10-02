package student;

import java.util.*;

import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class Row {

    // дата - > оценка
    private class DataAssessment implements Comparable<DataAssessment>{
        private Date date;
        private Assessment assessment;

        public DataAssessment(Date date, Assessment assessment) {
            this.date = date;
            this.assessment = assessment;
        }

        public Object getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Assessment getAssessment() {
            return assessment;
        }

        public void setAssessment(Assessment assessment) {
            this.assessment = assessment;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DataAssessment)) return false;
            DataAssessment that = (DataAssessment) o;
            return Objects.equals(getDate(), that.getDate()) &&
                    getAssessment() == that.getAssessment();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getDate(), getAssessment());
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer();
            sb.append(date.getDate());
            sb.append(":");
            sb.append(date.getMonth());
            sb.append(" - ");
            sb.append(assessment);
            return sb.toString();
        }

        @Override
        public int compareTo(DataAssessment o) {
            return date.compareTo((Date) o.getDate());
        }
    }

    //функция отображает дисциплину в оценки
    private Map<String, Set<DataAssessment>> cells;

    public Row(){
        cells = new TreeMap<>();
    }

    public void add(String subject, Date date, Assessment assessment){
        if(!cells.containsKey(subject)){
            cells.put(subject, new TreeSet<>());
        }
        cells.get(subject).add(new DataAssessment(date, assessment));
    }
    public List<Assessment> getAssessment(String subject){
        List<Assessment> assessment = new ArrayList<>();
        for(DataAssessment dataAssessment : cells.get(subject)){
            assessment.add(dataAssessment.getAssessment());
        }
        return assessment;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for(String s : cells.keySet()) {
            sb.append(" | ");
            for (DataAssessment dataAssessment : cells.get(s)) {
                sb.append(dataAssessment);
                sb.append(";");
            }
        }
        return sb.toString();
    }
}

