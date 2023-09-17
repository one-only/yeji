package baekjoon;

import java.io.*;
import java.util.*;
// 이분탐색-차집합
public class P1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // A,B 원소의 개수
        int aNum = Integer.parseInt(st.nextToken());
        int bNum = Integer.parseInt(st.nextToken());
        // 차집합 개수
        int count = 0;

        Set<Integer> aSet = new TreeSet<>();
        Set<Integer> bSet = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aNum; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bNum; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 교집합인경우 a집합에서 제외
            if(aSet.contains(num))
                aSet.remove(num);
        }
        bw.write(aSet.size()+"\n");
        Iterator<Integer> iter = aSet.iterator();
        if (!aSet.isEmpty()) {
            while (iter.hasNext()) {
                bw.write(iter.next()+" ");
            }
        }
        bw.flush();
        bw.close();
    }
}
