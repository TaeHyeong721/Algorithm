import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputSize = br.readLine().split(" ");

        int n = Integer.parseInt(inputSize[0]);
        int m = Integer.parseInt(inputSize[1]);

        int[][] board = new int[n][m];
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(split[j]);
                dist[i][j] = -1;
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Node> queue = new ArrayDeque<>();
        dist[0][0] = 1;
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == 0 || dist[nx][ny] > -1) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                queue.add(new Node(nx, ny));
            }
        }

        System.out.println(dist[n-1][m-1]);
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
