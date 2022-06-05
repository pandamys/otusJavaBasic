package perminov.otus.homeworks.testasclass2;

public class TestElement {
    private final String question;
    private final String[] answers;
    private final Integer correctAnswer;

    public TestElement(String question, String[] answers, Integer correctAnswer){
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers.clone();
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }
}
