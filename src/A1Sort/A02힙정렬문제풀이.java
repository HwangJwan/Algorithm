package A1Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class A02힙정렬문제풀이 {
    //    명예의 전당 - 프로그래머스
//    야근지수 - 프로그래머스
    public static void main(String[] args) {
        long answer = 0;
        int n=3;
        int[] works={1,1};
        Queue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<works.length;i++) {
            pq.add(works[i]);
        }
        for(int i=0;i<n;i++) {
            pq.add(pq.poll()-1);
        }
        while(!pq.isEmpty()) {
            int a=pq.poll();
            if(a<0) {
                answer=0;
//                return answer;
            }
            answer+=a*a;
        }
//        return answer;
    }
}
