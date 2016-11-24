package kr.kirk.euler.p000;

import java.util.HashSet;


/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.


10보다 작은 자연수 중에서 3 또는 5의 배수는 3, 5, 6, 9 이고, 이것을 모두 더하면 23입니다.

1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?

 */
public class Problem001 {

	public static void main(String[] args) {
		System.out.println("========================================================");
		System.out.println(Problem001.solution(3,5,10));
		System.out.println("========================================================");
		System.out.println(Problem001.solution(3,5,1000));
		System.out.println("========================================================");

	}

	private static long solution(int x, int y, int l) {
		long sum = 0;
		
		HashSet<Integer> e = new HashSet<Integer>();
		
		getMultiples(x,l, e);
		getMultiples(y,l, e);
		
		for ( int n : e) {
//			System.out.print( n + ", " );
			sum += n;
		}
		
		return sum;
	}

	private static void getMultiples(int x, int l, HashSet<Integer> e) {
		
		for ( int i=1; x*i < l; ++i) {
			e.add(x*i);
		}
		
	}

}
