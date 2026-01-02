package A5Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//  여러개의 선택대상이 있고, 전체자원한도 내에서 선택 조합을 구성하여 최대값/최소값 구하는 문제
public class A05배낭문제 {
//    주어진 데이터 1번만 사용 가능
//
//    평범한 배낭 - 백준
//    벼락치기 - 백준(14728)

//    주어진 데이터를 여러번 사용가능
//    호텔 - 백준
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());
        int[][] stuff = new int[N][2];
        int[] dp = new int[K + 1]; // 무게 x에서 최대의 가치
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            stuff[i][0] = Integer.parseInt(st2.nextToken());
            stuff[i][1] = Integer.parseInt(st2.nextToken());
        }
        for (int i = 0; i < stuff.length; i++) {
//        뒤에서 부터 무게를 순회(앞에서 부터 순회 시 하나의 값이 여러번 사용될 소지 있음)
            for (int j = K; j >= stuff[i][0]; j--) {
//            물건을 담았을 때, 담지 않았을 때 최대값 비교
                dp[j] = Math.max(dp[j], dp[j - stuff[i][0]] + stuff[i][1]);
            }
        }
        System.out.println(dp[K]);
    }
}
