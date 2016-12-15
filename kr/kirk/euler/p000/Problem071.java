package kr.kirk.euler.p000;

/*

n과 d가 양의 정수이고 n<d인 분수 n/d을 GCD(n, d) = 1일 때 기약 진분수라고 부르기로 합니다.
d ≤ 8 인 기약 진분수들을 커지는 순으로 늘어놓으면 아래와 같습니다.

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

위에서 보듯이 3/7의 바로 앞에는 2/5가 오게 됩니다.

d ≤ 1,000,000 인 기약 진분수들을 커지는 순으로 늘어놓았을 때, 3/7 바로 앞에 오는 수의 분자는 얼마입니까?

*/

public class Problem071 {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(solution(8));
		System.out.println(solution( (int)Math.pow(10, 6)));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	
	private static long solution(int x) {

		double fd=5, fn=2;
		for (int d=2; d<=x; d++) {
			
			if ( d%1000==0) System.out.println(d);			
			int start = (int) (fn*d/fd);
			double limit = 3*d/(double)7;

			for ( int n= start ; n<limit; n++) {
				if ( fn/fd > (double)n/d ) continue;
				if ( gcm(n,d) == 1) {
					fn = n;
					fd = d;
				}
			}
		}
		System.out.println( (int)fn + "/" + (int)fd);
		return -1;
	}
	
	private static long gcm(long x, long i) {
		
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
