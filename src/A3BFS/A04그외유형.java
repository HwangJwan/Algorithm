package A3BFS;

import java.util.LinkedList;
import java.util.Queue;

public class A04그외유형 {
    //    이차원배열의 최단거리 : 게임 맵 최단거리 - 프로그래머스

//    비노드형식의 거리문제 : 숨바꼭질 - 백준1697
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        map= new int[][]{{1, 0, 1, 1, 1},
                         {1, 0, 1, 0, 1},
                         {1, 0, 1, 1, 1},
                         {1, 1, 1, 0, 1},
                         {0, 0, 0, 0, 1}};
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        visited=new boolean[map.length][map[0].length];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0,1});
        visited[0][0]=true;
        int answer=-1;
        loop:
        while(!q.isEmpty()) {
            int[] cur=q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx>=0&&nx< map.length&&ny>=0&&ny<map[0].length) {
                    if(visited[nx][ny]||map[nx][ny]!=1) continue;
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny,cur[2]+1});
                    if(nx== map.length-1&&ny==map[0].length-1) {
                        answer=cur[2]+1;
                        break loop;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
