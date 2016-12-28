package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.List;

/*
n개의 동전을 여러 더미로 나누는 경우의 수를 p(n)이라고 나타내기로 합니다.
예를 들어 동전 다섯 개는 아래와 같이 일곱 가지 방법으로 나눌 수 있으므로 p(5) = 7이 됩니다.
OOOOO
OOOO   O
OOO   OO
OOO   O   O
OO   OO   O
OO   O   O   O
O   O   O   O   O

p(n)이 1백만으로 나누어 떨어지는 가장 작은 n의 값은 얼마입니까?
*/
public class Problem078 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution(1000000));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution(long x) {
		for (int i = 1;; i++) {
			if (count(i) % x == 0)
				return i;
		}
	}
	
	private static long count(long x) {
		List<Long> list = new ArrayList<Long>();
		for (long i = 1; i <= x; i++)
			list.add(i);
		long l = getCount(list, x);
		System.out.println( x + " : " + l);
		return l;
	}

	private static long getCount(List<Long> list, long x) {
		if (list.size() == 1)
			return 1;

		long nCount = 0;
		long unit = list.get(list.size() - 1);

		for (int i = 0; i <= x; i += unit) {
			nCount += getCount(list.subList(0, list.size() - 1), x - i);
		}
		return nCount;
	}
}