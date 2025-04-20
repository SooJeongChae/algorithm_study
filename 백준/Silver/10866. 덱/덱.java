import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_front":
                    int frontNum = Integer.parseInt(input[1]);
                    deque.addFirst(frontNum);
                    break;
                case "push_back":
                    int backNum = Integer.parseInt(input[1]);
                    deque.addLast(backNum);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.pollFirst());
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.pollLast());
                    break;
                case "size":
                   System.out.println(deque.size());
                   break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println(1);
                        break;
                    }
                    System.out.println(0);
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.peekFirst());
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.peekLast());
                    break;
            }
        }
    }
}
