import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();
        int lastNum = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            switch (input) {
                case "pop":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(queue.poll());
                    break;
                case "size":
                   System.out.println(queue.size());
                   break;
                case "empty":
                    if (queue.isEmpty()) {
                        System.out.println(1);
                        break;
                    }
                    System.out.println(0);
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(queue.peek());
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(lastNum);
                    break;
                default:
                    int num = Integer.parseInt(input.split(" ")[1]);
                    queue.offer(num);
                    lastNum = num;
            }
        }
    }
}
