package perminov.otus.homeworks.testasclass2;

import java.util.Scanner;

public class UserInteraction {

    public UserInteraction(){

    }

    public void startTest(){
        System.out.println("Начинаем тестирование");
    }

    public void printQuestion(TestElement test){
        System.out.println(String.format("<--- Вопрос: %s --->", test.getQuestion()));
    }

    public void printAnswer(TestElement test){
        String[] answers = test.getAnswers();
        for (int i = 0; i < answers.length; i++) {
            System.out.println(String.format("%d. %s", i + 1, answers[i]));
        }
    }

    public Integer getAnswer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите НОМЕР ответа:");
        return scanner.nextInt();
    }

    public void printResult(Integer i){
        System.out.println(String.format("Количество правильных ответов: %s", i));
    }
}
