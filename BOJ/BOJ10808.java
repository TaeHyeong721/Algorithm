import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class BOJ10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] alphabet = new int[26];

        //알파벳 소문자는 a(97) ~ z(122)다.
        for (char letter : word.toCharArray()) {
            alphabet[letter - 'a']++;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int count : alphabet) {
            sj.add(String.valueOf(count));
        }

        System.out.println(sj);
    }
}
