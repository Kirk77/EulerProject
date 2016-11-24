package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1부터 n까지의 숫자를 하나씩만 써서 만든 n자리 숫자를 팬디지털(pandigital)이라고 부릅니다.
2143은 4자리 팬디지털인데, 이 수는 동시에 소수이기도 합니다.

n자리 팬디지털 소수 중에서 가장 큰 수는 무엇입니까?


We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?

*/

public class Problem041 {
	
	static String[] list = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	static List<Integer> pandigitalList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		System.out.println(solution());
	}

	private static int solution() {
	
		for ( int i=9; i>-1; i--) {
			makePandigitalNumbers(Arrays.asList(list).subList(0, i), "");
		}

		for ( int p : pandigitalList) {
			
			double sqrt = Math.sqrt(p);
			boolean isPrime = true; 
			for ( int i=2; i<sqrt; i++) {
				if ( p%i == 0) { isPrime=false; break; }
			}
			if ( isPrime ) return p;
		}
		
		return -1;
	}

	private static String makePandigitalNumbers(List<String> l, String prev) {
		
		if ( l.size() == 1) return prev + l.get(0);
		
		for ( int i=l.size()-1; i>-1; i--) {
			List<String> subList = new ArrayList<String>(l);
			subList.remove(i);
			String pandigitalNumbers = makePandigitalNumbers(subList, prev + l.get(i));
			if (!pandigitalNumbers.isEmpty()) {
				int p = Integer.parseInt(pandigitalNumbers);
				if ( p%6 == 1 || p%6 == 5)	pandigitalList.add(p);
			}
		}
		return "";
	}
}