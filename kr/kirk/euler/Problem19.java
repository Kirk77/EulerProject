package kr.kirk.euler;

/*

다음은 달력에 관한 몇 가지 일반적인 정보입니다 (필요한 경우 좀 더 연구를 해 보셔도 좋습니다).

    1900년 1월 1일은 월요일이다.
    4월, 6월, 9월, 11월은 30일까지 있고, 1월, 3월, 5월, 7월, 8월, 10월, 12월은 31일까지 있다.
    2월은 28일이지만, 윤년에는 29일까지 있다.
    윤년은 연도를 4로 나누어 떨어지는 해를 말한다. 하지만 400으로 나누어 떨어지지 않는 매 100년째는 윤년이 아니며, 400으로 나누어 떨어지면 윤년이다

20세기 (1901년 1월 1일 ~ 2000년 12월 31일) 에서, 매월 1일이 일요일인 경우는 총 몇 번입니까?
 */


/*
    1. 서력 기원 연수가 4로 나누어 떨어지는 해는 윤년으로 한다.(2004년, 2008년, 2012년, 2016년, 2020년, 2024년 …)
    2. 이 중에서 100으로 나누어 떨어지는 해는 평년으로 한다.(1900년, 2100년, 2200년, 2300년, 2500년 …)
    3. 그중에 400으로 나누어 떨어지는 해는 윤년으로 둔다.(1600년, 2000년, 2400년 …)


 */
public class Problem19 {
	
	public enum Day {
		
		MON(0), TUE(1), WED(2), THU(3), FRI(4), SAT(5), SUN(6);
		
		private int day;
		
		private Day(int i) { this.day = i; }
		
		public int getDay() { return day;}
		
		public static Day getDay(int i) {
			switch (i) {
				case 0: return MON;
				case 1: return TUE;
				case 2: return WED;
				case 3: return THU;
				case 4: return FRI;
				case 5: return SAT;
				default: return SUN;
			}
		}
	}
	
	public static void main(String[] args) {

		System.out.println( solution(1901, 2000));
	}

	private static int solution(int a, int b) {
		
		int nCount = 0;
		for ( int y=a; y<=b; ++y) {
			for (int m=1; m<=12; ++m) {
				if (getTheDay(y,m,1) == Day.SUN)
					nCount++;
			}
		}
		return nCount;
	}

	private static Day getTheDay(int y, int m, int d) {

		return Day.SUN;
	}
 
}
