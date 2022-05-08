package perminov.otus.homeworks.testasclass2;

public interface UserInteraction {
    void startTest();

    void printQuestion(TestElement test);

    void printAnswer(TestElement test);

    Integer getAnswer();

    void printResult(Integer i);
}
