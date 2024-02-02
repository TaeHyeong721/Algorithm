import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class BOJ12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Queue<Integer> firstAisle = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            firstAisle.add(numbers[i]);
        }

        int cur = 1;
        Stack<Integer> secondAisle = new Stack<>();
        while (!firstAisle.isEmpty() || !secondAisle.isEmpty()) {
            if (!firstAisle.isEmpty() && firstAisle.peek() == cur) {
                firstAisle.poll();
                cur++;
                continue;
            }

            if (!secondAisle.isEmpty() && secondAisle.peek() == cur) {
                secondAisle.pop();
                cur++;
                continue;
            }

            if (!firstAisle.isEmpty()) {
                secondAisle.push(firstAisle.poll());
            }

            if (firstAisle.isEmpty()) {
                break;
            }
        }

        if (secondAisle.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
