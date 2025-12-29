package A3BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A03인접리스트활용거리문제 {
    //    촌수계산 - 백준
//    가장 먼 노드 - 프로그래머스
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] edge={{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int n=6;
        for(int i=0;i<=n;i++) {
            list.add(new ArrayList<>());
        }
        for(int[] a:edge) {
            list.get(a[0]).add(a[1]);
            list.get(a[1]).add(a[0]);
        }
        visited=new boolean[n+1];
        Queue<int[]> bfs=new LinkedList<>();
        bfs.add(new int[]{1,0});
        visited[1]=true;
        int max_distance=-1;
        int answer=0;
        while(!bfs.isEmpty()) {
            int[] cur=bfs.poll();
            if(cur[1]>max_distance) {
                answer=1;
                max_distance=cur[1];
            }
            else if(cur[1]==max_distance) answer++;
            for(int a:list.get(cur[0])) {
                if(visited[a]) continue;
                bfs.add(new int[]{a,cur[1]+1});
                visited[a]=true;
            }
        }
        System.out.println(answer);
    }
}
