package perminov.otus.homeworks.testasclass;

import java.util.Scanner;

public class HomeWork3 {

    public static void main(String[] args) {
        TestObject test = generateTest();
        test.showTest();
    }

    public static TestObject generateTest(){
        String[] questions = {"Какая столица России?", "Куда впадает Волга?", "Вокруг чего вращается земля?"};
        TestObject test = new TestObject("Опросник обо всём", questions.length);
        AnswersForTest answer = new AnswersForTest();

        for (int i = 0; i < questions.length; i++) {
            QuestionForTest tempQuest = new QuestionForTest(questions[i]);
            tempQuest.setAnswers(answer.getAnswers(questions[i]), answer.getCorrectAnswer(questions[i]));
            test.addQuestion(tempQuest, i);
        }
        return test;
    }
}
