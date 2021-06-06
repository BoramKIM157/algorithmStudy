package complexity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindUniqueNumber {
	/**
	 * 퀴즈 1) 유일한 숫자 찾기 
	 * numbers라는 int형 배열이 있다. 해당 배열에 들어있는 숫자들은 오직 한 숫자를 제외하고는 모두 두번 씩 들어 있다.
	 * 오직 한 번만 등장하는 숫자를 찾는 코드를 작성하라.
	 */
	
	public static void main(String[] args) {
		FindUniqueNumber findUniqueNumber = new FindUniqueNumber();
		int result = findUniqueNumber.solution3(new int[] {1,2,2,3,3});
		System.out.println(result == 1);
	}
	
	/**
	 * 해결 법 1
	 * List를 만들고 배열에 있는 숫자를 순회하면서 해당 숫자가 List에 들어 있는지 확인한다.
	 * List에 들어있으면 List에서 빼내고, 없으면 넣는다.
	 * 그럼 결과적으로 List에는 유일한 숫자만 들어 있으니 해당 숫자를 꺼내서 리턴한다.
	 * 
	 * 시간 복잡도: O(n) * O(n) => O(n²)
	 * 공간 복잡도: O(n) : 배열의 개수 만큼 list를 만든다. 숫자가 1~100까지 나오면, list가 쭉 커진다.
	 * list는 계속 변동한다.
	 */
	
	private int soulution1(int[] numbers) {
		List<Integer> list = new ArrayList<>();
		for(int num: numbers) { //O(n)
			if(list.contains(num)) { //list에 전부 순회한다. list를 전부 도는 for이다.
				list.remove((Integer) num);
			}else {
				list.add(num);
			}
		}
		
		return list.get(0);
	}
	
	/**
	 * HashMap을 사용해서 배열에 들어있는 숫자를 키, 숫자의 등장 횟수를 값으로 저장한다.
	 * 숫자의 등장 횟수가 1인 키값을 찾아서 리턴한다.
	 * 1 1
	 * 2 2
	 * 3 2
	 * 시간복잡도: O(n) + O(n) ==> O(2n) ==> O(n)
	 * 공간 복잡도: O(n) 배열의 크기만큼 늘어나게 된다.
	 */
	
	private int soulution2(int[] numbers) {
		HashMap<Integer, Integer> numbersMap = new HashMap<>();
		
		for(int num: numbers) { //O(n)
			numbersMap.put(num,  numbersMap.getOrDefault(num, 0)+1); //O(1) 전부 순회 필요없다.
		}
		
		for(int num: numbers) {
			if(numbersMap.get(num)==1) {
				return num;
			}
		}
		
		return 0;
	}
	
	/**
	 * XOR 비트 연산자 (^)를 사용하는 방법
	 * XOR 비트 연산자: 두 비트가 서로 다를 때 1 
	 * 5 ^ 0 = 5
	 * 
	 * 101
	 * 000
	 * ---
	 * 101 ==>5
	 * 
	 * 5^5= 0
	 * 
	 * 101
	 * 101
	 * ---
	 * 000 ==> 0
	 * 
	 * 1 ^ 5 ^ 1 = (1 ^ 1) ^ 5 = 0 ^ 5 = 5 //순서는 상관없다
	 * 
	 * 시간 복잡도: O(n) 순회를 한다.
	 * 공간 복잡도: O(1) 배열에 비례한 list, map이 없다. 고정적인 변수 한개만 사용한다.
	 */
	
	private int solution3(int[] numbers) {
		int uniqueNum = 0;
		for(int num: numbers) {
			uniqueNum ^=num;
		}
		return uniqueNum;
	}

}
