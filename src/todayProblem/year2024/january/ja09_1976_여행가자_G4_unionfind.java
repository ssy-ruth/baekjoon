package todayProblem.year2024.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ja09_1976_여행가자_G4_unionfind {
    static int set[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        set = new int[N+1];
        for (int i = 1; i <= N; i++) {
            set[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1){
                    union(i,j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lastToken = 0;
        String answer = "YES";
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (lastToken == 0){
                lastToken = a;
            }else {
                if (find(a) != find(lastToken)){
                    answer = "NO";
                }
            }
        }
        System.out.println(answer);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a>b){
            set[a] = b;
        }else {
            set[b] = a;
        }
    }
    public static int find(int a){
        if (set[a] == a){
            return a;
        }else return set[a] = find(set[a]);
    }
}
