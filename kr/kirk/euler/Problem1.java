package kr.kirk.euler;

import java.util.HashSet;


/*

10보다 작은 자연수 중에서 3 또는 5의 배수는 3, 5, 6, 9 이고, 이것을 모두 더하면 23입니다.

1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?

 */
public class Problem1 {

	public static void main(String[] args) {
		System.out.println("========================================================");
		System.out.println(Problem1.solution(3,5,10));
		System.out.println("========================================================");
		System.out.println(Problem1.solution(3,5,1000));
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
