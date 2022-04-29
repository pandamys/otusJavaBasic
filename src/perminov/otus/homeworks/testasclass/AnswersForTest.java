package perminov.otus.homeworks.testasclass;

public class AnswersForTest {
    public AnswersForTest(){
    }

    public String[] getAnswers(String question){
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

    public int getCorrectAnswer(String question){
        int correctAnswer = 0;

        switch (question){
            case "Какая столица России?":
                correctAnswer = 1;
                break;
            case "Куда впадает Волга?":
                correctAnswer = 3;
                break;
            case "Вокруг чего вращается земля?":
                correctAnswer = 2;
                break;
        }

        return correctAnswer;
    }
}
