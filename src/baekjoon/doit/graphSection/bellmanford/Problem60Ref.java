package src.baekjoon.doit.graphSection.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem60Ref {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[M];
        long[] distance = new long[N];
        long[] cityMoney = new long[N];
        Arrays.fill(distance, Long.MIN_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, price);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cityMoney[i] = Long.parseLong(st.nextToken());
        }
        distance[S] = cityMoney[S];
        for (int i = 0; i <= N + 100; i++) {
            for (int j = 0; j < M; j++) {
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;

                if (distance[start] == Long.MIN_VALUE) continue;
                else if (distance[start] == Long.MAX_VALUE) distance[end] = Long.MAX_VALUE;
                else if (distance[end] < distance[start] + cityMoney[end] - price) {
                    distance[end] = distance[start] + cityMoney[end] - price;

                    if (i >= N - 1) distance[end] = Long.MAX_VALUE;
                }
            }
        }
        if (distance[E] == Long.MIN_VALUE) System.out.println("gg");
        else if (distance[E] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[E]);
    }

    static class Edge {
        private int start;
        private int end;
        private int price;

        public Edge(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }
    }
}
