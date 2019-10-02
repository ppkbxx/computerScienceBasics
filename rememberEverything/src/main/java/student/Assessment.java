package student;

public enum Assessment {
    //неуд, удовл, хор, отл, зачтено, незачёт, неявка;
    D("2"), C("3"), B("4"), A("5"),
    PASS("Зачет"), FAIL("Незачет"), ABSENCE("Неявка"), NOTASSESSMENT("Нет оценки");

    private String message;
    Assessment(String message){
        this.message = message;
    }
    @Override
    public String toString() {
        return message;
    }
}
