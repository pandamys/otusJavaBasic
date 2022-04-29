package perminov.otus.homeworks.homework3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answerUser, countCorrectAnswer = 0;

        String[] questions = {"Какая столица России?", "Куда впадает Волга?", "Вокруг чего вращается земля?"};
        for (int i = 0; i < questions.length; i++) {
            System.out.println(String.format("Вопрос: %s", questions[i]));
            String[] answers = getAnswers(questions[i]);
            System.out.println("---Варианты ответов: ---");
            for (String answer: answers) {
                System.out.println(answer);
            }
            System.out.println("Введите номер ответа:");
            try {
                answerUser = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Введён символ, а не цифра, программа завершена. Пожалуйста, начните сначала.");
                break;
            }
            if (checkAnswerUser(questions[i], answerUser)){
                countCorrectAnswer++;
            }
        }
        System.out.println(String.format("Количество правильных ответов: %s", countCorrectAnswer));
        scanner.close();
    }

    public static String[] getAnswers(String question){
        String[] answers;
        switch (question){
            case "Какая столица России?":
                answers = new String[]{"Москва", "Пермь", "Воронеж"};
                break;
            case "Куда впадает Волга?":
                answers = new String[]{"Черное море", "Тихий океан", "Каспийское море"};
                break;
            case "Вокруг чего вращается земля?":
                answers = new String[]{"Юпитер", "Солнце", "Всё вращается вокруг земли"};
                break;
            default:
                answers = new String[]{"Вопрос не опознан"};
        }
        return answers;
    }

    public static boolean checkAnswerUser(String question, int answerUser){
        boolean isCorrectAnswer = false;

        switch (question){
            case "Какая столица России?":
                isCorrectAnswer = answerUser == 1;
                break;
            case "Куда впадает Волга?":
                isCorrectAnswer = answerUser == 3;
                break;
            case "Вокруг чего вращается земля?":
                isCorrectAnswer = answerUser == 2;
                break;
        }

        return isCorrectAnswer;
    }
}
