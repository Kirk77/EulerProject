package kr.kirk.euler.p000;

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
public class Problem019 {
	
	public enum Day {
		
		MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);
		
		private int day;
		
		private Day(int i) { this.day = i; }
		
		public int getDay() { return day;}
		
		public static Day getDay(int i) {
			switch (i) {
				case 1: return MON;
				case 2: return TUE;
				case 3: return WED;
				case 4: return THU;
				case 5: return FRI;
				case 6: return SAT;
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

	private static Day getTheDay(int year, int month, int day) {
		
		int days = 0;
		
		for ( int y=1900; y<year; ++y) {
			days += isLeapYear(y) ? 366 : 365; 
		}
		
		for ( int m=1; m<month; ++m) {
			switch(m) {
			case 4:
			case 6:
			case 9:
			case 11:
				days += 30;
				break;
				
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days += 31;
				break;
				
			case 2:
				days += isLeapYear(year) ? 29 : 28 ;
				break;
			}
		}
		
		days += day;

		return Day.getDay(days % 7);
	}

	private static boolean isLeapYear(int y) {
		if ( y % 400 == 0 ) return true;
		if ( y % 100 == 0 ) return false;
		if ( y % 4 == 0 ) return true;
		return false;
	} 
}
