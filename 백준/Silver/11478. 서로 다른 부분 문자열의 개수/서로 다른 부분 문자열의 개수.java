import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();	// String으로 문자열 s 입력
		char[] sArray = s.toCharArray();	// 캐릭터 배열로 변환
		
		Set<String> set = new HashSet<String>();	// 중복 안 되게 저장하려고 set으로 설정
		for (int i = 0; i < sArray.length; i++) {
			String tmp = "";
			tmp += sArray[i];
			set.add(tmp);
			for (int j = i + 1; j < sArray.length; j++) {
				tmp += sArray[j];
				set.add(tmp);
			}
		}
		
		System.out.println(set.size());
		
		sc.close();
	}
}