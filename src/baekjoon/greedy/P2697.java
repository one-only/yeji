package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 다음수 구하기
public class P2697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-->0) {
            String str = br.readLine();
            int[] arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++) { //한 글자씩 배열로 저장
                //char형->int형 변환 이게 최선인가..?
                arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            }

            for (int i = str.length()-2; i > -1 ; i--) {
                int first = -1;
                if (arr[i] < arr[i + 1]) {
                    first = arr[i];
//                    System.out.println("first = " + first);
                    int next = Integer.MAX_VALUE;
                    int nextIndex = 0;
                    for (int j = i+1; j < str.length(); j++) {
                        if (first<arr[j] && arr[j]<next) { //가장 앞 수보다 큰 것, 더 작은수를 찾았을때
                            next = arr[j];
                            nextIndex = j;
                        }
                    }
//                    System.out.println("next" + next);
//                    System.out.println("nextIndex = " + nextIndex);
                    arr[i] = next;
                    arr[nextIndex] = first; //3과 4를 바꿈, 399742->499732
                    int[] arr2 = new int[arr.length-(i+1)];
                    int arr2Index = 0;
                    for (int j = i+1; j < arr.length; j++) { //99732를 오름차순으로 정렬
                        arr2[arr2Index] = arr[j];
                        arr2Index++;
                    }
                    Arrays.sort(arr2);
                    for (int j = 0; j <= i; j++) {
                        sb.append(String.valueOf(arr[j]));
                    }
                    for (int val : arr2) {
                        sb.append(String.valueOf(val));
                    }
                    sb.append("\n");
                    break;
                }//if
                if(i==0 && first==-1) sb.append("BIGGEST\n");
            }//for
        }

        System.out.println(sb);
    }

}
