package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumSolutions {
	
	/*
	 * 숫자로 구성된 배열 numbers와 target 숫자 하나가 주어졌을 때, numbers 배열에 들어있는
	 * 두 수를 더해 target 숫자를 만들 수 있는 인덱스 두 개를 찾는 함수를 작성하라
	 * 
	 * 예) numbers = [2,3,5,7] target = 8 => 8을 만들 수 있는 3과 5의 인덱스인 1,2를 리턴한다.
	 * 예) numbers = [1,2,6,8] target = 9 => 9를 만들 수 있는 1과 8의 인덱스인 0,3을 리턴한다.
	 * 
	 * numbers 배열에 중복되는 숫자는 없으며 target 숫자를 만들 수 있는 조합은 하나 뿐이라고 가정해도 좋다.
	 */
	
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
	 * 1) 이 문제는 배열에 존재하는 숫자를 이용하여, 목표한 숫자를 만드는 배열의 index를 구하는 문제가 맞을까요? 
	 * 2) 숫자는 음수가 있을 수 있을까요? 중복되는 숫자는 없고, target숫자를 만드는 조합은 한 개뿐이라고
	 * 가정해도 될까요?
	 * 3) 예를 들어 numbers 배열에 [1, 2, 8, 9] 가 있다면, target은 17일 떄, 8과 9의 배열의 
	 * index인 2와 3을 리턴하는게 맞을까요? 
	 * 4) 고민
	 * 5) 배열의 시작부터 바로 옆의 index부터 하나씩 더하면서 target과 비교를 하고 싶은데, 이렇게 한다면
	 * 시간복잡도는 O(N2) 공간복잡돈느 O(N2)이 될거 같습니다. 
	 * 6) 
	 */
	
	public static void main(String[] args) {
		TwoSumSolutions twoSumSolutions = new TwoSumSolutions();
		System.out.println(Arrays.toString(twoSumSolutions.solutionBaek2(new int[] {2,3,4,7}, 6)));
		
		
//		int[]numbers = {1, 2, 3, 10};
//		int target = 11;
//		
//		List<Integer> list = quiz.solution1(numbers, target);
//		for(int i : list) {
//			System.out.println(i);
//		}
	}
	
//	public List<Integer> solution1 (int[]numbers, int target){
//		List<Integer> list = new ArrayList<>();
//		for(int i = 0; i<numbers.length; i++) {
//			for(int j = i+1; j<=numbers.length-1; j++) {
//				if(numbers[i]+numbers[j] == target) {
//					list.add(i);
//					list.add(j);
//				}
//			}
//		}
//		return list;
//	}
	
	//시간복잡도 O(N2)
	//공간 복잡도 O(1) : 항상 고정된 2개가 들어간다. 
	private int[] solutionBaek1(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				if(numbers[i] + numbers[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		//값이 없을 경우 면접관과 이야기 하기 
		return null;
	}
	
	//시간복잡도 O(N)
	//공간복잡도 O(N)
	private int[] solutionBaek2(int[] numbers, int target) {
		Map<Integer, Integer> numberMap = new HashMap<>();
		// 2 3 4 5, 6 찾기 (3을 중복해서 꺼내면 안된다)
		for (int i = 0; i < numbers.length; i++) {
			int numberToFind = target - numbers[i];
			if(numberMap.containsKey(numberToFind) && numberMap.get(numberToFind) != i) {
				return new int[] {i, numberMap.get(numberToFind)};
			}
			numberMap.put(numbers[i], i);
		}
		return null;
	}
	
}
