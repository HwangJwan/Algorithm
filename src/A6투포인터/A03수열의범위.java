package A6투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  정렬하면 안되는 경우
//  start<=end의 조건
//  start와 end가 같이 출발
public class A03수열의범위 {
    public static void main(String[] args) throws IOException {
//        수들의 합2(2003)
//        수열(2559) - 백준
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st1.nextToken());
//        int M = Integer.parseInt(st1.nextToken());
//        int[] arr = new int[N];
//        int count = 0;
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st2.nextToken());
//        }
//        int start = 0;
//        int end = 0;
//        int sum = arr[0];
////        두 포인터가 모두 배열 끝까지 탐색할때까지
//        while (start <=end && end < arr.length) {
////            합이 작으면 end오른쪽, 증가된 값 가산
//            if (sum < M) {
//                end++;
//                sum += arr[end];
//            }
////            합이 크면 start 오른쪽, 이전 값 감산
//            else if (sum > M) {
//                sum -= arr[start];
//                start++;
//            }
////            같으면 경우의 수+1, end 오른쪽, 증가된 값 가산
//            else {
//                count++;
//                end++;
//                if(end==arr.length) break;
//                sum += arr[end];
//            }
//        }
//        System.out.println(count);
//        연속된 부분 수열의 합 - 프로그래머스
//
//        int[] sequence = {2,2,2,2,2};
//        int k = 6;
//        List<int[]> myList = new ArrayList<>();
//        int start = 0;
//        int end = 0;
//        int sum= sequence[0];
//        while (true) {
//            if(sum<=k) {
//                if(sum==k) {
//                    myList.add(new int[]{start,end});
//                }
//                end++;
//                if(end==sequence.length) break;
//                sum+=sequence[end];
//            }
//            else {
//                sum-=sequence[start];
//                start++;
//            }
//        }
//        myList.sort((o1, o2) -> {
//            int o1Length=o1[1]-o1[0];
//            int o2Length=o2[1]-o2[0];
//            if(o1Length==o2Length) {
//                return o1[0]-o2[0];
//            }
//            return o1Length-o2Length;
//        });
//        int[] answer=myList.get(0);
//        System.out.println(Arrays.toString(answer));

//        숫자의 표현 - 프로그래머스

        int n=15;
        int[] arr=new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=i+1;
        }
        List<int[]> list=new ArrayList<>();
        int start=0;
        int end=0;
        int sum=arr[0];
        while(true) {
            if(sum>n) {
                sum-=arr[start];
                start++;
            }
            else if(sum<n) {
                end++;
                if(end==arr.length) break;
                sum+=arr[end];
            }
            else if(sum==n) {
                list.add(new int[]{start,end});
                sum-=arr[start];
                start++;
            }
        }
        int answer=list.size();
        System.out.println(answer);
    }
}
