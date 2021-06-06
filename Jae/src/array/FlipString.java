package quizArray;

public class FlipString {
	
	/* 배열 조회, 순회, 반복문, 수학기능, Java를 String builder의 API를 아는 지
	 * 문제2 문자열 뒤집기
	 * 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라. 
	 * 예) hello ==> olleh
	 * 예) happy new year ==> reay wen yppah
	 */
	
	public static void main(String[] args) {
		FlipString flip = new FlipString();
		flip.solution3("hello");
		System.out.println(flip.solution3("hello"));
	}
	
	//해당 문제는 문자열을 거꾸로 뒤집는 함수인거 같습니다. 
	//혹시 공백도 문자로 생각해서 뒤집어야 하나요? 숫자도 있나요?
	// 이 문제의 시간복잡도는 문자열을 캐릭터 하나씩 쪼개서 위치를 바꾸는 거기 때문에 O(n)
	//공간 복잡도 O(1)
	
	/*
	 * 올바른 정답 물어보기 프로세스
	 * 1) 문제를 명확하게 이해했는지 확인
	 * 2) 가정할 수 있거나 가정되어 있거나, 재차 확인(문제에서 입력값이 가정이 되었나요? 제한이 되었나요?)
	 * 3) 실제 예를 들어가며 재차 확인
	 * 4) 문제 해결책 고민
	 * 5) 문제 해결책에 대한 설명 (이렇게 풀고 싶다. 이렇게 풀면 공간복자도와 시간복잡도가 이렇게 될 거 같다)
	 * 6) 오케이 싸인이 떨어지면, 코드 작성
	 * 7) 예시 값을 가지고 테스트
	 */
	
	/*
	 * 1) 주어진 문자열을 순서대로 뒤집는 함수가 맞을까요?
	 * 2) 주어진 문자열이 전부 동일한 경우가 있을까요? 
	 * 3) 예를 들면, pig가 주어지면 gip가 출력이 되는게 맞을까요?
	 * 4) 이 문제는 문자열은 char형의 배열이니, char형의 배열에서 for문을 돌려 제일 첫번째와 제일 마지막의 순서를 바꾸고, 
	 * 이 작업을 중간까지만 수행을 하면 되는 것처럼 보입니다. 그래서 시간복잡도의 경우 O(n)이 되고, 
	 * 공간 복잡도는 O(1)이 됩니다. 
	 * 5) 코드를 작성해도 될까용?
	 * 6) 코드 작성을 완료했습니다. 앞서 제시한 예시를 이용해서 테스트를 해보겠습니다. 혹시 제가 놓친 코너 케이스들이 있을까요?
	 */
	
	
//	private String solution1(String word) {	
//		
//		for(int i = 0; i<word.length()/2;i++) {
//			int j = word.length() - i;
//			char box = 0;
//			box = word[i];
//			word[i] = word[j];
//			word[j] = box;
//		}
//		
//		return word;
//	}
	
	// h e l l o -> o l l e h
	// 시간복잡도: O(N) 루프를 순회한다.
	// 공간복잡도: O(1) 메세지의 사이즈 만큼 배열을 만들어서, O(N)
	private char[] soulutionbaek1(char[] message) {
		char[] reversedMessage = new char[message.length];
		//4-4->0
		//4-3->1
		//4-2->2
		//4-1->3
		//4-0->4
		//규칙을 찾아야 한다.
		for(int i = message.length-1 ; i >= 0 ; i--) {
			reversedMessage[message.length-1-i] = message[i];
		}
		return reversedMessage;
	}
	
	//h e l l o
	// h o
	// e l
	// 4-0 = 4
	// 4-1 = 3
	//시간복잡도 O(N)
	//공간복잡도 O(1)
	private char[] soulutionbaek2(char[] message) {
		for(int i = 0; i<message.length/2;i++) {
			char temp = message[i];
			message[i] = message[message.length-1 -i];
			message[message.length-1 -i] = temp;			
		}
		return message;
	}
	
	//Java가 제공하는 StringBuilder 사용법 학습하기
	private String solution3(String message) {
		String msg = new StringBuilder(message).reverse().toString();
		return msg;
	}
}
