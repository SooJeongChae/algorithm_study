import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();	// 테스트 케이스 개수 T
		for (int i = 0; i < T; i++) {
			int x1 = sc.nextInt();	// 출발점 x
			int y1 = sc.nextInt();	// 출발점 y
			int x2 = sc.nextInt();	// 도착점 x
			int y2 = sc.nextInt();	// 도착점 y
			
			int count = 0;	// 행성계 진입/이탈 횟수 담을 변수
			int n = sc.nextInt();	// 행성계 개수
			for (int j = 0; j < n; j++) {
				int cx = sc.nextInt();	// 행성계 중점 x
				int cy = sc.nextInt();	// 행성계 중점 y
				int r = sc.nextInt();	// 행성계 반지름
				
				boolean startInside = isInside(x1, y1, cx, cy, r);	// 시작점이 원 안에 있는지
				boolean endInside = isInside(x2, y2, cx, cy, r);	// 도착점이 원 안에 있는지
				
				if (startInside != endInside) {
					count++;
				}	// 하나만 원 안에 있을 때 카운트 횟수 더해주기
				
			}
			System.out.println(count);
		}
		
		sc.close();
	}
	
    // 원 내부에 있는지 확인해서 true false로 반환
    static boolean isInside(int x, int y, int cx, int cy, int r) {
        return (x - cx) * (x - cx) + (y - cy) * (y - cy) < r * r;
    }
}