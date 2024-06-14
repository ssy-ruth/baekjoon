package todayProblem.year2024.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//결국 블로그찾아보고 성공..
public class ju13_9935_문자열폭발_G4_스택큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int bombSize = bomb.length();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++ ){
            stack.push(str.charAt(i));
            if(stack.size() >= bombSize) {
                boolean flag = true;

                for(int j=0; j<bombSize; j++) {
                    if(stack.get(stack.size() - bombSize + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    for(int j=0; j<bombSize; j++) stack.pop();
                }
            }
        }
        if(stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for(Character c : stack) sb.append(c);
            System.out.println(sb);
        }
//        while (true){
//            if (st.contains(bomb)){
//                int bombIndex = st.indexOf(bomb);
//                st=st.substring(0,bombIndex).concat(st.substring(bombIndex+bomb.length()));
//            }else{
//                break;
//            }
//        }
//        if (st.length()==0){
//            System.out.println("FRULA");
//        }else{
//            System.out.println(st);
//        }
    }
}
