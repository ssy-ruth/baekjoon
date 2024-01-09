package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class de06_1874_스택수열_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] visit = new int[N];
        ArrayList<String> result = new ArrayList<>();

        outer:
        for (int i = 0; i < N; i++) {
            //입력받은 숫자를 출력.
            int M = Integer.parseInt(br.readLine());
            //출력하기 위해서 그 숫자까지 스택에 넣고 출력함
            if (!stack.contains(M)){
                inner:
                for (int j = 0; j < M; j++) {
                    if (visit[j]!=1){
                        visit[j]=1;
                    }else{
                        continue inner;
                    }
                    if (!stack.contains(j+1)){
                        stack.push(j+1);
                        result.add("+");
                    }
                }
                stack.pop();
                result.add("-");
            }
            // 스택에 이미 그 숫자가 있으면
            else {
                if (stack.peek()!=M){
                    result.add(0,"NO");
                    break outer;
                }else {
                    result.add("-");
                    stack.pop();
                }
            }
        }
        if (result.get(0).equals("NO")){
            System.out.println(result.get(0));
        }else {
            for (String s :
                    result) {
                System.out.println(s);
            }
        }
    }
}
