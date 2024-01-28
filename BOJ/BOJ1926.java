import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ1926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputSize = br.readLine().split(" ");
        int n = Integer.parseInt(inputSize[0]);
        int m = Integer.parseInt(inputSize[1]);

        int[][] board = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        int mx = 0; //그림의 최댓값
        int num = 0; //그림의 수

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 || visit[i][j]) continue;
                num++;
                Queue<Node> queue = new ArrayDeque<>();
                visit[i][j] = true;
                queue.add(new Node(i, j));
                int area = 0;
                while (!queue.isEmpty()) {
                    area++;
                    Node cur = queue.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (visit[nx][ny] || board[nx][ny] != 1) continue;
                        visit[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                    }
                }
                mx = Integer.max(mx, area);
            }
        }

        System.out.println(num);
        System.out.println(mx);
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
