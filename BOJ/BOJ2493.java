import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringJoiner;

public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringJoiner sj = new StringJoiner(" ");
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{100_000_001, 0});

        String[] heights = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(heights[i-1]);
            while (stack.peek()[0] < height) {
                stack.pop();
            }

            sj.add(String.valueOf(stack.peek()[1]));
            stack.push(new int[]{height, i});
        }

        System.out.println(sj);
    }
}
