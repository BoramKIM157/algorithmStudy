package selfStudy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainDuplicateNumber {
	/**
	 * 문제 1. 중복 숫자 확인
	 * 숫자로 구성된 배열이 주어졌을 때 그 배열에 중복된 숫자가 있는지 확인하는 함수를 작성하라. 중복된 숫자가 있다면 true 없다면 false
	 * 예 ) 1 2 3 4 5 6 ==> false
	 * 예 ) 1 1 2 2 3 1 ==> true
	 */

	public static void main(String[] args) {
		ContainDuplicateNumber containDuplicateNumber = new ContainDuplicateNumber();
		int[] number = {1, 2, 3, 4, 5, 3};
		//		System.out.println(containDuplicateNumber.solution1(number));
		//		System.out.println(containDuplicateNumber.solution2(number));
		System.out.println(containDuplicateNumber.solution3(number));
	}

	//시간복잡도 O(n^2)
	//공간복잡도 O(1)
	private boolean solution1(int[] number) {
		for (int i = 0; i < number.length; i++) {
			for (int j = i + 1; j < number.length; j++) {
				if (number[i] == number[j]) {
					return true;
				}
			}
		}
		return false;
	}

	//시간복잡도 O(nlogn)
	//공간복잡도 O(n)
	private boolean solution2(int[] number) {
		Arrays.sort(number);
		for (int i = 0; i < number.length - 1; i++) {
			if (number[i] == number[i + 1]) {
				return true;
			}
		}
		return false;
	}

	//시간복잡도 O(N)
	//공간복잡도 O(N)
	private boolean solution3(int[] number) {
		Set<Integer> numberSet = new HashSet();
		for (int num : number) {
			if (numberSet.contains(num)) {
				return true;
			} else {
				numberSet.add(num);
			}
		}
		return false;
	}
}
