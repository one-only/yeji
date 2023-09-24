package baekjoon.binarySearch;

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

        // HashSet과 달리 TreeSet은 저장 순서를 가진다.
        // (HashSet은 해시 코드 기반의 순서라 저장된 순서와는 다르다.)
        Set<Integer> aSet = new TreeSet<>();

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
        // 결과 출력하기
        // TreeSet이 필요한 이유->(요구사항) 증가하는 순서로 출력하기 위해
        // TreeSet은 입력을 크기 순으로 하지 않아도 자동으로 크기순으로 저장을 한다.
        // ex) 2 5 11 7 로 입력하여도 2 5 7 11 로 저장된다.
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
