package todayProblem.year2023.november;

import java.util.ArrayList;
import java.util.Scanner;

public class no08_1707_이분그래프_G4 {
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static int[] colors;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int K=sc.nextInt();

        //테스트케이스수만큼반복
        for (int i=0;i<K;i++){
            int V=sc.nextInt();//정점개수
            int E=sc.nextInt();//간선개수
            nodes.clear();

            //정점마다 연결정보 저장위한 공간확보, 초기화
            for (int j = 0; j < V+1; j++) {
                nodes.add(new ArrayList<Integer>());
            }

            //간선수만큼 그래프 양방향으로 입력받기
            for (int j = 1; j < E+1; j++) {
                int a=sc.nextInt();
                int b=sc.nextInt();

                nodes.get(a).add(b);
                nodes.get(b).add(a);
            }

            colors = new int[V + 1];
            boolean checkFinal=true;
            //연결 비연결 그래프 모두 체크하기 위해서 모든 정점 돌면서 확인
            for (int j = 1; j < V+1; j++) {
                if (colors[j] == 0) { // 아직 방문하지 않은 정점에 대해서만 DFS 수행
                    if (!dfs(j, 1)) {
                        checkFinal = false;
                        break;
                    }
                }
            }
            System.out.println(checkFinal ? "YES" : "NO");
        }
        sc.close();
    }
    //startV는 시작 정점. dfs안에서는 startV와 연결된 연결 정점을 검사함
    //color는 startV의 색깔. for문 안에, startV와 연결된 애들은 모두 color과 반대 색이어야함.
    public static boolean dfs(int startV, int color){
        colors[startV] = color;
            for (int ind : nodes.get(startV)) {
                //색이 같으면 이분그래프가 아니므로 false리턴
                if (colors[ind]==color){
                    return false;
                }
                //방문한적 없으면
                if (colors[ind] == 0 && !dfs(ind, -color)) {
                    return false;
                }
            }
            //연결 정점이 없다면, true리턴
            return true;
    }
}
