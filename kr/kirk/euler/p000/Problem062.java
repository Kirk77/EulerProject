package kr.kirk.euler.p000;

/*

The cube, 41063625 (3453), can be permuted to produce two other cubes: 56623104 (3843) and 66430125 (4053).
In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.

Find the smallest cube for which exactly five permutations of its digits are cube.


세제곱수인 41063625 (=3453) 로 순열을 만들어보면, 그 중에서 56623104 (=3843)와 66430125 (=4053)가 또 세제곱수입니다.
실제 41063625은, 자릿수로 만든 순열 중에서 3개가 세제곱수인 가장 작은 수입니다.

그러면 자릿수로 만든 순열 중에서 5개가 세제곱수인 가장 작은 숫자는 무엇입니까?
 */
public class Problem062 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution(3));
//		System.out.println(solution(5));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution(int x) {
		return -1;
	}
}