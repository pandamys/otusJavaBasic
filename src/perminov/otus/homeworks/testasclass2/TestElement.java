package perminov.otus.homeworks.testasclass2;

public class TestElement {
    private String question;
    private String[] answers;
    private Integer correctAnswer;

    public TestElement(String question, String[] answers, Integer correctAnswer){
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }
}
