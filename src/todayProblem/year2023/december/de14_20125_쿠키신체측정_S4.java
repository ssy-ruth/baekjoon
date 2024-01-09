package todayProblem.year2023.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class de14_20125_쿠키신체측정_S4 {
    private static String[][] map;
    private static int N;
    private static int waist=0, leftArm=0, rightArm=0, leftLeg=0, rightLeg=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];

        for (int i = 0; i < N; i++) {
            int j=0;
            for (String a : br.readLine().split("")) {
                map[i][j]=a;
                j+=1;
            }
     //       System.out.println(Arrays.toString(map[i]).replaceAll("[,\\[\\]]",""));
        }
        String lastString="";
        outer:
        for (int i = 0; i < N; i++) {
            inner:
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals("*")&&lastString.equals("")){
                    findHead(i, j);
                    lastString="000";
                    break outer;
                }
            }
        }
        System.out.println(leftArm+" "+rightArm+" "+waist+" "+leftLeg+" "+rightLeg);
    }
    public static void findHead(int i, int j){
        while(true){
            if (map[i+1][j].equals("*")){
                if (map[i+1][j+1].equals("*") && map[i+1][j-1].equals("*") && map[i+2][j].equals("*")){
                    System.out.print(i+2);
                    System.out.print(" ");
                    System.out.println(j+1);
                    findArm(1, i+1, j);
                    findArm(-1, i+1, j);
                    findWaist(i+1, j);
                    break;
                }
            }
            i+=1;
        }
    }
    public static void findArm(int way, int i, int j){
        while(true){
            if(j>=N-1 || j<=0){
                break;
            }
            if (map[i][j+way].equals("*")){
                if (way>0){
                    rightArm+=1;
                    j+=1;
                }else {
                    leftArm+=1;
                    j-=1;
                }
            }else break;
        }
    }
    public static void findWaist(int i, int j){
        while(true){
            if(i>=N-1){
                break;
            }
            if (map[i+1][j].equals("*")){
                waist+=1;
                i+=1;
            }else {
                findLeg(1, i, j);
                findLeg(-1, i, j);
                break;
            }
        }
    }
    public static void findLeg(int way, int i, int j){
        while(true){
            if(i>=N-1){
                break;
            }
            if (map[i+1][j+way].equals("*")){
                if (way>0){
                    rightLeg+=1;
                    i+=1;
                }else {
                    leftLeg+=1;
                    i+=1;
                }
            }else {
                break;
            }
        }
    }
}
