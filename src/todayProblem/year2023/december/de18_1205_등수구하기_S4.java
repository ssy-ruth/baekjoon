package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class de18_1205_등수구하기_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int point = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if(n == 0) {
            System.out.println(1);
            return;
        }

        StringTokenizer s = new StringTokenizer(br.readLine());
        ArrayList<Integer> ranklist = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {
            ranklist.add(Integer.parseInt(s.nextToken()));
        }

        int rank = 1;
        if(ranklist.size() == p && point <= ranklist.get(ranklist.size()-1)) {
            System.out.println(-1);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(point >= ranklist.get(i)) {
                break;
            }else {
                rank+=1;
            }
        }

        if(rank <= p) {
            System.out.println(rank);
        }else {
            System.out.println(-1);
        }
    }
}
