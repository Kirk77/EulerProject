package kr.kirk.euler.p000;

/*
n과 d가 양의 정수이고 n<d인 분수 n/d을 GCD(n, d) = 1일 때 기약 진분수라고 부르기로 합니다.
d ≤ 8 인 기약 진분수들을 커지는 순으로 늘어놓으면 아래와 같고, 개수는 모두 21개입니다.

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

d ≤ 1,000,000 인 경우, 기약 진분수는 모두 몇 개나 있습니까?
*/
public class Problem072 {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(7));
		System.out.println(solution(8));
//		System.out.println(solution((int) Math.pow(10, 6)));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	private static long solution(int x) {

		long nCount = 0;
		for (int d=2; d<=x; d++) {
			nCount++;
			for (int n = 2; n < d; n++) {
				if (gcd(n, d) == 1) {
					nCount++;
				}
			}
		}
		return nCount;
	}
	
	private static long gcd(long x, long i) {
		
		if ( x == i ) return x;
		
		long big =  x > i ? x : i;
		long small = x > i ? i : x;
		
		long r = 1;
		
		while (r>0) {
			r = big % small;
			big = small;
			small = r;
		}
		
//		return x * i / big; // 최소공배수
		return big; // 최대공약수
	}
}