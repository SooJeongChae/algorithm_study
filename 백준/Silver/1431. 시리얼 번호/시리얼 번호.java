import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()) {
                    return 1;
                } else if (s1.length() < s2.length()) {
                    return -1;
                }

                int s1Sum = 0;
                int s2Sum = 0;
                for (int i = 0; i < s1.length(); i++) {
                    if ('0' <= s1.charAt(i) &&'9' >= s1.charAt(i)) {
                        s1Sum += s1.charAt(i) - '0';
                    }

                    if ('0' <= s2.charAt(i) && '9' >= s2.charAt(i)) {
                        s2Sum += s2.charAt(i) - '0';
                    }
                }

                if (s1Sum > s2Sum) {
                    return 1;
                } else if (s1Sum < s2Sum) {
                    return -1;
                }

                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) > s2.charAt(i)) {
                        return 1;
                    } else if (s1.charAt(i) < s2.charAt(i)) {
                        return -1;
                    }
                }

                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
