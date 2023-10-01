package baekjoon.fullSearch;

import java.io.*;

// 브루트포스 - 백설 공주와 일곱 난쟁이
public class P3040 {
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        int sum = 0; // 아홉 난쟁이 숫자 합
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                int current = arr[i] + arr[j];
                // 두 난쟁이의 숫자를 합에서 뺐을 때 100이 될 때
                if (sum - current == 100) {
                    arr[i]=0;
                    arr[j]=0;
                    for (int k = 0; k < 9; k++) {
                        if(arr[k]!=0)
                            bw.write(arr[k]+"\n");
                    }
                }
            }
            
        }
        bw.flush();
        bw.close();
    }
}
