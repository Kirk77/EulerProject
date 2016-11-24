package kr.kirk.euler.p000;

import java.util.HashMap;
import java.util.Map;

/*

양의 정수 n에 대하여, 다음과 같은 계산 과정을 반복하기로 합니다.

n → n / 2 (n이 짝수일 때)
n → 3 n + 1 (n이 홀수일 때)

13에 대하여 위의 규칙을 적용해보면 아래처럼 10번의 과정을 통해 1이 됩니다.

    13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

아직 증명은 되지 않았지만, 이런 과정을 거치면 어떤 수로 시작해도 마지막에는 1로 끝나리라 생각됩니다.
(역주: 이것은 콜라츠 추측 Collatz Conjecture이라고 하며, 이런 수들을 우박수 hailstone sequence라 부르기도 합니다)

그러면, 백만(1,000,000) 이하의 수로 시작했을 때 1까지 도달하는데 가장 긴 과정을 거치는 숫자는 얼마입니까?

참고: 계산 과정 도중에는 숫자가 백만을 넘어가도 괜찮습니다.
 */

public class Problem014 {

	static Map<Long, Integer> map = new HashMap<Long, Integer>();
	
	public static void main(String[] args) {
		
		
		System.out.println("========================================================");
		System.out.println(Problem014.solution(15));
		System.out.println(Problem014.solution(1000000));
	}

	private static long solution(long d) {
		
		map.clear();
		
		int n = 0;
		long result = d;
		
		int temp = 0;
		for (long i = d; i>0; --i) {
			
			temp = doFlow(i);
			
//			System.out.println(i + " : [" + temp + "]");
			
			if ( n < temp ) {
				n = temp;
				result = i;
			}
		}
		System.out.println("========================================================");
		System.out.println(result + " : [" + map.get(result) + "]");
		return result;
	}

	private static int doFlow(long i) { 

//		System.out.print( i + " > ");
		
		Integer findPrev = map.get(i);
		if (findPrev != null) return findPrev;
		
		if ( i == 1) return 1;
		
		long j = ( i % 2 == 0) ? (i/2) : (3*i+1);
		
		int k = doFlow(j)+1;
		map.put(i, k);
		
		return k;

	}
}
