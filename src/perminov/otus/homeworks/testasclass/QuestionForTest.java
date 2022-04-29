package perminov.otus.homeworks.testasclass;

public class QuestionForTest {
    private String name;
    private String[] answers;
    private Integer correctAnswers;

    public QuestionForTest(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers, Integer correctAnswers) {
        this.answers = answers;
        this.correctAnswers = correctAnswers;
    }

    public Integer getCorrectAnswers() {
        return correctAnswers;
    }

    public boolean checkAnswer(Integer i){
        return correctAnswers == i;
    }
}
