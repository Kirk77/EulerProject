package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.List;

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
//		System.out.println(solution(3));
		System.out.println(solution(5));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution(int x) {
		List<Long> result = new ArrayList<Long>();
		for (long i=345;;i++){
			result.clear();
			result.add(i);
			findCube(result,x);
			if (result.size()==x) {
				print(result);
				return i*i*i;
			}
		}
	}

	private static boolean findCube(List<Long> result, int x) {
		if ( result.size() == x) return true;
		long i = result.get(result.size()-1);
		for ( long k = i+1;;k++) {

			long kkk = k*k*k;
			long iii = i*i*i;
			int lk = String.valueOf(kkk).length();
			int li = String.valueOf(iii).length();
			if ( lk > li) return false;
			
			if ( checkNumbers(iii, kkk) && !result.contains(k)) {
				result.add(k);
				if ( findCube(result, x) == false){
					result.remove(result.size()-1);
				}
			}
		}
	}

	private static void print(List<Long> result) {
		for ( long t : result) System.out.println(t + "  " + t*t*t);
		System.out.println();
	}

	private static boolean checkNumbers(long c, long cc) {
		int[] p1 = countPosition(c);
		int[] p2 = countPosition(cc);
		
		for ( int i=0; i<10; i++) if ( p1[i] != p2[i]) return false;
		return true;
	}

	private static int[] countPosition(long c) {
		int[] p = new int[10];
		long d = c;
		int r = 0;
		while(d!=0) {
			r = (int) (d%10);
			d /=10;
			p[r]++;
		}
		return p;
	}
}