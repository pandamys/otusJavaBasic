package perminov.otus.homeworks.errors;

public class Main {
    public static void main(String[] args) {
        int sum, mod;
        Calculate calculate = new Calculate();
        try {
            try {
                sum = calculate.getSum("D:\\data.txt");
                try {
                    mod = 100 / sum;
                } catch (ArithmeticException e) {
                    throw new Exception("Деление на ноль");
                }
            } catch (Exception e) {
                throw new Exception("Ошибка при попытке расчёта", e);
            }
            System.out.println("Модуль числа: " + mod);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
