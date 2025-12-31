package A5Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A01계단관련 {
    public static void main(String[] args) throws IOException {
////        멀리 뛰기 - 프로그래머스

//        long answer = 0;
//        if (n == 1) {
//            return 1;
//        }
//        long[] dp = new long[n+1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i < dp.length; i++) {
//            dp[i] = (dp[i - 1]% 1234567 + dp[i - 2]% 1234567) % 1234567;
//        }
//        answer = dp[n];
//        return answer;

//        계단 오르기 - 백준
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n + 1];
//        [이전 계단 칸][이전 계단에서 올라온 칸 수]
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i < n + 1; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(score[1]);
            return;
        }
        if (n == 2) {
            System.out.println(score[1] + score[2]);
            return;
        }
        dp[1][1] = score[1];
        dp[2][1] = score[1] + score[2];
        dp[2][2] = score[2];
        for (int i = 3; i < n + 1; i++) {
//            한 칸 올라온 경우(전에 무조건 두 칸 올라왔어야함)
            dp[i][1] = dp[i - 1][2] + score[i];
//            두 칸 올라온 경우(이전에 한 칸 올라왔을 수도 있고, 두 칸 올라왔을 수도 있음)
            dp[i][2] = Math.max(dp[i - 2][1] + score[i], dp[i - 2][2] + score[i]);
        }
        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }
}
