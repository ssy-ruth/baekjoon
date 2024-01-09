package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class de07_프린터큐_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(input.nextToken());
            int index = Integer.parseInt(input.nextToken());
            int[] printer1 = new int[N];
            Queue<Integer> printer = new LinkedList<>();
            StringTokenizer input1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                printer1[j]=Integer.parseInt(input1.nextToken());
                printer.add(printer1[j]);
            }
        }
    }
    public static void countSequence(int[] arr, int index){
        int count=0;
        int max=arr[index];
        int pointer = -1;


        while(true){
            int maxInd = findMax(arr, index);
            if (maxInd>index){
                count+=1;
                arr[maxInd]=0;
                pointer = maxInd;
                for (int i = 0; i < maxInd; i++) {
                    arr[arr.length+i] = arr[i];
                }
            }else if (maxInd < index){
                if(pointer!=0);
                //count+=maxInd+1;
            }
        }

    }
    public static int findMax(int[] arr, int index){
        int max=0;
        int maxIndex = index;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i]>arr[index] && max<arr[i]){
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
