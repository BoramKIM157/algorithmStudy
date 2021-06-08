package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {
	//숫자로 구성된 배열이 주어졌을 때, 그 배열에 중복된 숫자 존재하는지.
		//중복 O : true, 중복 X : false
		//예) 1 2 3 4 5 6 : false
		//예) 1 1 2 2 3 1 : true
	public static boolean solution1(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] == nums[j]) {
					System.out.println(nums[i]+","+nums[j]);
					return true;
				}
			}
		}
		return false;
	}
	
	//정렬 후 순회를 1번하는 것이 더 빠름 > 이중 for문 
	public static boolean solution2 (int[] nums) {
		Arrays.sort(nums); ; //퀵 정렬 - 시간 복잡도 : O(NlogN), 
								//	- 공간 복잡도 : O(logN)
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	//정렬하지 않고 set에 담기 
	//set은 중복 허용X, hash값으로 조회, 복잡도 O(1), contains메서드로 element확인 가능 
	//set에 담기면 false, 담기지 않으면 true
	public static boolean solution3(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		for(int num : nums) {
			if(numSet.contains(num)) {
				return true;
			}else {
				numSet.add(num);
			}
			System.out.println(num);
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3, 5};
		System.out.println(solution1(nums));
		System.out.println(solution2(nums));
		System.out.println(solution3(nums));
	}
}
