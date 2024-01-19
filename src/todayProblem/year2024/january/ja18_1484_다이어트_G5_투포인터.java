package todayProblem.year2024.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ja18_1484_다이어트_G5_투포인터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int G = Integer.parseInt(br.readLine());
        int start = 1, end = 1;
        while (true){//(start+1)*(start+1) - start*start <= G){
            int calculation = end*end - start*start;
            if (end - start == 1 && calculation > G)
                break;
            if (calculation < G){
                end += 1;
            }else start += 1;

            if (calculation == G)
                sb.append(end).append("\n");

//            }
//            double endPossible = Math.sqrt(G + start * start);
//            if (endPossible % 1 == 0.0){ // 시작점 더한게 정수이면
//                end = (int) endPossible; // end 값 옮겨주고
//                sb.append(end).append("\n");
//            }
//            end += 1;              // start 1증가
        }
        if (sb.isEmpty())
            sb.append(-1);
        System.out.println(sb);
    }
}
