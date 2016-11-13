package kr.kirk.euler;

import java.util.HashSet;

/*
n의 약수들 중에서 자신을 제외한 것의 합을 d(n)으로 정의했을 때,
서로 다른 두 정수 a, b에 대하여 d(a) = b 이고 d(b) = a 이면
a, b는 친화쌍이라 하고 a와 b를 각각 친화수(우애수)라고 합니다.

예를 들어 220의 약수는 자신을 제외하면 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110 이므로 그 합은 d(220) = 284 입니다.
또 284의 약수는 자신을 제외하면 1, 2, 4, 71, 142 이므로 d(284) = 220 입니다.
따라서 220과 284는 친화쌍이 됩니다.

10000 이하의 친화수들을 모두 찾아서 그 합을 구하세요.
 */

public class Problem021 {
	
	public static void main(String[] args) {
		System.out.println(Problem021.solution(10000));
	}

	private static int d(int n) {
		int sum = 0;
		for ( int i=1; i<n; i++) {
			if ( n % i == 0)
				sum +=i;
		}
		return sum;
	}

	private static int solution(int m) {
		
		HashSet<Integer> numbers = new HashSet<Integer>();
		
		for ( int i=2; i<=m; i++) {
			int d = d(i);
			if ( i == d) continue;
			if ( i == d(d)) {
				numbers.add(i);
				numbers.add(d);
			}
		}
		
		int sum = 0;
		for ( int d : numbers ) {
			sum += d;
		}
		
		return sum;
	}
}
