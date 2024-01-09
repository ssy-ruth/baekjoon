package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class de04_10828_스택_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int pointer = -1;

        for (int i = 0; i < N; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            String command = input.nextToken();
            switch (command){
                case "push":
                    int a = Integer.parseInt(input.nextToken());
                    pointer+=1;
                    stack[pointer]=a;
                    break;
                case "pop":
                    if (pointer!=-1){
                        System.out.println(stack[pointer]);
                        pointer-=1;
                    }else
                        System.out.println(pointer);
                    break;
                case "size":
                    System.out.println(pointer+1);
                    break;
                case "empty":
                    if (pointer==-1)
                        System.out.println(1);
                    else System.out.println(0);
                    break;
                case "top":
                    if (pointer==-1)
                        System.out.println(pointer);
                    else System.out.println(stack[pointer]);
                    break;
                default:
                    break;
            }
        }
    }
}
