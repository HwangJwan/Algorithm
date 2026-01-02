package A7이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//  이분탐색문제는 이분탐색의 대상을 어떤것으로 설정할지가 핵심
public class A02이분탐색활용문제 {
//    예산 - 백준 => 상한액을 이분탐색 대상으로 선정. 계산한 값이 총 예산보다 작거나 같으면 answer세팅.

//    과자 나눠주기 - 백준 => 과자길이를 이분탐색의 대상으로 선정. 계산한 값이 조카수보다 크거나 같으면 answer 세팅

//    입국 심사 - 백준
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] budget = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }
        int maxBudget = Integer.parseInt(br.readLine());
        Arrays.sort(budget);
        int start = 0;
        int end = budget[budget.length - 1];
        int answer = 0;
        while (start <= end) {
            int total = 0;
            int available_budget = (start + end) / 2;
            for (int i = 0; i < budget.length; i++) {
                if (available_budget >= budget[i]) {
                    total += budget[i];
                } else {
                    total += available_budget;
                }
            }
            if (total <= maxBudget) {
                if (total == maxBudget) {
                    answer = available_budget;
                    break;
                }
                answer = available_budget;
                start = available_budget + 1;
            } else if (total > maxBudget) {
                end = available_budget - 1;
            }
        }
        System.out.println(answer);
    }
}
