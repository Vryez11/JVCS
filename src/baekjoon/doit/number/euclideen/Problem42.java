package src.baekjoon.doit.number.euclideen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem42 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int max = Math.max(A,B);
            int min = Math.min(A,B);

            while (max % min != 0) {
                int mod = max % min;
                max = Math.max(mod, min);
                min = Math.min(mod, min);
            }

            System.out.println((A / min) *  (B / min) * min);
        }
    }
}
