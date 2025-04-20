import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 도시 개수
		int n = sc.nextInt();
		
		// 거리
		int[] length = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			length[i] = sc.nextInt();
		}
		
		// 기름 가격
		int[] price = new int[n];
		for (int i = 0; i < n; i++) {
			price[i] = sc.nextInt();
		}
		
		long total = 0;	// 비용 초기화, 21억 넘을 수도 있으니까 long 타입
		int min = price[0];	// 일단 첫 번째 기름값을 min으로 잡음
		for (int i = 0; i < n - 1; i++) {
			if (price[i] < min) {
				min = price[i];	// 여기보다 싼 곳 있으면 min에 넣기
			}
			
			total += (long) min * length[i];	// 최저가 가격으로 갈 수 있는 곳까지 가기, 곱했을 때 int 초과할 수도 있으니까 타입 변환
		}
		
		System.out.println(total);
		
		sc.close();
	}
}
