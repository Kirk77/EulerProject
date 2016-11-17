package kr.kirk.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

숫자 1406357289은 0 ~ 9 팬디지털인데, 부분열에 관련된 재미있는 성질을 가지고 있습니다.

d1을 첫째 자리수, d2를 둘째 자리수...라고 했을 때, 다음과 같은 사실을 발견할 수 있습니다.

    d2 d3 d4 = 406 → 2로 나누어 떨어짐
    d3 d4 d5 = 063 → 3으로 나누어 떨어짐
    d4 d5 d6 = 635 → 5로 나누어 떨어짐
    d5 d6 d7 = 357 → 7로 나누어 떨어짐
    d6 d7 d8 = 572 → 11로 나누어 떨어짐
    d7 d8 d9 = 728 → 13으로 나누어 떨어짐
    d8 d9 d10 = 289 → 17로 나누어 떨어짐

위와 같은 성질을 갖는 0 ~ 9 팬디지털을 모두 찾아서 그 합을 구하면 얼마입니까?



The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

    d2d3d4=406 is divisible by 2
    d3d4d5=063 is divisible by 3
    d4d5d6=635 is divisible by 5
    d5d6d7=357 is divisible by 7
    d6d7d8=572 is divisible by 11
    d7d8d9=728 is divisible by 13
    d8d9d10=289 is divisible by 17

Find the sum of all 0 to 9 pandigital numbers with this property.

*/

public class Problem043 {
	static String[] list = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9"};
	static int[] primes = {2,3,5,7,11,13,17};
	static List<String> pandigitalList = new ArrayList<String>();
	
	public static void main(String[] args) {
		System.out.println(solution());
	}

	private static long solution() {
		
		makePandigitalNumbers(Arrays.asList(list),"");
		
		long sum = 0;
		for (String p : pandigitalList) {
			System.out.println(p);
			sum += Long.parseLong(p);
		}
		return sum;
	}
	
	private static String makePandigitalNumbers(List<String> l, String prev) {
		
		if ( l.size() == 1) return prev + l.get(0);
		
		for ( int i=l.size()-1; i>-1; i--) {
			List<String> subList = new ArrayList<String>(l);
			subList.remove(i);
			String pandigitalNumbers = makePandigitalNumbers(subList, prev + l.get(i));
			if (!pandigitalNumbers.isEmpty() && checkNumber(pandigitalNumbers)) {
				pandigitalList.add(pandigitalNumbers);
			}
		}
		return "";
	}

	private static boolean checkNumber(String pandigitalNumbers) {
		if ( pandigitalNumbers.charAt(0) == '0' ) return false;
		for ( int i=1; i<=primes.length; i++) {			
			int p = Integer.parseInt(String.format("%c%c%c", pandigitalNumbers.charAt(i),pandigitalNumbers.charAt(i+1),pandigitalNumbers.charAt(i+2)));
			if ( p % primes[i-1] != 0 ) return false;
		}
		return true;
	}
}