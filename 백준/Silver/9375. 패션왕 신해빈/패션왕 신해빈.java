import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 개수 입력
		int testCase = sc.nextInt();
		
		// 테스트 케이스 개수만큼 반복
		for (int i = 0; i < testCase; i++) {
			int n = sc.nextInt();	// 의상 개수 입력
            Map<String, Integer> clothes = new HashMap<>();
			for (int j = 0; j < n; j++) {
				sc.next();	// 일단 입력은 받고 날리자
				String tmp = sc.next();	// 옷 종류
				
				if (clothes.get(tmp) == null) {
					clothes.put(tmp, 1);
				}	// Map에 옷 종류가 저장이 안 돼있으면 1로 저장
				else {
					clothes.put(tmp, clothes.get(tmp) + 1);
				}	// 저장돼있으면 값 갖고 와서 1 더해주기 
			}
			
			int result = 1;	// 경우의 수 담을 변수
			Set<Entry<String, Integer>> entirySet = clothes.entrySet();
			for (Entry<String, Integer> e: entirySet) {
				result *= (e.getValue() + 1);	// 착용하지 않는 경우를 고려한 1 더하기
			}
			
			System.out.println(result - 1);	// 출력할 때 알몸 경우 빼기
		}
		
		sc.close();
	}
}
