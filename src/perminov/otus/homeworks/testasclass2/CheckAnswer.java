package perminov.otus.homeworks.testasclass2;

public interface CheckAnswer {

    static boolean check(TestElement test, Integer userAnswer){
        return test.getCorrectAnswer().equals(userAnswer);
    }
}
