import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BOJ4197 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputSize = br.readLine().split(" ");

        int n = Integer.parseInt(inputSize[0]);
        int m = Integer.parseInt(inputSize[1]);

        int[][] board = new int[n][m];
        int[][] distFire = new int[n][m];
        int[][] distJihoon = new int[n][m];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Node> jihoon = new ArrayDeque<>();
        Queue<Node> fire = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distFire[i][j] = -1;
                distJihoon[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if ("#".equals(split[j])) {
                    board[i][j] = 1;
                    continue;
                }
                if ("J".equals(split[j])) {
                    distJihoon[i][j] = 0;
                    jihoon.add(new Node(i, j));
                    continue;
                }
                if ("F".equals(split[j])) {
                    distFire[i][j] = 0;
                    fire.add(new Node(i, j));
                }
            }
        }

        while (!fire.isEmpty()) {
            Node cur = fire.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == 1 || distFire[nx][ny] >= 0) continue;

                distFire[nx][ny] = distFire[cur.x][cur.y] + 1;
                fire.add(new Node(nx, ny));
            }
        }

        while (!jihoon.isEmpty()) {
            Node cur = jihoon.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    System.out.println(distJihoon[cur.x][cur.y] + 1);
                    return;
                }

                if (board[nx][ny] == 1 || distJihoon[nx][ny] >= 0) continue;
                if (distFire[nx][ny] != -1 && distFire[nx][ny] <= distJihoon[cur.x][cur.y] + 1) continue;

                distJihoon[nx][ny] = distJihoon[cur.x][cur.y] + 1;
                jihoon.add(new Node(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static class Node {
        public final int x;
        public final int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
