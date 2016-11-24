package kr.kirk.euler.p000;


/*

피보나치 수열의 각 항은 바로 앞의 항 두 개를 더한 것이 됩니다. 1과 2로 시작하는 경우 이 수열은 아래와 같습니다.

    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ... 

짝수이면서 4백만 이하인 모든 항을 더하면 얼마가 됩니까?


Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
public class Problem002 {

	public static void main(String[] args) {

		System.out.println(Problem002.solution(4000000));

	}

	private static long solution(int d) {
		
		int a = 1;
		int b = 2;
		int temp = 0;
		
		int sum = 0;
		
		do {
			if ( b % 2 == 0) sum +=b;
			
			temp = b;
			b = a + b;
			a = temp;
			
		} while ( b <= d );
		
		return sum;
	}
}