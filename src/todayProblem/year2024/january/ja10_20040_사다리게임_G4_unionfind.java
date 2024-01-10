package todayProblem.year2024.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ja10_20040_사다리게임_G4_unionfind {
    static int[] set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        set = new int[N];
        for (int i = 0; i < N; i++) {
            set[i] = i;
        }

        //루트노드가 연결점으로 들어오면 사이클
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (find(a) == find(b)){
                System.out.println(i);
                return;
            }
            union(a, b);
        }
        System.out.println(0);
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
