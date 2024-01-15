import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int[] useCount = new int[10];

        int result = A * B * C;
        while (result > 0) {
            useCount[result % 10]++;
            result /= 10;
        }

        for (int count : useCount) {
            System.out.println(count);
        }
    }
}
