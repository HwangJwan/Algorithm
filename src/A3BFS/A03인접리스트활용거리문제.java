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
        for(int i=0;i< edge.length;i++) {
            int a=edge[i][0];
            int b=edge[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(List<Integer> a:list) {
            a.sort(Comparator.naturalOrder());
        }
        Queue<int[]> q=new LinkedList<>();
        visited=new boolean[n+1];
        q.add(new int[]{1,0});
        visited[1]=true;
        int max_distance=-1;
        int answer=0;
        while(!q.isEmpty()) {
            int[] cur=q.poll();
            if(max_distance<cur[1]) {
                max_distance=cur[1];
                answer=1;
            }
            else if(max_distance==cur[1]) {
                answer++;
            }
            for(int a:list.get(cur[0])) {
                if(visited[a]) continue;
                visited[a]=true;
                q.add(new int[]{a,cur[1]+1});
            }
        }
    }
}
