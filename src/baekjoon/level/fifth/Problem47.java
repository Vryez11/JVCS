package src.baekjoon.level.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem47 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb1 = new StringBuilder(st.nextToken());
        StringBuilder sb2 = new StringBuilder(st.nextToken());
        br.close();

        int num1 = Integer.parseInt(sb1.reverse().toString());
        int num2 = Integer.parseInt(sb2.reverse().toString());

        if (num1 > num2) System.out.println(num1);
        else System.out.println(num2);
    }
}
