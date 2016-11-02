package kr.kirk.euler;


/*

1 ~ 10 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수는 2520입니다.

그러면 1 ~ 20 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수는 얼마입니까?	
*/

public class Problem5 {

		
	public static void main(String[] args) {

		System.out.println("========================================================");
		System.out.println(Problem5.solution(1,10));
		System.out.println("========================================================");
		System.out.println(Problem5.solution(1,20));
		System.out.println("========================================================");
	}

	private static long solution(long n, long m) {
		
		if ( n == m ) return n;
		
		long x = n;
		for ( long i = n+1; i<=m; ++i ) {
			x = lcm(x, i);
		}
		
		return x;
	}

	// 최소공배수
	private static long lcm(long x, long i) {
		
		if ( x == i ) return x;
		
		long big =  x > i ? x : i;
		long small = x > i ? i : x;
		
		long r = 1;
		
		while (r>0) {
			r = big % small;
			big = small;
			small = r;
		}
		
		return x * i / big;
	}

}
