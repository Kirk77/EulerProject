package kr.kirk.euler.p000;

import java.math.BigInteger;
import java.util.HashSet;

/*
2 ≤ a ≤ 5 이고 2 ≤ b ≤ 5인 두 정수 a, b로 만들 수 있는 a^b의 모든 조합을 구하면 다음과 같습니다.

22=4,  23=8,  24=16,  25=32
32=9,  33=27,  34=81,  35=243
42=16,  43=64,  44=256,  45=1024
52=25,  53=125,  54=625,  55=3125
여기서 중복된 것을 빼고 크기 순으로 나열하면 아래와 같은 15개의 숫자가 됩니다.

4,  8,  9,  16,  25,  27,  32,  64,  81,  125,  243,  256,  625,  1024,  3125

그러면, 2 ≤ a ≤ 100 이고 2 ≤ b ≤ 100인 a, b를 가지고 만들 수 있는 a^b는 중복을 제외하면 모두 몇 개입니까?

Consider all integer combinations of a^b for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:

22=4, 23=8, 24=16, 25=32
32=9, 33=27, 34=81, 35=243
42=16, 43=64, 44=256, 45=1024
52=25, 53=125, 54=625, 55=3125
If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:

4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125

How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?
*/

public class Problem029 {
	
	public static void main(String[] args) {
		System.out.println(Problem029.solution(2,5));
		System.out.println(Problem029.solution(2,100));
	}

	private static long solution(int a, int b) {
		HashSet<BigInteger> set = new HashSet<BigInteger>();
		
		for ( int i=a; i<=b; i++) {
			for ( int j=a; j<=b; j++) {
				set.add(BigInteger.valueOf(i).pow(j));
			}
		}
		return set.size();
	}
}