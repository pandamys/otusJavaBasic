package perminov.otus.homeworks.testasclass2;

import java.util.Scanner;

public class ConsoleUserInteraction implements UserInteraction {

    public ConsoleUserInteraction(){

    }

    public void startTest(){
        System.out.println("Начинаем тестирование");
    }

    public void printQuestion(TestElement test){
        System.out.printf("<--- Вопрос: %s --->%n", test.getQuestion());
    }

    public void printAnswer(TestElement test){
        String[] answers = test.getAnswers();
        for (int i = 0; i < answers.length; i++) {
            System.out.printf("%d. %s%n", i + 1, answers[i]);
        }
    }

    public Integer getAnswer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите НОМЕР ответа:");
        return scanner.nextInt();
    }

    public void printResult(Integer i){
        System.out.printf("Количество правильных ответов: %s%n", i);
    }
}
