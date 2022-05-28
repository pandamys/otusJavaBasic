package perminov.otus.homeworks.errors;

import java.util.ArrayList;

public class Calculate {
    public Integer getSum(String fileName){
        ArrayList<String> numbers;
        int total = 0;
        ReadFile rf = new ReadFile();
        numbers = rf.readFile(fileName);
        try {
            int tempInt;
            for (String number: numbers){
                tempInt = Integer.parseInt(number);
                total += tempInt;
            }
        } catch (NullPointerException e){
            throw new RuntimeException("Ошибка при попытке расчёта.");
        }
        return total;
    }
}
