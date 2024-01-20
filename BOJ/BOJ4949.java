import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            Stack<Character> bracket = new Stack<>();
            String line = br.readLine();

            if (line.length() == 1 && line.charAt(0) == '.') {
                return;
            }

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c == '.') {
                    if (i == 0) {
                        return;
                    }

                    if (bracket.isEmpty()) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }
                }

                if (c == '(' || c == '[') {
                    bracket.push(c);
                    continue;
                }

                if (c == ')') {
                    if (bracket.isEmpty() || bracket.peek() != '(') {
                        System.out.println("no");
                        break;
                    } else {
                        bracket.pop();
                    }
                }

                if (c == ']') {
                    if (bracket.isEmpty() || bracket.peek() != '[') {
                        System.out.println("no");
                        break;
                    } else {
                        bracket.pop();
                    }
                }
            }
        }
    }
}
