package kr.kirk.euler.p000;

import java.util.HashMap;
import java.util.Map;


/*
분자가 1인 분수를 단위분수라고 합니다. 분모가 2에서 10까지의 단위분수는 아래와 같습니다.

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1

숫자 위에 찍힌 점은 순환마디를 나타내는데, 1/6의 경우 순환마디는 "6"으로 0.166666...처럼 6이 무한히 반복됨을 뜻합니다. 같은 식으로 1/7은 6자리의 순환마디(142857)를 가집니다.

d 를 1000 이하의 정수라고 할 때, 단위분수 1/d 의 순환마디가 가장 긴 수는 무엇입니까?


A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1

Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
*/

public class Problem026 {
	
	static Map<Integer, Integer> map = new HashMap<Integer,Integer>();
	
	public static void main(String[] args) {
//		System.out.println(Problem026.solution(10));
		System.out.println(Problem026.solution(1000));
	}

	private static String solution(int x) {
		
		int z = 0;
		String r = "";
		for ( int i=2; i<x; ++i) {
			String r2 = getRecurringCycle(i);
			
			if ( r.length() < r2.length() ) {
				r = r2;
				z = i;
			}
		}
		return z + " : " + r;
	}

	private static String getRecurringCycle(int i) {
		System.out.print(i + " : ");
		map.clear();
		
		String cycle = "";
		int d = 0;
		int r = 10;
		while (r != 0) {
			if (i > r) r*= 10;
			d = r / i;
			r = r % i;
					
			if ( map.get(r) != null ) break;
			cycle += d;
			System.out.print(d);
			map.put(r, r);
		}
		System.out.println();
		return cycle;
	}
}