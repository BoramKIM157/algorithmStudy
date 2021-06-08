package array;

public class ReverseString {
	
	public static char[] solution1 (char[] message) {
		char[] reversedString = new char[message.length];
		for(int i=message.length-1; i>=0; i--) {
			reversedString[message.length-i-1] = message[i];
		}
		return reversedString;
	}
	
	//swap 시간복잡도 O(N), 공간복잡도 O(1)
	public static char[] solution2 (char[] message) {
		for(int i=0; i<message.length/2; i++) {
			char temp = message[i];
			message[i] = message[message.length-i-1];
			message[message.length-i-1] = temp;
		}
		return message;
	}
	
	//StringBuilder : String 클래스의 단점을 보완한 class (String 객체는 수정할 수 X) 
	//String 문자열에 += -> 힙 영역에 새로운 객체를 만들어서 참조(스택에서) -> 객체 수 늘어나면서 프로그램 성능 저하 요인 
	//문자열 변경 작업 시, StringBuffer(멀티스레드 환경) 또는 StringBuilder(단일스레드환경) 사용
	//기본 생성사 StringBuilder() : 16개 문자 저장할 수 있는 초기 버퍼 생성 
	//StringBuilder(int capacity)생성자 : 주어진 개수의 크기만큼 초기 버퍼 생성  -> 버퍼 크기 자동으로 늘어나므로 초기 버퍼 크기 중요하지 X
	//메소드 : append(), insert(), delete(), replace(), reverse() 등
	public static String solution3(char[] message) {
		StringBuilder sb = new StringBuilder(message.length);
		sb.append(message);
		sb.reverse();
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(solution1("start".toCharArray()));
		System.out.println(solution2("Array".toCharArray()));
		System.out.println(solution3("coffee".toCharArray()));
	}

}
