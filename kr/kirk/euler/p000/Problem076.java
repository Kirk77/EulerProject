package kr.kirk.euler.p000;

/*
숫자 5를 자연수의 합으로 나타내는 데는 모두 여섯 가지 방법이 있습니다.

4 + 1
3 + 2
3 + 1 + 1
2 + 2 + 1
2 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1

그러면 숫자 100을 두 개 이상의 자연수의 합으로 나타내는 방법은 모두 몇 가지나 됩니까?
f(1)=1	0		1
f(2)=2	1	1	2	11
f(3)=3	2	1	3	21	111
f(4)=5	4	2	4	31	22	211	1111
f(5)=7	6	2	5	41	32	311	221	2111	11111
f(6)=11	10	4	6	51	42	411	33	321	3111	222	2211	21111	111111
f(7)=15	14	4	7	61	52	511	43	421	4111	331	322	3211	31111	2221	22111	211111	1111111
*/
public class Problem076 {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution(5));
//		System.out.println(solution(100));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	private static long solution(int x) {
		long f1=1;
		long f2=1;
		long f3=0;
		for (long n=3; n<=x; n++) {
			f3 = f2 + f1;
			f1 = f2;
			f2 = f3;
		}
		
		return f3;
	}
}