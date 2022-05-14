package perminov.otus.homeworks.algoritm;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleAlgorithmImpl {
    public static void main(String[] args) {
        long start, end;
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(42);
        integers.add(-24);
        integers.add(7);
        integers.add(5);
        integers.add(65);
        integers.add(-2);
        integers.add(1);
        integers.add(25);
        integers.add(34);

        start = getNanoTime();
        System.out.println(sortedList((ArrayList<Integer>) integers.clone()));
        end = getNanoTime();
        System.out.println(end - start);

        System.out.println(integers);

        start = getNanoTime();
        Collections.sort(integers);
        System.out.println(integers);
        end = getNanoTime();
        System.out.println(end - start);
    }

    public static ArrayList sortedList(ArrayList<Integer> list){
        int tempInt;
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(j + 1)){
                    tempInt = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tempInt);
                }
            }
        }
        return list;
    }

    public static long getNanoTime(){
        return System.nanoTime();
    }
}
