import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String target = br.readLine();
		
		int count = 0;	// 조각 개수
		int leftStick = 0;	// 왼쪽 막대기 끝..
		
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) == '(') {
				leftStick++;
			}
			else {
				leftStick--;	// 오른쪽 조각이니까 닫기
				
				// 바로 앞이 ( 면 레이저
				if (target.charAt(i - 1) == '(') {
					count += leftStick;	// 레이저일 때 나무 조각 썰림
				}
				// 나무조각 끝이면 +1 해주기
				else {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
