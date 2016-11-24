package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
1부터 n까지의 각 숫자를 한번씩만 써서 만들 수 있는 숫자를 팬디지털(pandigital)이라고 합니다.
예를 들면 15234는 1부터 5의 숫자가 한번씩만 쓰였으므로 1 ~ 5 팬디지털입니다.

7254라는 숫자는 그런 면에서 특이한데, 39 × 186 = 7254 라는 곱셈식을 만들 때 이것이 1 ~ 9 팬디지털이 되기 때문입니다.

이런 식으로 a × b = c 가 1 ~ 9 팬디지털이 되는 모든 c의 합은 얼마입니까?

(참고: 어떤 c는 두 개 이상의 (a, b)쌍에 대응될 수도 있는데, 이런 경우는 하나로 칩니다)

We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
*/

public class Problem032 {

	static HashSet<Integer> pSet = new HashSet<Integer>();
	public static void main(String[] args) {
		System.out.println(Problem032.solution());
	}

	private static long solution() {
		String[] list = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "x", "="};
//		String[] list = {"1", "2", "3"};
		pandigitalExpressions("", Arrays.asList(list));
		
		long sum = 0;
		for ( int c : pSet) sum += c;
		return sum;
	}

	private static String pandigitalExpressions(String s, List<String> list) {
		if ( list.size() == 1) return s + list.get(0);
		
		for ( int i=0; i<list.size(); ++i) {
			List<String> subList = copyWithoutOne(list, i);
			String str = pandigitalExpressions(s + list.get(i), subList);
			checkExpressions(str);
		}
		return "";
	}

	private static void checkExpressions(String str) {
		int x = str.indexOf('x');
		int e = str.indexOf('=');
		
		if ( x<1 || e<1 || str.endsWith("=") || str.endsWith("x") || x>e || x - e == 1 || x - e == -1) return;
		
		int a = Integer.valueOf(str.substring(0, x));
		int b = Integer.valueOf(str.substring(x+1, e));
		int c = Integer.valueOf(str.substring(e+1));
		
		if ( a * b == c ) {
			System.out.println( str );
			pSet.add(c);
		}
		
	}

	private static List<String> copyWithoutOne(List<String> l, int i) {
		List<String> newList = new ArrayList<String>();
		newList.addAll(l);
		newList.remove(i);
		return newList ;
	}

	
}