package todayProblem.year2025.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class mar29_2164_카드2_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            queue.poll();
            int card = queue.poll();
            queue.offer(card);
        }
        System.out.println(queue.peek());

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        int i=N;
//        if (N%2==1) i++;
//        int m=0;
//        if (N==1 || N==2) System.out.println(N);
//        else if (N==3) System.out.println(2);
//        while (i>3){
//            m=+i/2;
//            i=i-i/2;
//        }
//        System.out.println(m+1);
//
//        int i=1;
//        while (sb.length()!=1){
//            if (i%2==1){
//                sb.deleteCharAt(0);
//            }else{
//                sb.append(sb.charAt(0));
//                sb.deleteCharAt(0);
//            }
//            i++;
//        }
//
//        System.out.println(sb);
    }
}
