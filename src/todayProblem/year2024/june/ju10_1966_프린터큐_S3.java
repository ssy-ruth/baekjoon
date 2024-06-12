package todayProblem.year2024.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//실패
public class ju10_1966_프린터큐_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            int pointer = 0;
            int endpoint =size;
            int count = 0;
            int[] queue = new int[size*size];
            //ArrayList<Integer> queue = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            //queue = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < size; j++) {
                queue[j]=Integer.parseInt(st.nextToken());
                //queue.add(Integer.parseInt(st.nextToken()));
            }

            int j = 0;
            while (j<endpoint){//index!=pointer || j<size){//(int j = 0; j < size; j++) {

                if (queue[j]>queue[index]){//queue.get(j) > queue.get(index)){//
                    if(index < j){
                        for (int k = pointer; k < j; k++) {
                            queue[size+k]=queue[k];//queue.set(size+k, queue.get(k));
                        }
                        pointer = j+1;
                        index += size;
                        size += index-pointer+1;
                        endpoint = index-pointer+1;
                    }else{
                        pointer = j+1;
                        size-=1;
                    }
                    count++;
                }
                else if (queue[j] < queue [index] && index > j){//queue.get(j) < queue.get(index) && index > j){
                    for (int k = pointer; k <= j; k++) {
                        queue[size+k]=queue[k];//.set(size+k, queue.get(k));
                    }
                    pointer = j+1;
                }
                j++;
            }
            //그럼 아마 나보다 큰놈은 나가고 나보다 작은 놈은 다 내 뒤에 있는 상태
            if (index == pointer){
                sb.append(count+1).append("\n");
            }else{
                sb.append(count + index-pointer+1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
