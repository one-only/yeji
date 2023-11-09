package baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;


// 방탈출(시간초과)
public class P15729 {
    static boolean[] arr;
    static boolean[] target;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N+1];
        target = new boolean[N+1];

        for (int i = 1; i <=N; i++) { //배열을 0으로 초기화
            arr[i] = false;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            target[i] = Integer.parseInt(st.nextToken()) != 0;
        }

        int count=0;

        while (true) {
            int index = checkIndex(arr,target);
            if(index>N) break;
            count++;
            arr[index] = toggle(arr[index]);
            if (index==N) continue;
            arr[index+1] = toggle(arr[index+1]);
            if(index==N-1) continue;
            arr[index+2] = toggle(arr[index+2]);

        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }

    static int checkIndex(boolean[] arr,boolean[] target) { //목표 배열과 다른 항목의 인덱스를 반환
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]!=target[i]) return i;
        }
        return arr.length;
    }
    static boolean toggle(boolean val) { // true <-> false 변환
        if(val) return false;
        else return true;
    }
}
