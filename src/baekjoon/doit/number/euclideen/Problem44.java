package src.baekjoon.doit.number.euclideen;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem44 {

    static ArrayList<cNode>[] A;
    static long lcm;
    static boolean[] visited;
    static long[] D;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = input.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int p = input.nextInt();
            int q = input.nextInt();
            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        for (int i = 0; i < N; i++) {
            bw.write(D[i] / mgcd + " ");
        }

        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void DFS(int Node) {
        visited[Node] = true;
        for (cNode i : A[Node]) {
            int next = i.getB();
            if (!visited[next]) {
                D[next] = D[Node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }
}

class cNode {
    int b;
    int p;
    int q;

    public cNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}
