package perminov.otus.homeworks.testasclass;

import java.util.Scanner;

public class TestObject {
    private String nameTest;
    private Integer countQuestions;
    private QuestionForTest[] questions;

    public TestObject(String name, Integer countQuestions){
        this.nameTest = name;
        this.countQuestions = countQuestions;
        this.questions = new QuestionForTest[countQuestions];
    }

    public String getNameTest() {
        return nameTest;
    }

    public QuestionForTest[] getQuestions() {
        return questions;
    }

    public void setQuestions(QuestionForTest[] questions) {
        this.questions = questions;
    }

    public void addQuestion(QuestionForTest question, Integer i){
        this.questions[i] = question;
    }

    public void showTest(){
        Scanner scanner = new Scanner(System.in);
        int answerUser, countCorrectAnswers = 0;

        if (questions.length > 0){
            System.out.println(String.format("Начинаем тест \"%s\"", nameTest));
            for (QuestionForTest question: questions){
                System.out.println(String.format("Вопрос %s", question.getName()));
                System.out.println("--------");
                for (int i = 0; i < question.getAnswers().length; i++) {
                    System.out.println(String.format("%d. %s", i + 1, question.getAnswers()[i]));
                }
                System.out.println("Введите НОМЕР ответа:");
                answerUser = scanner.nextInt();
                if (answerUser == question.getCorrectAnswers()){
                    countCorrectAnswers++;
                }
            }
            System.out.println(String.format("Количество правильных ответов: %s", countCorrectAnswers));
        } else {
            System.out.println("В тесте нет вопросов");
        }
        scanner.close();
    }
}
