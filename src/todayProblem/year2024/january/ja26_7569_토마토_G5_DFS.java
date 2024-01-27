package todayProblem.year2024.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ja26_7569_토마토_G5_DFS {
    static int[][][] box;
    static int N, M, H, oldDays, zeroCount;
    static int[] dh = {1,-1,0,0,0,0};
    static int[] dn = {0,0,1,-1,0,0};
    static int[] dm = {0,0,0,0,1,-1};
    //static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        oldDays = 0;
        box = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1){
                        queue.add(new int[] {i,j,k});
                    } else if (box[i][j][k] == 0) {
                        zeroCount += 1;
                    }
                }
            }
        }

        while(true){
            queue = day(queue);
            if(queue.isEmpty()){
                if (zeroCount == 0){
                    System.out.println(oldDays);
                }else System.out.println(-1);
                break;
            }else {
                oldDays += 1;
            }
        }
    }
    public static Queue<int[]> day(Queue<int[]> q1){
        //boolean noZero = true;
        Queue<int[]> q2 = new LinkedList<>();
        while (!q1.isEmpty()){
            int[] ripe = q1.poll();
            for (int i = 0; i < 6; i++) {
                int h = ripe[0] + dh[i];
                int n = ripe[1] + dn[i];
                int m = ripe[2] + dm[i];
                if (h<0 || n<0 || m<0 || h>=H || n>=N || m>=M){
                    continue;
                }else {
                    if (box[h][n][m] == 0){
                        box[h][n][m] = 1;
                        q2.add(new int[] {h,n,m});
                        zeroCount -= 1;
                    }
                }
            }
        }
        return q2;
    }
}
