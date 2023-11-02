package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


// 시간 관리 https://www.acmicpc.net/problem/1263
public class P1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = stoi(st.nextToken()); // 걸리는 시간
            arr[i][1] = stoi(st.nextToken()); // 마감기한
        }
        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2) {
                return i2[1] - i1[1]; // 마감기한이 느린 순으로 정렬
            }
        });

        int startTime = arr[0][1]-arr[0][0]; //20-5=15
        for (int i = 1; i < N; i++) {
            startTime = startTime - arr[i][0];

            if(i < N-1 && startTime>arr[i+1][1]) // 시작 시작이 다음 마감시간보다 뒤라면
                startTime = arr[i+1][1];
        }

        if (startTime<0) System.out.println("-1");
        else System.out.println(startTime);
    }
    static int stoi(String str){
        return Integer.parseInt(str);
    }
}
