package array;

public class ReverseString {
	
	static char[] solution1 (char[] message) {
		char[] reversedString = new char[message.length];
		
		for(int i=message.length-1; i>=0; i--) {
			reversedString[message.length-i-1] = message[i];
		}
		return reversedString;
	}
	
	//swap 시간복잡도 O(N), 공간복잡도 O(1)
	static char[] solution2 (char[] message) {
		for(int i=0; i<message.length/2; i++) {
			char temp = message[i];
			message[i] = message[message.length-i-1];
			message[message.length-i-1] = temp;
		}
		return message;
	}
	
	public static void main(String[] args) {
		System.out.println(solution1("hello".toCharArray()));
		System.out.println(solution2("coffee".toCharArray()));
	}

}
