package array_02;

public class ReverseString {

	/*
	 * 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
	 * ex) hello > olleh
	 * ex) happy new year > reay wen yppah
	 */

	public static void main(String[] args) {
		ReverseString reverseString = new ReverseString();
		char[] word = {'h', 'e', 'l', 'l', 'o'};
		System.out.println(reverseString.solution1(word));
		System.out.println(reverseString.solutionBaek1("Hello".toCharArray()));
		System.out.println(reverseString.solutionBaek2("Hello".toCharArray()));
	}

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
	 * 1) 이 문제는 주어진 문자열을 뒤집는 문제입니까? 예를 들어, cat 라면 tac로 뒤집으면 됩니까?
	 * 2) 문제에서 입력값은 공백도 포함하나요?
	 * 3) 문자열을 뒤집는데, 절반만 뒤집는다. 이렇게 할 경우 시간 복잡도는 O(n), 공간복잡도는 O(1)이 될 거 같다.
	 */

	// 01234 length:5
	// 0, 4 swap / 1, 3 swap / 2 가만히
	// i, lenght-i-1 /
	//시간복잡도: O(n), 공간복잡도: O(1)
	private char[] solution1(char[] word) {
		for (int i = 0; i < word.length / 2; i++) {
			char temp = word[i];
			word[i] = word[word.length - i - 1];
			word[word.length - i - 1] = temp;
		}
		return word;
	}

	// H e l l o -> o l l e H
	// 시간복잡도 O(N), 공간 복잡도 O(N)
	private char[] solutionBaek1(char[] message) {
		char[] reversedMessage = new char[message.length];

		// 4 - 4 -> 0
		// 4 - 3 -> 1
		// 4 - 2 -> 2
		// 4 - 1 -> 3
		// 4 - 0 -> 4
		for (int i = message.length - 1; i >= 0; i--) {
			reversedMessage[message.length - 1 - i] = message[i];
		}
		return reversedMessage;
	}

	// h e l l o
	// h -> o
	// e -> l
	// 4 - 0 > 4
	// 4 - 1 > 3
	// 시간 복잡도 O(n), 공간복잡도 O(1)
	private char[] solutionBaek2(char[] message) {
		for (int i = 0; i < message.length / 2; i++) {
			char temp = message[i];
			message[i] = message[message.length - 1 - i];
			message[message.length - 1 - i] = temp;
		}
		return message;
	}

	//String Builder 학습하기

}
