package todayProblem.year2024.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//성공
public class ju11_1244_스위치켜고끄기_S4_구현 {
    static int N;
    static int[] switches;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        switches = new int[N+1];
        for (int i = 1; i <= N; i++) {
            switches[i]=Integer.parseInt(st.nextToken());
        }
        //switches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[][] students = new int[M][];
        for (int i = 0; i < M; i++) {
            students[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (students[i][0] == 1){
                int s = students[i][1];
                for (int j = s; j <= N; j+=s) {
                    ChangeStatus(j);
                }
            }else{
                int s = students[i][1];
                int b = CheckBoundary(s);
                for (int j = 0; j < b; j++) {
                    if (j==0){
                        ChangeStatus(s);
                    }else{
                        ChangeStatus(s+j);
                        ChangeStatus(s-j);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=N ; i++) {
            sb.append(switches[i]).append(" ");
            if (i%20==0){
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void ChangeStatus(int s){
        if (switches[s]==0)
            switches[s]=1;
        else switches[s]=0;
    }
    public static int CheckBoundary(int s){
        boolean symmetry = true;
        int boundary=0;
        while(symmetry){
            if (s+boundary <= N && 0 < s-boundary){
                if (switches[s+boundary] != switches[s-boundary]){
                    symmetry = false;
                    break;
                }
                boundary++;
            }else {
                break;
            }
        }
        return boundary;
    }
}
