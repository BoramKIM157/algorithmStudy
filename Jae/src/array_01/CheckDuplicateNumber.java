package array_01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckDuplicateNumber {

	/**
	 * 문제 1. 중복 숫자 확인
	 * 숫자로 구성된 배열이 주어졌을 때 그 배열에 중복된 숫자가 있는지 확인하는 함수를 작성하라. 중복된 숫자가 있다면 true 없다면 false
	 * 예 ) 1 2 3 4 5 6 ==> false
	 * 예 ) 1 1 2 2 3 1 ==> true
	 * 예상 시간 복잡도 : O(n²)
	 * 예쌍 공간 복잡도: O(1) : list가 필요하지 않는다.
	 */

	//배열이 정령되었는지 (시간 복잡도)
	//중복된 숫자가 몇개 있는지
	//단순한 해결 책

	public static void main(String[] args) {
		//		int[] numbers = {9, 1, 2, 7, 4};
		//		boolean b = solution1(numbers);
		//		System.out.print(b);

		//		CheckDuplicateNumber checkDuplicateNumber = new CheckDuplicateNumber();
		//		System.out.println(checkDuplicateNumber.soulutionbaek1(new int[] {1,2,3,4,5, 2}));

		CheckDuplicateNumber checkDuplicateNumber = new CheckDuplicateNumber();
		System.out.println(checkDuplicateNumber.solution3baek(new int[] {1, 2, 3, 4, 5}));
	}

	//	public static boolean solution1(int[] numbers) {
	//		for(int i = 0; i<numbers.length; i++) {
	//			System.out.println("i첫번째 루프 i값"+numbers[i]);
	//			for(int j = i+1; j<=numbers.length-1; j++) {
	//				if(numbers[i] == numbers[j]) {
	//					System.out.println("j 루프시작");
	//					System.out.println("i 값 :"+numbers[i]);
	//					System.out.println("j 값 :"+numbers[j]);
	//					return true;
	//				}
	//			}
	//		}
	//		return false;
	//	}

	private boolean soulutionbaek1(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					return true;
				}
			}
		}
		return false;
	}

	//배열이 정렬되면, 문제가 간단해진다.
	//한 번만 순회하면 된다.

	private boolean solution2(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] == numbers[i + 1]) {
				return true;
			}
		}
		return false;
	}

	//만약 정렬이 되지 않았다면, 정렬을 하는게 더 빠르다.

	private boolean solution2baek(int[] numbers) {
		Arrays.sort(numbers); //O(NlogN) + O(N) = O(NlogN), O(logN) 퀵 소트

		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] == numbers[i + 1]) {
				return true;
			}
		}
		return false;
	}

	private boolean solution3baek(int[] numbers) {
		Set<Integer> numberSet = new HashSet<>();

		for (int num : numbers) {
			if (numberSet.contains(num)) {
				return true;
			} else {
				numberSet.add(num);
			}
		}
		return false;
	}

}
