package todayProblem.year2024.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ja11_4195_친구네트워크_G2_unionfind {

    static Map<String, Integer> friends;
    static int[] set;
    static int[] memberCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());
            friends = new HashMap<>();
            set = new int[2*F];
            memberCount = new int[2*F];
            Arrays.fill(memberCount, 1);
            for (int j = 0; j < 2 * F; j++) {
                set[j] = j;
            }
            int key = 0;


            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String person1 = st.nextToken();
                String person2 = st.nextToken();
                if (!friends.containsKey(person1)){
                    friends.put(person1, key++);
                }
                if (!friends.containsKey(person2)){
                    friends.put(person2, key++);
                }

                int root = union(friends.get(person1), friends.get(person2));
//                for (int k = 0; k < 2*F; k++) {
//                    if (find(k) == root)
//                        count+=1;
//                }
                sb.append(memberCount[root]).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int find(int a){
        if (a == set[a]){
            return a;
        }else return set[a] = find(set[a]);
    }
    public static int union(int a, int b){
        a = find(a);
        b = find(b);

        if (a != b){
            set[b] = a;
            memberCount[a] += memberCount[b];
        }
        return a;
    }
}
