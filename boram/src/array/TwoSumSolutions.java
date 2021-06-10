package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumSolutions {
	//시간 복잡도 O(N2) : 이중 for문
	//공간 복잡도 O(1) : return 배열 1개
	public static int[] solution1(int[] numbers, int target) {
		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				if(numbers[i]+numbers[j] == target) {
					return new int[] {i,j}; 
				}
			}
		}
		return null;
	}
	
	//시간 복잡도 : O(N) : for문 
	//공간 복잡도 : O(N) : HashMap생성 
	public static int[] solution2(int[] numbers, int target) {
		 Map<Integer, Integer> map = new HashMap<>();
		 for(int i=0; i<numbers.length; i++) {
			 map.put(numbers[i], i); //키 - array 요소, value - 인덱스번호
			 int numToFind = target - numbers[i]; //  array[i] + x = target
			 //map이 키로 numbers의 요소를 가지고 있고 
			 //numToFind와 현재 인덱스가 번호가 같지 않다면 (중복 제거)
			 if(map.containsKey(numToFind) && map.get(numToFind) != i) {  
				return new int[] {map.get(numToFind), i}; //key와 value 리턴 (numbers와 인덱스번호)
			 }
		 }
		 return null;
	}
	
	public static void main(String[] args) {
		int[] numbers = {2, 3, 4, 7};
		int target = 6;
		System.out.println(Arrays.toString(solution1(numbers, target)));
		System.out.println(Arrays.toString(solution2(numbers, target)));
	}
}
