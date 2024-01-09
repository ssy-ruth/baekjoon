package todayProblem.year2024.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ja08_1717_집합의표현_G5_unionfind {
    static int[] set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        set = new int[N+1];
        for (int i = 1; i <= N; i++) {
            set[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (operator == 0){
                union(a, b);
            }else{
                if (find(a) == find(b)){
                    sb.append("YES").append("\n");
                }else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int find(int n){
        if (n == set[n]){ // 부모노드와 같다면
            return n;
        }else {
            return set[n] = find(set[n]);
        }
    }
//    public static int find(int n){
//        while (true){
//
//            if (n == set[n]){ // 부모노드와 같다면
//                return n;
//            }else {
//                n = set[n];
//            }
//
//        }
//    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a < b){
            set[b] = a;
        }else {
            set[a] = b;
        }
    }
}
