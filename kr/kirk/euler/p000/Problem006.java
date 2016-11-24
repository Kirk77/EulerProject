package kr.kirk.euler.p000;


/*

1부터 10까지 자연수를 각각 제곱해 더하면 다음과 같습니다 (제곱의 합).

    12 + 22 + ... + 102 = 385

1부터 10을 먼저 더한 다음에 그 결과를 제곱하면 다음과 같습니다 (합의 제곱).

    (1 + 2 + ... + 10)2 = 552 = 3025

따라서 1부터 10까지 자연수에 대해 "합의 제곱"과 "제곱의 합" 의 차이는 3025 - 385 = 2640 이 됩니다.

그러면 1부터 100까지 자연수에 대해 "합의 제곱"과 "제곱의 합"의 차이는 얼마입니까?

The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

public class Problem006 {

		
	public static void main(String[] args) {

		System.out.println("========================================================");
		System.out.println(Problem006.solution(1,10));
		System.out.println("========================================================");
		System.out.println(Problem006.solution(1,100));
		System.out.println("========================================================");
	}

	private static long solution(int n, int m) {
		
		long sum = 0;
		long sq = 0;
		for ( long i=n; i<=m; ++i) {
			sq += i*i; 
			sum += i;
		}
		return sum*sum - sq;
	}

}
