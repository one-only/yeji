package baekjoon.hash;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
// 비밀번호 찾기
public class P17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        int listNum = Integer.parseInt(arr[0]);
        int findNum = Integer.parseInt(arr[1]);

        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < listNum; i++) {
            String[] data = br.readLine().split(" ");
            map.put(data[0], data[1]);
        }
        for (int i = 0; i < findNum; i++) {
            bw.write(map.get(br.readLine())+"\n");
        }
        bw.flush();
        bw.close();

    }
}
