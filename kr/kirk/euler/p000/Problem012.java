package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.List;

/*

1부터 n까지의 자연수를 차례로 더하여 구해진 값을 삼각수라고 합니다.
예를 들어 7번째 삼각수는 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28이 됩니다.
이런 식으로 삼각수를 구해 나가면 다음과 같습니다.

    1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

이 삼각수들의 약수를 구해봅시다.

     1: 1
     3: 1, 3
     6: 1, 2, 3, 6
    10: 1, 2, 5, 10
    15: 1, 3, 5, 15
    21: 1, 3, 7, 21
    28: 1, 2, 4, 7, 14, 28 

위에서 보듯이, 5개 이상의 약수를 갖는 첫번째 삼각수는 28입니다.

그러면 500개 이상의 약수를 갖는 가장 작은 삼각수는 얼마입니까?
 */

public class Problem012 {

	public static void main(String[] args) {
		
		System.out.println("========================================================");
		System.out.println(Problem012.solution(5));
		System.out.println("========================================================");
		System.out.println(Problem012.solution(500));	
	}

	private static long solution(long d) {
		
		long t = 0;
		for ( long i=1;; ++i ) {
			t += i;
			if ( getDCount(t) >= d) break;
		}
		
		return t;
	}

	private static long getDCount(long t) {
		
		System.out.print(t + " :::::: ");
		int factorCount = 0;
		double sqrt = Math.sqrt(t);
		
		for ( long i=1; i<=sqrt; ++i ) {
			
			if (i*i == t) {
			 
				factorCount++;
				break;
			}
			
			if (t % i == 0) {
				System.out.print( i + ",");
				factorCount += 2;
			}
		}
		
		System.out.println( ",, " + factorCount );
		return factorCount;
	}
}
