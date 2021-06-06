package quizArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumSolutions {
	/*
	 * 문제, 3SUM 
	 * 숫자로 구성된 배열 numbers와 target 숫자 하나가 주어졌을 때 
	 * numbers 배열에 들어있는 수 세개를 더해서 target 숫자를 만들 수 있는 인덱스를 찾는 함수를 작성하라.
	 * 예) numbers = [2, 3, 5, 7] target = 10
	 * 10을 만들 수 있는 2, 3, 5의 인덱스인 0, 1, 2를 배열로 리턴해야 한다.
	 */
	public static void main(String[] args) {
		ThreeSumSolutions threeSumSolutions = new ThreeSumSolutions();
		System.out.println(Arrays.toString(threeSumSolutions.solution1(new int[] {2,3,6,7}, 16)));
	}
	
	
	//시간복잡도 O(N제곱)
	//공간복잡도 O(N)
	private int[] solution1(int[]numbers, int target) {
		Map<Integer, Integer> numberMap = new HashMap<>();
		//답이 점점 보인다. 답에 근접한 느낌이 든다. 나는 할 수 있다. 그러니까 조금만 더 생각해보자. 지금 다 해간다. 나는 할 수 있다. 
		
		for(int i = 0; i<numbers.length; i++) {
			for(int j = 0; j<numbers.length; j++) {
				int numberToFind = target - numbers[i] - numbers[j];
				if(numberMap.containsKey(numberToFind) && numberMap.get(numberToFind) != i && numberMap.get(numberToFind) != j) {
					return new int[] {i, j, numberMap.get(numberToFind)};
				}
			}
			numberMap.put(numbers[i], i);
		}
		return null;
	}
	// 세개의 숫자가 있다. 
	// 세개의 숫자를 더해야 한다. 세 개의 숫자를 더하면, 값이 나온다, 한개의 숫자를 확정지을 수 있을까? 
	//그냥 가정을 한 상태에서 한다면? 그냥 하나를 가정하고, 나머지 둘을 더해서 세개의 숫자를 더했을 떄 target의 값을 가지게 한다면? ?? 
	// 좀 그럴싸한데? 
	
}
