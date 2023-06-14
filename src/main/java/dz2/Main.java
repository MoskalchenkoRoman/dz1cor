package dz2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        int[] arr = IntStream.range(0, 25)
                .map(i -> (int) (Math.random() * 8))
                .toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println(ConsecutiveZero(arr));
        System.out.println("Количество четных чисел : " + NumOfEvenNumbers(arr));
        System.out.println("Разница между максимальным и минимальным элементами : " + DifferenceMaxMin(arr));

    }
        public static int NumOfEvenNumbers(int[] arr) {

            int even = (int) Arrays.stream(arr).filter(i -> i % 2 == 0).count();
            return even;
        }

        public static int DifferenceMaxMin(int[] arr) {

            Arrays.sort(arr);
            int difference = arr[arr.length -1] - arr[0];
            return difference;
        }

        public static boolean ConsecutiveZero (int[] arr) {

            boolean consecutivezero = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == 0 & arr[i+1] == 0)
                        consecutivezero = true;

            }
            return consecutivezero;
        }

}
