package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckDuplicateNumberAgain {
	
	/**
	 * 문제 1. 중복 숫자 확인
	 * 숫자로 구성된 배열이 주어졌을 때 그 배열에 중복된 숫자가 있는지 확인하는 함수를 작성하라. 
	 * 중복된 숫자가 있다면 true 없다면 false
	 * 예 ) 1 2 3 4 5 6 ==> false
	 * 예 ) 1 1 2 2 3 1 ==> true
	 */
	
	public static void main(String[] args) {
		CheckDuplicateNumberAgain checkDuplicateNumberAgain = new CheckDuplicateNumberAgain();
		int[] numbers = {1,2,3,4,2};
		//System.out.println(checkDuplicateNumberAgain.checkDuplicateNumber(numbers));
//		System.out.println(checkDuplicateNumberAgain.solution1(numbers));
//		System.out.println(checkDuplicateNumberAgain.solution2(numbers));
		System.out.println(checkDuplicateNumberAgain.solution3(numbers));
	}
	
	//시간복잡도 O(n제곱)
	//공간복잡도 O(1) 배열 하나만 사용
	public boolean checkDuplicateNumber (int[] numbers) {
		for(int i = 0; i < numbers.length-1; i++) {
			for(int j = i+1 ; j<numbers.length; j++) {
				if(numbers[i] == numbers[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	/*문제 풀이 프로세스
	 * 1. 문제에 대해 질문하기
	 * - 이 배열은 정렬이 되어 있나요? 
	 * - 이 배열의 중복된 숫자가 몇개 인지? (큰 영향은 없다.)
	 * 가장 단순한 해결책 
	 * 이중 for문
	 * 시간 복잡도: O(n^2) 
	 * 공간 복잡도: O(1)
	 */
	
	private boolean solution1(int[] numbers) {
		for(int i = 0; i<numbers.length; i++) {
			for(int j = i+1; j<numbers.length;j++) {
				if(numbers[i] == numbers[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	/** 정렬 이후에 순회
	 * 배열 문제는 항상 정렬이 되었는지를 물어보아야 한다. 
	 * 배열이 만약 정렬이 되어 있다면? 
	 * 1 2 2 3 4 5 6 (중복 숫자들이 붙어 있다.)
	 * 한 번만 순회를 하면서 바로 옆만 보면 된다. 
	 * 하지만, 이 문제는 정렬이 되어 있지 않았다. 그래서 정렬을 하면 된다. 
	 */
	
	private boolean solution2(int[] numbers) {
		Arrays.sort(numbers); //O(NlongN) + O(N), O(logN) 
							 //O(NlogN) 이 더 크기 때문에 O(NlogN), O(logN)이 된다.
		for(int i = 0; i<numbers.length -1; i++) {
			if(numbers[i] == numbers[i+1]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 알고리즘에는 tradeoff 라는 개념이 존재한다. 
	 * 시간 복잡도를 낮추면 공간 복잡도가 올라가게 된다. 
	 */
	
	/**
	 * Set 을 활용한다. 
	 * Set은 Hash값을 가지고 조회를 하기 때문에 O(1)이 된다. 
	 * Contains메소드를 활용하여, 안에 들어있는 element를 확인이 가능하다. 
	 */
	private boolean solution3(int[] numbers) {
		Set<Integer> numberSet = new HashSet<>();
		for(int num:numbers) {
			if(numberSet.contains(num)) {
				return true;
			}else {
				numberSet.add(num);
			}
		}
		return false;
	}
	
}
