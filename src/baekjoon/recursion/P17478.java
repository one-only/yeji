package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀함수가 뭔가요?
public class P17478 {
    static String under="";
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recurFun(N,0);

    }
    static void recurFun(int n,int depth){
        if (n < N) {
            under += "____";
        }
        if (depth == N) {
            System.out.println(under+"\"재귀함수가 뭔가요?\"\n"
            +under+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            recurFun2(depth);
            return;
        }
        else if (depth != N) {
            System.out.println(under+"\"재귀함수가 뭔가요?\"\n" +
                    under+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                    under+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                    under+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        }
        n--;
        depth++;
        recurFun(n,depth);
    }

    static void recurFun2(int depth) {
        if (depth == -1) {
            return;
        }
        System.out.println(under+"라고 답변하였지.");
        under = under.replaceFirst("____", "");
        depth--;
        recurFun2(depth);
    }
}
