package A3BFS;

import java.util.*;

public class A01BFS방문순서 {
    static boolean[] visited;
    static List<List<Integer>> adjList;
    public static void main(String[] args) {
        int[][] nodes = {{0, 1}, {2, 0}, {1, 3}, {2, 3}, {2, 4}};
        adjList=new ArrayList<>();
        visited=new boolean[nodes.length];
        for(int i=0;i< 5;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] a:nodes) {
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }
        for(List<Integer> a:adjList) {
            a.sort(Comparator.naturalOrder());
        }
        Queue<Integer> myQue=new LinkedList<>();
        myQue.add(0);
        visited[0]=true;
        while(!myQue.isEmpty()) {
            int cur=myQue.poll();
            System.out.println(cur);
            for(int a:adjList.get(cur)) {
                if(visited[a]) continue;
                myQue.add(a);
//                bfs에서 visited는 queue에 add하는 시점에 true세팅 해야함
                visited[a]=true;
            }
        }
    }

}

//  관련문제
//  DFS/BFS - 백준(1260)
//  트리의 부모 찾기 - 백준
//  연결요소의 개수 - 백준(11724)