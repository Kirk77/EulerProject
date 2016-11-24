package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

어떤 대상을 순서에 따라 배열한 것을 순열이라고 합니다. 예를 들어 3124는 숫자 1, 2, 3, 4로 만들 수 있는 순열 중 하나입니다.

이렇게 만들 수 있는 모든 순열을 숫자나 문자 순으로 늘어놓은 것을 사전식(lexicographic) 순서라고 합니다.
0, 1, 2로 만들 수 있는 사전식 순열은 다음과 같습니다.

    012   021   102   120   201   210

0, 1, 2, 3, 4, 5, 6, 7, 8, 9로 만들 수 있는 사전식 순열에서 1,000,000번째는 무엇입니까?
 */

public class Problem024 {
	
	public static void main(String[] args) {
		System.out.println(Problem024.solution(1000000));
//		System.out.println(Problem24.solution(1));
	}

	private static String solution(int x) {
		List<Integer> card = new ArrayList<Integer>();  
		card.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		return getNumber(card, x);
	}
	
	
	private static String getNumber(List<Integer> card, int x) {
		
		if (card.size() == 2) {
			System.out.println( "x : " + x );
			
			if ( x < 2) {
				return card.get(0) + "" + card.get(1);
			}
			else {
				return card.get(1) + "" + card.get(0);
			}
		}
		
		int i=0;
		int cases = factorial(card.size()-1);
		int sum = 0;
		
		for (i=0; i<card.size(); i++) {
			sum += cases;
			
			System.out.println( "[" + card.get(i) + "/" + card.size() + "] : sum : " + sum);
			if ( sum >= x ) {
				sum -= cases;
				break;
			}
		}

		int ii = card.remove( i>0 ? i : 0);

		x-=sum;
		System.out.println("-------------------------------------> [" + ii + "] " + i + " , x : " + x + ",  sum : " + sum);
		return String.valueOf(ii) + getNumber(card, x );
	}

	private static int factorial(int n) {
		if ( n == 1) return 1;
		return n*(factorial(n-1));
	}
}
