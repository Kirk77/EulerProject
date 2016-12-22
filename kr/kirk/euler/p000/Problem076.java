package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
숫자 5를 자연수의 합으로 나타내는 데는 모두 여섯 가지 방법이 있습니다.

4 + 1
3 + 2
3 + 1 + 1
2 + 2 + 1
2 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1

그러면 숫자 100을 두 개 이상의 자연수의 합으로 나타내는 방법은 모두 몇 가지나 됩니까?
*/
public class Problem076 {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution(5));
		System.out.println(solution(100));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	private static long solution(long x) {
		List<Long> list = new ArrayList<Long>();
		for ( long i = 1; i<x; i++) list.add(i);
		return getCount( list, x);
	}

	private static long getCount(List<Long> list, long x) {
		if ( list.size() ==1 ) return 1;
		
		long nCount = 0;
		long unit = list.get(list.size()-1);
		
		for ( int i = 0; i<=x; i+=unit) {
			nCount += getCount( list.subList(0,list.size()-1), x-i);
		}
		return nCount;
	}
}