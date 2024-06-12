package todayProblem.year2024.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//실패
public class ju06_1874_스택수열_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int err = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        outer:
        for (int i = 0; i < N; i++) {
            //입력받은 숫자를 출력.
            int M = Integer.parseInt(br.readLine());
            //출력하기 위해서 그 숫자까지 스택에 넣고 출력함

            for (int j = 0; j < M; j++) {
                if (!stack.contains(j+1)){
                    stack.push(j+1);
                    sb.append("+").append("\n");
                    System.out.println(stack);
                }
            }
            // 스택에 이미 그 숫자가 있으면
            if (stack.peek()!=M){
                err = 1;
                break outer;
            }else {
                sb.append("-").append("\n");
                stack.pop();
                System.out.println(stack);
            }
        }
        if (err==1){
            System.out.println("NO");
            System.out.println(sb);
        }else {
            System.out.println(sb);
        }
    }
}
