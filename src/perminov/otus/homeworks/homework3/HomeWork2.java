package perminov.otus.homeworks.homework3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answerUser, countCorrectAnswer = 0;

        String[][][] questions = {
                {{"Какая столица России?"},{"Москва","Пермь","Воронеж"}, {"1"}},
                {{"Куда впадает Волга?"},{"Черное море","Тихий океан","Каспийское море"},{"3"}},
                {{"Вокруг чего вращается земля?"},{"Юпитер","Солнце","Всё вращается вокруг земли"},{"2"}}
        };

        for (String[][] question: questions) {
                    System.out.println(String.format("Вопрос: %s", question[0]));
                    String[] answers = question[1];
                    System.out.println("---Варианты ответов: ---");
                    for (String answer : answers) {
                        System.out.println(answer);
                    }
                    System.out.println("Введите номер ответа:");
                    try {
                        answerUser = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Введён символ, а не цифра, программа завершена. Пожалуйста, начните сначала.");
                        break;
                    }
                    if (Integer.parseInt(question[2][0]) == answerUser) {
                        countCorrectAnswer++;
                    }
        }
        System.out.println(String.format("Количество правильных ответов: %s", countCorrectAnswer));
        scanner.close();
    }
}
