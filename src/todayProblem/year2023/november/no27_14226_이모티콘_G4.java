package todayProblem.year2023.november;

import java.util.ArrayList;
import java.util.Scanner;

public class no27_14226_이모티콘_G4 {
    //private static int clipBoard;//클립보드에 저장된 이모티콘 개수
    //private static int display;//화면에 있는 이모티콘 개수
    private static ArrayList<int[]> graph=new ArrayList<>();
    private static ArrayList<int[]> graph12=new ArrayList<>();
    private static int graphDepth;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S=sc.nextInt();//이모티콘 만들려는 개수
        //clipBoard=0; display=0;
        graphDepth=0;// 화면에도 클립보드에도 이모티콘 개수 초기화. 0개.


    }
    public int[] saveClipboard(int clipBoard, int display){
        clipBoard=display;
        return new int[]{clipBoard, display};
    }
    public int[] addDisplay(int clipBoard, int display){
        display+=clipBoard;
        return new int[]{clipBoard, display};
    }
    public int[] subDisplay(int clipBoard, int display){
        display-=1;
        return new int[]{clipBoard, display};
    }
    public void addGraph(int clipBd, int disp){
        if (clipBd==0 && disp==0){
            //화면에 아무것도 없고 클립보드에도 없으면 2번.
            //그래프에는 하나 추가
            graphDepth++;
            graph.add(addDisplay(clipBd, disp));
        }
    }
}
