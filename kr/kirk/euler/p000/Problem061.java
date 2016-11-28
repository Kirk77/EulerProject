package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.List;

/*
삼각수, 사각수, 오각수 같은 다각수들은 아래의 공식으로 만들 수 있습니다.

삼각수	P3,n = n(n+1)/2	1, 3, 6, 10, 15, ...
사각수	P4,n = n2	1, 4, 9, 16, 25, ...
오각수	P5,n = n(3n−1)/2	1, 5, 12, 22, 35, ...
육각수	P6,n = n(2n−1)	1, 6, 15, 28, 45, ...
칠각수	P7,n = n(5n−3)/2	1, 7, 18, 34, 55, ...
팔각수	P8,n = n(3n−2)	1, 8, 21, 40, 65, ...
그런데 4자리 숫자 8128, 2882, 8281 (순서대로) 에는 세 가지의 재미있는 성질이 있습니다.

각 숫자들은 서로 꼬리를 물고 순환됩니다. 각 숫자의 뒤쪽 두 자리는 다음 숫자의 앞쪽 두 자리가 되는 식입니다.
각 숫자는 서로 다른 다각수인데, 여기서는 삼각수 (P3,127=8128), 사각수 (P4,91=8281), 오각수 (P5,44=2882)가 대응됩니다.
이런 성질을 갖는 4자리의 숫자 세 개는 이 숫자들이 유일합니다.
위와 같이 순환되면서 서로 다른 다각수(삼각수 ~ 팔각수)이기도 한 4자리 숫자 여섯 개의 유일한 순서쌍을 찾고, 그 합을 구하세요.

Triangle, square, pentagonal, hexagonal, heptagonal, and octagonal numbers are all figurate (polygonal) numbers and are generated by the following formulae:

Triangle	 	P3,n=n(n+1)/2	 	1, 3, 6, 10, 15, ...
Square	 	P4,n=n2	 	1, 4, 9, 16, 25, ...
Pentagonal	 	P5,n=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
Hexagonal	 	P6,n=n(2n−1)	 	1, 6, 15, 28, 45, ...
Heptagonal	 	P7,n=n(5n−3)/2	 	1, 7, 18, 34, 55, ...
Octagonal	 	P8,n=n(3n−2)	 	1, 8, 21, 40, 65, ...
The ordered set of three 4-digit numbers: 8128, 2882, 8281, has three interesting properties.

The set is cyclic, in that the last two digits of each number is the first two digits of the next number (including the last number with the first).
Each polygonal type: triangle (P3,127=8128), square (P4,91=8281), and pentagonal (P5,44=2882), is represented by a different number in the set.
This is the only set of 4-digit numbers with this property.
Find the sum of the only ordered set of six cyclic 4-digit numbers for which each polygonal type: triangle, square, pentagonal, hexagonal, heptagonal, and octagonal, is represented by a different number in the set.
*/

public class Problem061 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution());
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution(int x) {
		int k=0;
		List<Integer> l3 = new ArrayList<Integer>();
		for( int n=10;;n++) {
			k = n*( n+1)/2;
			if ( k > 9999) break;
			if ( k>1000) l3.add(k);
		}
		List<Integer> l4 = new ArrayList<Integer>();
		for( int n=10;;n++) {
			k = n*n;
			if ( k > 9999) break;
			if ( k>1000) l4.add(k);
		}
		List<Integer> l5 = new ArrayList<Integer>();
		for( int n=10;;n++) {
			k = n*( 3*n-1)/2;
			if ( k > 9999) break;
			if ( k>1000) l5.add(k);
		}
		List<Integer> l6 = new ArrayList<Integer>();
		for( int n=10;;n++) {
			k = n*( 2*n-1);
			if ( k > 9999) break;
			if ( k>1000) l6.add(k);
		}
		List<Integer> l7 = new ArrayList<Integer>();
		for( int n=10;;n++) {
			k = n*( 5*n-3)/2;
			if ( k > 9999) break;
			if ( k>1000) l7.add(k);
		}
		List<Integer> l8 = new ArrayList<Integer>();
		for( int n=10;;n++) {
			k = n*( 3*n-2);
			if ( k > 9999) break;
			if ( k>1000) l8.add(k);
		}
		return -1;
	}
}