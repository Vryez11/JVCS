package src.baekjoon.doit.prime;

import java.util.Scanner;

public class Problem40 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long min = input.nextLong();
        long max = input.nextLong();
        boolean[] check = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start_index = min / pow;
            if (min % pow != 0)
                start_index++;
            for (long j = start_index; pow * j <= max; j++) {
                check[(int)(pow * j - min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < check.length; i++) {
            if (!check[i])
                count++;
        }
        System.out.println(count);
    }
}
