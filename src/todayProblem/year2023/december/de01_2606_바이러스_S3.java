package todayProblem.year2023.december;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class de01_2606_바이러스_S3 {
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static int[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();//정점개수
        int M = sc.nextInt();//간선개수
        visited=new int[N+1];
        count=0;

        //정점마다 연결정보 저장위한 공간확보, 초기화
        for (int j = 0; j < N+1; j++) {
            nodes.add(new ArrayList<Integer>());
            visited[j]=-1;
        }

        //연결 정보에 따라 양방향 추가
        for (int i = 1; i < M+1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        dfs(1);
        System.out.println(count-1);

    }
    //startV는 시작 정점. dfs안에서는 startV와 연결된 연결 정점을 검사함
    public static boolean dfs(int start){
        visited[start]=1;
        count++;
        for (int ind : nodes.get(start)) {
            //방문한적 있으면 리턴
            if (visited[ind]==1){
                continue;
            }else if (visited[ind] == -1 && !dfs(ind)) {//방문한적 없으면
                continue;
            }
        }
        //연결 정점이 없다면, true리턴
        return true;
    }
}
