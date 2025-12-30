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
        int[][] dp = new int[n + 1][2];
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
        dp[1][0] = score[1];
        dp[2][0] = score[1] + score[2];
        dp[2][1] = score[2];
        for (int i = 3; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][1] + score[i];
            dp[i][1] = Math.max(dp[i - 2][0] + score[i], dp[i - 2][1] + score[i]);
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}
