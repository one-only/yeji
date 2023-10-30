package baekjoon.sort;

import java.io.*;
import java.util.*;

// 파일 정리 https://www.acmicpc.net/problem/20291
public class P20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("\\.");
            map.put(arr[1],map.getOrDefault(arr[1],0)+1);
        }

        String[] arr = new String[map.size()];

        int i=0;
        for (String key : map.keySet()) {
            arr[i] = key;
            i++;
        }
        Arrays.sort(arr,new Comparator<String>(){
            @Override
           public int compare(String o1, String o2){
               return o1.compareTo(o2);
           }
        });

        for (int j = 0; j < arr.length; j++) {
            bw.write(arr[j]+" "+map.get(arr[j])+"\n");
        }
        bw.flush();
        bw.close();

    }//main
}
