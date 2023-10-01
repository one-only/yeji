package baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

// 정렬2 - 접미사 배열
public class P11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String[] arr = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i]= str.substring(i);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String suffix : arr)
            bw.write(suffix+"\n");

        bw.flush();
        bw.close();
    }
}
