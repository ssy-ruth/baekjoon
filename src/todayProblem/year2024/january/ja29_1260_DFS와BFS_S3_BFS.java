package todayProblem.year2024.january;

import java.util.*;
import java.io.*;

public class ja29_1260_DFS와BFS_S3_BFS {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }
        dfs(startV);
        sb.append("\n");
        visited = new int[N+1];
        bfs(startV);
        System.out.println(sb);
    }
    public static void dfs(int startV){
        sb.append(startV).append(" ");
        visited[startV] = 1;
        int index = 0;
        while(true){
            if (index >= graph[startV].size() || graph[startV].isEmpty()){
                break;
            }
            int a = graph[startV].get(index);
            if (visited[a] == 0){
                dfs(a);
            }
            index += 1;
        }
    }
    public static void bfs(int startV){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startV);
        visited[startV] = 1;

        while (true){
            if (queue.isEmpty()){
                break;
            }
            int a = queue.poll();
            sb.append(a).append(" ");
            for (int i = 0; i < graph[a].size(); i++) {
                int b = graph[a].get(i);
                if (visited[b]==0){
                    queue.add(b);
                }
                visited[b] = 1;
            }
        }
    }
}
