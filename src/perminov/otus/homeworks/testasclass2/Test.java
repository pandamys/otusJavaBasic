package perminov.otus.homeworks.testasclass2;

public class Test {
    public static void main(String[] args) {
        int answerUser, countCorrectAnswers = 0;
        UserInteraction userInteraction = new UserInteraction();
        String[][][] questions = {
                {{"Какая столица России?"},{"Москва","Пермь","Воронеж"}, {"1"}},
                {{"Куда впадает Волга?"},{"Черное море","Тихий океан","Каспийское море"},{"3"}},
                {{"Вокруг чего вращается земля?"},{"Юпитер","Солнце","Всё вращается вокруг земли"},{"2"}}
        };

        TestElement[] test = createTest(questions);
        userInteraction.startTest();
        for (TestElement testElement: test){
            userInteraction.printQuestion(testElement);
            userInteraction.printAnswer(testElement);
            answerUser = userInteraction.getAnswer();
            if (CheckAnswer.check(testElement, answerUser)){
                countCorrectAnswers++;
            }
        }
        userInteraction.printResult(countCorrectAnswers);
    }

    public static TestElement[] createTest(String[][][] questions){
        int i = 0;
        TestElement[] test = new TestElement[questions.length];

        for (String[][] question: questions) {
            test[i] = new TestElement(question[0][0], question[1], Integer.parseInt(question[2][0]));
            i++;
        }
        return test;
    }
}
