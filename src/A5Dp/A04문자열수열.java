package A5Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class A04문자열수열 {
//    가장 긴 증가하는 부분 수열(11053) - 백준

//    가장 긴 증가하는 부분 수열4 - 백준
//    =>별도의 배열을 하나 더 만들어서, 직전의 값(index) 기록
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        List<Integer> list = new ArrayList<>();
        dp[0] = 1;
        int[] prev = new int[N];
        Arrays.fill(prev, -1);
//    해당 인덱스 이전까지 dp의 최대 && 해당 인덱스의 숫자가 이전 인덱스의 num 수보다 커야함
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (dp[j] > max && num[i] > num[j]) {
                    max = dp[j];
//                    dp의 최대값이 갱신되는 시점의 이전 인덱스를 배열에 담음
                    prev[i] = j;
                }
            }
            dp[i] = max + 1;
        }
        int max = Integer.MIN_VALUE;
        for (int a : dp) {
            if (max < a) max = a;
        }
        System.out.println(max);
        int maxDpIndex = -1;
        int maxDp = Integer.MIN_VALUE;
//        dp가 최대가 되는(수열의 마지막이 되는 수의) index구함
        for (int i = 0; i < dp.length; i++) {
            if (maxDp < dp[i]) {
                maxDp = dp[i];
                maxDpIndex = i;
            }
        }
        int[] arr = new int[max];
//        뒤에서 부터 dp가 최대가 된 인덱스에 해당하는 수를 저장
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = num[maxDpIndex];
            maxDpIndex = prev[maxDpIndex];
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
