package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


// 방탈출
public class P15729_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] target = br.readLine().split(" ");
        String[] arr = new String[N];

        int count=0;

        Arrays.fill(arr, "0");

        for(int i=0;i<N;i++){
            if(arr[i].equals(target[i])) continue;
            count++;
            arr[i] = toggle(arr[i]);
            if (i==N-1) continue;
            arr[i+1] = toggle(arr[i+1]);
            if(i==N-2) continue;
            arr[i+2] = toggle(arr[i+2]);
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static int checkIndex(String[] arr,String[] target) { //목표 배열과 다른 항목의 인덱스를 반환
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i].equals(target[i])) return i;
        }
        return arr.length;
    }
    static String toggle(String val) { // true <-> false 변환
        if(val.equals("0")) return "1";
        else return "0";
    }
}
