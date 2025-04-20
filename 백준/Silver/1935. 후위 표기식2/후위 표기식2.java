import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String postfix = br.readLine();
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
        // 후위 표기식 계산할 스택
        Stack<Double> stack = new Stack<>();
        
        for (char ch : postfix.toCharArray()) {
            if (Character.isLetter(ch)) {
                // 문자면 대응하는 값 넣음
                stack.push((double) numbers[ch - 'A']);
            } else {
                // 연산자면 스택에서 두 개 값 꺼내서 계산, 결과는 다시 스택에 넣음
                double b = stack.pop();
                double a = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        
        // 결과 꺼내기
        double result = stack.pop();
        System.out.println(String.format("%.2f", result));
	}
}