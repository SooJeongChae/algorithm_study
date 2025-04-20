import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        String s = br.readLine();	// 문자열 s 입력받음
        
        StringBuilder result = new StringBuilder();	// 결과 담음
        StringBuilder tmp = new StringBuilder();	// 임시로 담음
        boolean isTag = false;	// 태그 안인지 확인
        
        // 원본 문자열 s array로 바꿔서 순회
        for (char word : s.toCharArray()) {
        	// 태그 시작하면
        	if (word == '<') {
        		result.append(tmp.reverse());	// 임시로 담아놨던 단어들 뒤집어서 결과에 담음
        		tmp.setLength(0);	// 결과에 담았으니까 임시 데이터 지워버림
        		tmp.append(word);	// 임시 데이터에 추가
        		isTag = true;	// 태그 안인지 확인하는 boolean true로 설정
        	}
        	// 태그 끝나면
        	else if (word == '>') {
        		tmp.append(word);	// 태그도 tmp에 넣어주기
        		result.append(tmp);	// 결과에 담기
        		tmp.setLength(0);	// tmp 지우기
        		isTag = false;	// isTage false로 바꿈
        	}
        	// 태그 밖이고 공백 나왔을 때
        	else if (word == ' ' && !isTag) {
        		result.append(tmp.reverse());	// tmp 뒤집어서 result에 더해줌
        		result.append(word);	// 그 담에 공백 넣어주기
        		tmp.setLength(0);	// tmp 지우기
        	}
        	else {
        		tmp.append(word);	// 것도 아니면 tmp에 word 더해주기
        	}
        }
    	result.append(tmp.reverse());	// 마지막에 안 더해진 거 더해주기
     
        System.out.println(result.toString());
	}
}