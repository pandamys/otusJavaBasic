package perminov.otus.homeworks.testasclass2;

public class Test {
    public static void main(String[] args) {
        int answerUser, countCorrectAnswers = 0;
        //ConsoleUserInteraction consoleUserInteraction = new ConsoleUserInteraction();
        UpperCaseConsoleUserInteraction consoleUserInteraction = new UpperCaseConsoleUserInteraction();
        String[][][] questions = {
                {{"Какая столица России?"},{"Москва","Пермь","Воронеж"}, {"1"}},
                {{"Куда впадает Волга?"},{"Черное море","Тихий океан","Каспийское море"},{"3"}},
                {{"Вокруг чего вращается земля?"},{"Юпитер","Солнце","Всё вращается вокруг земли"},{"2"}}
        };

        TestElement[] test = createTest(questions);
        consoleUserInteraction.startTest();
        for (TestElement testElement: test){
            consoleUserInteraction.printQuestion(testElement);
            consoleUserInteraction.printAnswer(testElement);
            answerUser = consoleUserInteraction.getAnswer();
            if (CheckAnswer.check(testElement, answerUser)){
                countCorrectAnswers++;
            }
        }
        consoleUserInteraction.printResult(countCorrectAnswers);
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
