package kr.kirk.euler;

/*

숫자 192에 1, 2, 3을 각각 곱합니다.

    192 × 1 = 192
    192 × 2 = 384
    192 × 3 = 576 

곱한 결과를 모두 이어보면 192384576 이고, 이것은 1 ~ 9 팬디지털(pandigital)인 숫자입니다. 이런 과정을 편의상 '곱해서 이어붙이기'라고 부르기로 합니다.

같은 식으로 9와 (1, 2, 3, 4, 5)를 곱해서 이어붙이면 918273645 라는 1 ~ 9 팬디지털 숫자를 얻습니다.

어떤 정수와 (1, 2, ... , n)을 곱해서 이어붙였을 때 얻을 수 있는 가장 큰 아홉자리의 1 ~ 9 팬디지털 숫자는 무엇입니까? (단 n > 1)



Take the number 192 and multiply it by each of 1, 2, and 3:

    192 × 1 = 192
    192 × 2 = 384
    192 × 3 = 576

By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?


*/

public class Problem038 {
	
	static String[] list = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	
	public static void main(String[] args) {
		System.out.println(Problem038.solution());
	}

	private static int solution() {
		StringBuffer sb = new StringBuffer();
		for (int n=99999; n>1;n--) {
			sb.setLength(0);
			for (int p=1; p<10; p++) {
				sb.append(n * p);
				if ( p == 1) continue;
				if ( sb.length() > list.length ) break;
				if ( isPanDigital(sb)) {
					return Integer.parseInt(sb.toString());
				}
			}
		}
		return -1;
	}

	private static boolean isPanDigital(StringBuffer sb) {
		
		if ( sb.length() != list.length ) return false;
		for (String a : list) {
			if (sb.indexOf(a) < 0) return false;
		}
		return true;
	}
}